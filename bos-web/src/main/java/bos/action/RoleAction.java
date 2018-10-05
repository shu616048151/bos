package bos.action;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import bos.base.action.BaseAction;
import bos.domain.Role;
import bos.service.RoleService;
import bos.utils.jsonUtils;
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role> {
	@Autowired
	private RoleService roleService;
	private String functionIds;
	
	public void setFunctionIds(String functionIds) {
		this.functionIds = functionIds;
	}
	public String add(){
		roleService.save(model,functionIds);
		return "addSuccess";
	}
	public String list(){
		roleService.pageBean(pageBean);
		objecttojson(pageBean, new String[]{"functions","users"});
		return NONE;
	}
	public void findAll(){
		List<Role> roleList=roleService.findRoleAll();
		String arraytojson = jsonUtils.arraytojson(roleList, new String[]{"functions","users"});
		write(arraytojson);
	}

}
