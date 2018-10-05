package bos.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import bos.base.action.BaseAction;
import bos.domain.NoticeBill;
import bos.domain.User;
import bos.service.Customer;
import bos.service.CustomerService;
import bos.service.NoticeBillService;
import bos.utils.BosUtils;
import bos.utils.jsonUtils;
@Scope("prototype")
@Controller
public class NoticeBillAction extends BaseAction<NoticeBill>{
	@Autowired
	private CustomerService customerService;
	@Autowired
	private NoticeBillService noticeBillService;
	
	
	public String findCustomerBytelephone(){
		Customer customer = customerService.findCustomerByTelephone(model.getTelephone());
		String json = jsonUtils.objecttojson(customer, new String[]{});
		write(json);
		return NONE;
	}
	public String add(){
		//封装用户信息
		User loginUser = BosUtils.getLoginUser();
		model.setUser(loginUser);
		noticeBillService.save(model);
		return "addSuccess";
		
	}
}
