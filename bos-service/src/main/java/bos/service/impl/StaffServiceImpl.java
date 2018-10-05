package bos.service.impl;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bos.dao.StaffDao;
import bos.domain.Staff;
import bos.domain.User;
import bos.service.StaffService;
import bos.utils.PageBean;
@Service
@Transactional
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDao staffDao;

	@Override
	public void add(Staff model) {
		System.out.println(model.getName());
		staffDao.save(model);
	}

	@Override
	public PageBean findListByQuery(PageBean pageBean) {
		
		return staffDao.Query(pageBean);
	}

	@Override
	public void delStaff(String[] idArr) {
		for (String id : idArr) {
			staffDao.executeUpdate("staff.delete", id);
		}
	}
	
	@Override
	public Staff findStaffById(String id) {
		return staffDao.findById(id);
	}

	@Override
	public void update(Staff staff) {
		staffDao.update(staff);
		
	}

	

	
}
