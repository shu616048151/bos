package bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import bos.base.dao.iBaseDaoImpl;
import bos.dao.FunctionDao;
import bos.domain.Function;
@Repository
public class FunctionDaoImpl extends iBaseDaoImpl<Function>  implements FunctionDao {

	@Override
	public List<Function> findAll() {
		String hql="from Function where parentFunction.id is null";
		List<Function> functionList = (List<Function>) this.getHibernateTemplate().find(hql);
		return functionList;
	}

	@Override
	public List<Function> findFunctionByUserId(String id) {
		String hql="select distinct f from User u join u.roles r join r.functions f where u.id=?";
		//String hql="select DISTINCT f from Function f join f.roles r join r.users u where u.id=?";
		List<Function> list = (List<Function>) this.getHibernateTemplate().find(hql, id);
		if (list.size()>0&&list!=null) {
			return list;
		}
		return null;
	}

}
