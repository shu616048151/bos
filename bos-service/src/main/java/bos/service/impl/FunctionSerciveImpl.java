package bos.service.impl;

import java.awt.Dialog.ModalExclusionType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bos.dao.FunctionDao;
import bos.domain.Function;
import bos.service.FunctionSercive;
import bos.utils.PageBean;

@Service
@Transactional
public class FunctionSerciveImpl implements FunctionSercive{
	@Autowired
	private FunctionDao functionDao;

	@Override
	public List<Function> findAll() {
		return functionDao.findAll();
	}

	@Override
	public void save(Function model) {
		Function parentFunction = model.getParentFunction();
		if (parentFunction!=null&&parentFunction.getId()==null) {
			model.setParentFunction(null);
		}
		functionDao.save(model);
	}

	@Override
	public void query(PageBean pageBean) {
		
		functionDao.Query(pageBean);
		
	}

}
