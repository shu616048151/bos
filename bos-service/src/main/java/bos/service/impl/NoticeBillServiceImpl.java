package bos.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bos.dao.DecideZoneDao;
import bos.dao.NoticeBillDao;
import bos.dao.WorkBillDao;
import bos.domain.DecideZone;
import bos.domain.NoticeBill;
import bos.domain.Staff;
import bos.domain.WorkBill;
import bos.service.CustomerService;
import bos.service.NoticeBillService;
@Service
@Transactional
public class NoticeBillServiceImpl implements NoticeBillService {
	@Autowired
	private NoticeBillDao noticeBillDao;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private DecideZoneDao decideZoneDao;
	@Autowired
	private WorkBillDao workBillDao;

	@Override
	public void save(NoticeBill model) {
		noticeBillDao.save(model);
		String decidedZoneId = customerService.findCustomerIdByAddress(model.getPickaddress());
		if (decidedZoneId!=null) {
			//查询到了定区id，可以完成自动分单
			DecideZone decidedzone = decideZoneDao.findById(decidedZoneId);
			Staff staff = decidedzone.getStaff();
			model.setStaff(staff);//业务通知单关联取派员对象
			//设置分单类型为：自动分单
			model.setOrdertype(NoticeBill.ORDERTYPE_AUTO);
			//为取派员产生一个工单
			WorkBill workbill = new WorkBill();
			workbill.setAttachbilltimes(0);//追单次数
			workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));//创建时间，当前系统时间
			workbill.setNoticeBill(model);//工单关联页面通知单
			workbill.setPickstate(WorkBill.PICKSTATE_NO);//取件状态
			workbill.setRemark(model.getRemark());//备注信息
			workbill.setStaff(staff);//工单关联取派员
			workbill.setType(WorkBill.TYPE_1);//工单类型
			workBillDao.save(workbill);
			//调用短信平台，发送短
		}else {
			//没有查询到定区id，不能完成自动分单
			model.setOrdertype(NoticeBill.ORDERTYPE_MAN);

		}
		
	}
}
