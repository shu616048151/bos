package bos.action;

import java.io.IOException;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import bos.base.action.BaseAction;
import bos.domain.Staff;
import bos.service.StaffService;
import bos.utils.BosUtils;
import bos.utils.PageBean;
import bos.utils.jsonUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff>{

	@Autowired
	private StaffService staffService;
	public String add(){
		//添加员工的信息
		staffService.add(model);
		return list;
	}
	public void list(){
		detachedCriteria.add(Restrictions.eq("deltag", "0"));
		pageBean.setDetachedCriteria(detachedCriteria);
		PageBean pageBean2=staffService.findListByQuery(pageBean);
		objecttojson(pageBean2,new String[]{"currentPage","detachedCriteria","pageSize","decideZones"});
	}
	
	public String ids;
	public void delete(){
		//得到IDS的数组
		String[] idArr = ids.split(",");
		staffService.delStaff(idArr);
	}
	public void edit(){
		//数据库的数据
		Staff staff= staffService.findStaffById(model.getId());
		//选择性更新避免修改外键关系
		staff.setName(model.getName());
		staff.setTelephone(model.getTelephone());
		staff.setStandard(model.getStandard());
		staff.setStation(model.getStation());
		staff.setHaspda(model.getHaspda());
		staffService.update(staff);
	}
	public void listajax(){
		detachedCriteria.add(Restrictions.eq("deltag", "0"));
		pageBean.setDetachedCriteria(detachedCriteria);
		PageBean pageBean2=staffService.findListByQuery(pageBean);
		List<Staff> staffList = pageBean2.getRows();
		String json = jsonUtils.arraytojson(staffList,new String[]{"decideZones"});
		write(json);
	}
	
}
