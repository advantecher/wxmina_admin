package com.admin.web.interceptory;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginIntercepter extends MethodFilterInterceptor{
	//指定不拦截登录方法。其他方法都拦截
	
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		//1获得session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//2获得登录标识
		Object object = session.get("user");
		//3判断登录标识是否存在
		if(object == null){
			//不存在 => 没登录 => 重定向到登录页面
			System.out.println("拦截，请登录");
			return "toLogin";
		}else{
			//存在 => 已经登录 => 放行
			System.out.println("放行");
			return invocation.invoke();
		}
	}

}
