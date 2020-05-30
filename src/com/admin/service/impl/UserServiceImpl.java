package com.admin.service.impl;

import com.admin.dao.UserDao;
import com.admin.dao.impl.UserDaoImpl;
import com.admin.domain.User_Admin;
import com.admin.service.UserService;
import com.admin.utils.HibernateUtils;

public class UserServiceImpl implements UserService {

	private UserDao ud = new UserDaoImpl();

	@Override
	public User_Admin login(User_Admin u) {
		//打开事务
		HibernateUtils.getCurrentSession().beginTransaction();
		//调用Dao查询User
		User_Admin existU = ud.getByUserCode(u.getUser_name());
		//关闭事务
		HibernateUtils.getCurrentSession().getTransaction().commit();
		if(existU==null){
			throw new RuntimeException("用户名不存在");
		}
		if(!existU.getUser_password().equals(u.getUser_password())){
			throw new RuntimeException("您输入的密码有误");
		}
		return existU;
	}

}
