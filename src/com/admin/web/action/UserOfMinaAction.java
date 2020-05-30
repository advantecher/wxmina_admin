package com.admin.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.admin.domain.User_Mina;
import com.admin.service.UserOfMinaService;
import com.admin.service.impl.UserOfMinaServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserOfMinaAction extends ActionSupport implements ModelDriven<User_Mina> {
	private User_Mina user =new User_Mina();
	private UserOfMinaService cs = new UserOfMinaServiceImpl();
	
	public String list() throws Exception {
		String user_name = ServletActionContext.getRequest().getParameter("user_name");
		//创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(User_Mina.class);
		if(StringUtils.isNoneBlank(user_name)){
			dc.add(Restrictions.like("user_name", "%"+user_name+"%"));
		}
		//调用service将离线对象传递
		List<User_Mina> list = cs .getAll(dc);
		ActionContext.getContext().put("list", list);
		return "list";
	}
	
	public String add() throws Exception {
		if(StringUtils.isNoneBlank(user.getUser_name())&&StringUtils.isNoneBlank(user.getUser_password())){
			cs.save(user);
			return SUCCESS;
		}else{
			return ERROR;
		}
		
	}
	
	
	public String delete() throws Exception {
		try {
			cs.delete(user.getUid());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	@Override
	public User_Mina getModel() {
		return user;
	}

}
