package com.admin.web.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.admin.domain.User_Admin;
import com.admin.domain.User_Mina;
import com.admin.service.UserService;
import com.admin.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User_Admin>{
	private User_Admin user = new User_Admin();
	private UserService us = new UserServiceImpl();
	
	//用户登录
	public String login() throws Exception {
		User_Admin u = us.login(user);
		//设置session的持久化时间为10分钟
		ServletActionContext.getRequest().getSession().setMaxInactiveInterval(10*60);
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("user", u);
		return "toHome";		
	}

	//退出登录
	public String exit() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "error";	
	}
	
	@Override
	public User_Admin getModel() {
		return user;
	}


}
