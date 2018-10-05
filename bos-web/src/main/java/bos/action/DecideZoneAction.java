package bos.action;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import bos.base.action.BaseAction;
import bos.domain.DecideZone;
import bos.domain.Subarea;
import bos.service.Customer;
import bos.service.CustomerService;
import bos.service.DecideZoneService;
import bos.service.SubareaService;
import bos.utils.jsonUtils;
@Controller
@Scope("prototype")
public class DecideZoneAction extends BaseAction<DecideZone>{
	@Autowired
	private DecideZoneService decideZoneService;
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private SubareaService subareaService;
	
	
	
	private String[] subareaid;

	public void setSubareaid(String[] subareaid) {
		this.subareaid = subareaid;
	}

	public String add(){
		decideZoneService.save(model,subareaid);
		return list;
	}
	public String list(){
		
		detachedCriteria.add(Restrictions.isNotNull("staff"));
		pageBean.setDetachedCriteria(detachedCriteria);
		decideZoneService.list(pageBean);
		objecttojson(pageBean, new String[]{"subareas","decideZones","currentPage","detachedCriteria","pageSize"});
		return NONE;
	}
	public String noAssociateCustomer(){
		java.util.List<Customer> customerList = customerService.noAssociateCustomer();
		String json = jsonUtils.arraytojson(customerList, new String[]{});
		write(json);
		return NONE;
	}
	
	public String hasAssociateCustomer(){
		java.util.List<Customer> customerList = customerService.hasAssociateCustomer(model.getId());
		String json = jsonUtils.arraytojson(customerList, new String[]{});
		write(json);
		return NONE;
	}
	private java.util.List<Integer> customerIds;

	public java.util.List<Integer> getCustomerIds() {
		return customerIds;
	}

	public void setCustomerIds(java.util.List<Integer> customerIds) {
		this.customerIds = customerIds;
	}

	public String assigncustomerstodecidedzone(){
		String decidedId=model.getId();
		customerService.associateCustomer(customerIds, decidedId);
		return list;
	}
	public String subarea(){
		List<Subarea> subareaList=subareaService.findListByDecidedId(model.getId());
		String json = jsonUtils.arraytojson(subareaList, new String[]{"decideZone","subareas"});
		write(json);
		return NONE;
	}
	public String customer(){
		//customerService.
		List<Customer> customerList=customerService.hasAssociateCustomer(model.getId());
		String json=jsonUtils.arraytojson(customerList, new String[]{});
		write(json);
		return NONE;
	}
	
}
