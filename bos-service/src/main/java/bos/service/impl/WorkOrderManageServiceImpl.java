package bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bos.dao.WorkOrderManageDao;
import bos.domain.WorkOrderManage;
import bos.service.WorkOrderManageService;

@Service
@Transactional
public class WorkOrderManageServiceImpl implements WorkOrderManageService{
	@Autowired
	private WorkOrderManageDao workOrderManageDao;

	@Override
	public void save(WorkOrderManage model) {
		workOrderManageDao.save(model);
		
	}

}
