package bos.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import bos.dao.FunctionDao;
import bos.dao.UserDao;
import bos.domain.Function;
import bos.domain.User;
import bos.utils.BosUtils;

public class CustomRealm extends AuthorizingRealm{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private FunctionDao functionDao;
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//Object principal = token.getPrincipal();//标表示当前的user对象，credentials为密码
		UsernamePasswordToken passwordToken=(UsernamePasswordToken) token;
		String username = passwordToken.getUsername();
		//根据用户名查询user
		User user=userDao.findUserByUserName(username);
		if (user==null) {
			return null;
		}
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
		return info;
	}

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		//获取权限
		User loginUser =  (User) SecurityUtils.getSubject().getPrincipal();
		//权限的集合
		List<Function> functionList=new ArrayList<>();
		if(loginUser.getUsername().equals("admin")){
			//管理员获得所有的权限
			DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Function.class);
			functionList = functionDao.findListByCriteria(detachedCriteria);
		}else{
			//普通用户
			functionList=functionDao.findFunctionByUserId(loginUser.getId());
		}
		
		//遍历权限集合
		for (Function function : functionList) {
			info.addStringPermission(function.getCode());
		}
		return info;
	}
	

}
