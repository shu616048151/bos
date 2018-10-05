package bos.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import bos.base.action.BaseAction;
import bos.domain.Region;
import bos.domain.Subarea;
import bos.service.SubareaService;
import bos.utils.FileUtils;
import bos.utils.jsonUtils;
@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea>{
	@Autowired
	private SubareaService subareaService;
	public String add(){
		subareaService.save(model);
		return "addSUCCESS";
	}
	public void list(){
		//设置查询条件
		DetachedCriteria dc=detachedCriteria;
		Region region=model.getRegion();
		//添加城市查询条件
		if (region!=null) {
		String province=region.getProvince();
		//设置别名
		dc.createAlias("region", "r");
		if (StringUtils.isNotBlank(province)) {
			dc.add(Restrictions.like("r.province", "%"+province+"%"));
		}
		String city=region.getCity();
		if (StringUtils.isNotBlank(city)) {
			dc.add(Restrictions.like("r.city",  "%"+city+"%"));
		}
		String district=region.getDistrict();
		if (StringUtils.isNotBlank(district)) {
			dc.add(Restrictions.like("r.district",  "%"+district+"%"));
		}
		}
		pageBean.setDetachedCriteria(dc);
		subareaService.query(pageBean);
		objecttojson(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","decideZone","subareas"});
	}
	
	public String outpitxls(){
		//导出对应的数据
		List<Subarea> subareaList=subareaService.findAll();
		HSSFWorkbook workbook=new HSSFWorkbook();
		//创建片区
		HSSFSheet sheet = workbook.createSheet("分区数据");
		//创建行
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("分区编号");
		row.createCell(1).setCellValue("开始编号");
		row.createCell(2).setCellValue("结束编号");
		row.createCell(3).setCellValue("位置信息");
		row.createCell(4).setCellValue("省市区");
		for (Subarea subarea : subareaList) {
			HSSFRow row2= sheet.createRow(sheet.getLastRowNum()+1);
			row2.createCell(0).setCellValue(subarea.getId());
			row2.createCell(1).setCellValue(subarea.getStartnum());
			row2.createCell(2).setCellValue(subarea.getEndnum());
			row2.createCell(3).setCellValue(subarea.getPosition());
			row2.createCell(4).setCellValue(subarea.getRegion().getName());
		}
		String filename="分区数据.xls";
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		//得到文件的类型
		String contentType = ServletActionContext.getServletContext().getMimeType(filename);
		response.setContentType(contentType);
		try {
			filename = FileUtils.encodeDownloadFilename(filename, request.getHeader("User-Agent"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.addHeader("content-disposition", "attachment;filename="+filename);
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			workbook.write(outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
	public String listajax(){
		
		List<Subarea> subareaList = subareaService.findListNoAssociation();
		String json = jsonUtils.arraytojson(subareaList, new String[]{"region","decideZone"});
		write(json);
		return NONE;
	}
}
