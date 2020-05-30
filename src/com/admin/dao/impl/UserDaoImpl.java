package com.admin.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;

import com.admin.dao.UserDao;
import com.admin.domain.User_Admin;
import com.admin.utils.HibernateUtils;


public class UserDaoImpl implements UserDao {

	public User_Admin getByUserCode(String user_name) {
		//HQL查询
		//1获得session
		Session session = HibernateUtils.getCurrentSession();
		//2书写HQL
		String hql = "from User_Admin where user_name = ? ";
		//3创建查询对象
		Query query = session.createQuery(hql);
		//4设置参数
		query.setParameter(0, user_name);		
		//5执行查询
		User_Admin u = (User_Admin) query.uniqueResult();
		System.out.println(u+"-------------");
		return u;
	}

}
