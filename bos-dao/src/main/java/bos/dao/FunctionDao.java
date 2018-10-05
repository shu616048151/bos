package bos.dao;

import java.util.List;

import bos.base.dao.iBaseDao;
import bos.domain.Function;

public interface FunctionDao extends iBaseDao<Function> {

	@Override
	public List<Function> findAll();

	public List<Function> findFunctionByUserId(String id);
	

}
