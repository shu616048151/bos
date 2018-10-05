package bos.service;

import bos.domain.User;
import bos.utils.PageBean;

public interface UserService {

	public User login(User model);

	public void updatePassword(String id, String password);

	public void save(User model, String[] roleIds);

	public void query(PageBean pageBean);

	public User findUserByUserName(String username);


}
