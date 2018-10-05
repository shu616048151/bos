package bos.action;

import java.util.List;

import org.apache.xml.resolver.apps.resolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import bos.base.action.BaseAction;
import bos.domain.Function;
import bos.service.FunctionSercive;
import bos.utils.jsonUtils;
@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function>{
	@Autowired
	private FunctionSercive functionService;
	
	public String listajax(){
	List<Function>	functionList =functionService.findAll();
		String json = jsonUtils.arraytojson(functionList,new String[]{"parentFunction","roles"});
		write(json);
		return NONE;
	}
	public String add(){
		Function parent= model.getParentFunction();
		if (parent!=null&&parent.getId().equals("")) {
			model.setParentFunction(null);
		}
		functionService.save(model);
		return "addSuccess";
	}
	public void list(){
		//page数据会封装给function的怕个属性，重新进行封装
		pageBean.setCurrentPage(Integer.parseInt(model.getPage()));
		functionService.query(pageBean);
		objecttojson(pageBean, new String[]{"parentFunction","roles","children"});
		
	}
}
