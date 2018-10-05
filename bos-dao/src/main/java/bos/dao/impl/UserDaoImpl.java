package bos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import bos.base.dao.iBaseDaoImpl;
import bos.dao.UserDao;
import bos.domain.User;
@Repository
public  class UserDaoImpl extends iBaseDaoImpl<User> implements UserDao{
	@Override
	public User findUserByUserNameAndPassword(String username, String password) {
		String hql="from User where username=? and password=? ";
		List<User> userList = (List<User>) this.getHibernateTemplate().find(hql,username,password);
		if (userList.size()>0&&userList!=null) {
			return userList.get(0);
		}else{
			return null;
		}
	}
	@Override
	public User findUserByUserName(String username) {
		String hql="from User where username=?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username);
		if (list.size()>0&&list!=null) {
			return list.get(0);
		}
		return null;
	}


	

}
