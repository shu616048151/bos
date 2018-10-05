package bos.base.action;


import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import bos.domain.Region;
import bos.utils.PageBean;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	protected final String list="list";
	
	protected T model;
	protected DetachedCriteria detachedCriteria=null;
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	public BaseAction(){
		Type genType = getClass().getGenericSuperclass();
		Type[] actualTypeArguments = ((ParameterizedType)genType).getActualTypeArguments();
		Class<T> entityclass=(Class<T>) actualTypeArguments[0];
		detachedCriteria=DetachedCriteria.forClass(entityclass);
		pageBean.setDetachedCriteria(detachedCriteria);
		try {
			model = entityclass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected int page;
	protected int rows;
	protected PageBean pageBean=new PageBean();

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public void objecttojson(PageBean pageBean,String[] strings){
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(strings);
		JSONObject fromObject = JSONObject.fromObject(pageBean, jsonConfig);
		String json=fromObject.toString();
		write(json);
		
	}
	public void write(Object object ){
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/json;charset=utf-8");
			response.getWriter().write(object.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setPage(int page) {
		pageBean.setCurrentPage(page);
	}

	public void setRows(int rows) {
		pageBean.setPageSize(rows);
	}
	
}
