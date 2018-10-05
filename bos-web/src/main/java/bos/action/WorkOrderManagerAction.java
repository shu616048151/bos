package bos.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import bos.base.action.BaseAction;
import bos.domain.WorkOrderManage;
import bos.service.WorkOrderManageService;

@Controller
@Scope("prototype")
public class WorkOrderManagerAction extends BaseAction<WorkOrderManage>{
	@Autowired
	private WorkOrderManageService workOrderManageService;
	public String add(){
		String f="1";
		try{
		workOrderManageService.save(model);
		}catch(Exception e){
			e.printStackTrace();
			f="0";
		}
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().write(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}

}
