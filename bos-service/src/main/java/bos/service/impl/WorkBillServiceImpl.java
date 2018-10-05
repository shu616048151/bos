package bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bos.dao.WorkBillDao;
import bos.service.WorkBillService;
@Service
@Transactional
public class WorkBillServiceImpl implements WorkBillService{
	@Autowired
	private WorkBillDao workBillDao;
}
