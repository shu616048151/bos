package bos.action;

import java.io.IOException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import bos.base.action.BaseAction;
import bos.domain.Role;
import bos.domain.User;
import bos.service.UserService;
import bos.utils.BosUtils;
import bos.utils.MD5Utils;

@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	@Autowired 
	private UserService userService;	
	public String login(){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(model.getUsername(), model.getPassword());
		try{
			subject.login(token);
		}catch (Exception e) {
			addActionError("用户名或密码错误");
			return LOGIN;
		}
		User existUser=(User) subject.getPrincipal();
		//添加用户信息到session中
		ServletActionContext.getRequest().getSession().setAttribute("loginUser", existUser);
		return "home";
	}
	public String logout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return LOGIN;
	}
	//密码封装到model中
	public void editPassword(){
		User loginUser = BosUtils.getLoginUser();
		String password=model.getPassword();
		String flag="1";
		try {
			userService.updatePassword(loginUser.getId(),password);
		} catch (Exception e) {
			flag="0";
			e.printStackTrace();
		}
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	String[] roleIds;
	public void setRoleIds(String[] roleIds) {
		this.roleIds = roleIds;
	}
	
	public String add(){
		userService.save(model,roleIds);
		return list;
	}
	
	public void list(){
		userService.query(pageBean);
		objecttojson(pageBean, new String[]{"noticeBills","roles"});
	}
	public void checkusername(){
		String f="0";
		if (model.getUsername().trim()!=null) {
			User existUser= userService.findUserByUserName(model.getUsername());
			if (existUser!=null) {
				f="1";
			}
		}
		write(f);
	}
	
	private String userIds;
	public void deleteUser(){
		
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
	
	
}
