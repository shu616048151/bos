package bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bos.dao.UserDao;
import bos.domain.Role;
import bos.domain.User;
import bos.service.UserService;
import bos.utils.MD5Utils;
import bos.utils.PageBean;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public User login(User model) {
		String password=MD5Utils.md5(model.getPassword());
		return userDao.findUserByUserNameAndPassword(model.getUsername(),password);
	}

	@Override
	public void updatePassword(String id, String password) {
		// TODO Auto-generated method stub
		password = MD5Utils.md5(password);
		userDao.executeUpdate("user.updatePassword",password,id);
	}

	@Override
	public void save(User model, String[] roleIds) {
	    String password=model.getPassword();
	    model.setPassword(MD5Utils.md5(password));
		userDao.save(model);
		if (roleIds!=null&&roleIds.length>0) {
		for (String id : roleIds) {
			Role role=new Role(id);
			model.getRoles().add(role);
		}
		}
	}

	@Override
	public void query(PageBean pageBean) {
		userDao.Query(pageBean);
		
	}

	@Override
	public User findUserByUserName(String username) {
		return userDao.findUserByUserName(username);
	}

	

}
