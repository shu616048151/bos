package bos.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import bos.domain.User;
import bos.utils.BosUtils;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Action action = (Action) invocation.getAction();
		String methodName = invocation.getProxy().getMethod();
		String actionName=invocation.getAction().getClass().getName();
		String name=actionName+"."+methodName;
		//执行登录操作直接放行
		if (name.equals("bos.action.UserAction.login")) {
			return invocation.invoke();
		}
		User loginUser = BosUtils.getLoginUser();
		if (loginUser!=null) {
			return invocation.invoke();
		}else {
			return "login";
		}
	}

}
