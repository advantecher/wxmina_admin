package com.admin.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import com.admin.dao.UserOfMinaDao;
import com.admin.domain.User_Mina;
import com.admin.utils.HibernateUtils;

public class UserOfMinaDaoImpl implements UserOfMinaDao {

	public List<User_Mina> getAll(DetachedCriteria dc) {
		//获得session
		Session session = HibernateUtils.getCurrentSession();
		//将离线对象关联到session
		Criteria c = dc.getExecutableCriteria(session);
		//执行查询并返回
		System.out.println("---------------list:"+c);
		return c.list();
	}

	public void save(User_Mina user) {
		//1 获得session
		Session session = HibernateUtils.getCurrentSession();
		//3 执行保存
		session.save(user);
	}

	@Override
	public void delete(int uid) {
		Session session = HibernateUtils.getCurrentSession();
		String hql = "DELETE from User_Mina where uid = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, uid);
		query.executeUpdate();
		
	}

}
