package com.admin.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import com.admin.dao.UserOfMinaDao;
import com.admin.dao.impl.UserOfMinaDaoImpl;
import com.admin.domain.User_Mina;
import com.admin.service.UserOfMinaService;
import com.admin.utils.HibernateUtils;

public class UserOfMinaServiceImpl implements UserOfMinaService {

	private UserOfMinaDao ud = new UserOfMinaDaoImpl();

	public List<User_Mina> getAll(DetachedCriteria dc) {
		//打开事务
		HibernateUtils.getCurrentSession().beginTransaction();
		List<User_Mina> list = ud .getAll(dc);
		//关闭事务
		HibernateUtils.getCurrentSession().getTransaction().commit();
		return list;
	}

	public void save(User_Mina user) {
		Session session =  HibernateUtils.getCurrentSession();
		//打开事务
		Transaction tx = session.beginTransaction();
		//调用Dao保存客户
		try {
			ud.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		//关闭事务
		tx.commit();
	}

	@Override
	public void delete(int uid) {
		HibernateUtils.getCurrentSession().beginTransaction();
		try {
			ud.delete(uid);
		} catch (Exception e) {
			HibernateUtils.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
		HibernateUtils.getCurrentSession().getTransaction().commit();
	}

}
