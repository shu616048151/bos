package bos.dao;

import bos.base.dao.iBaseDao;
import bos.domain.User;

public interface UserDao extends iBaseDao<User>{

	public  User findUserByUserNameAndPassword(String username, String password);

	public User findUserByUserName(String username);


}
