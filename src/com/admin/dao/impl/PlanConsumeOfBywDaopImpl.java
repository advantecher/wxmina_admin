package com.admin.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.admin.dao.PlanConsumeOfBywDao;
import com.admin.domain.PlanConsumeOfByw;
import com.admin.utils.HibernateUtils;


public class PlanConsumeOfBywDaopImpl implements PlanConsumeOfBywDao {

	public List<PlanConsumeOfByw> getCurrent() {
		// 1 获得session
		Session session = HibernateUtils.getCurrentSession();
		// 2 创建Criteria对象
		Criteria c = session.createCriteria(PlanConsumeOfByw.class);
		List<PlanConsumeOfByw> list = c.list();
		return list;
	}

	public void edit(PlanConsumeOfByw plan) {
		Session session = HibernateUtils.getCurrentSession();
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat( "yyyy-MM-dd");
		String format = sf.format(date);
		String hql = "update PlanConsumeOfByw p set p.createTime=?,p.plansl=?,p.plandh=?,p.planfh=?,"
				+ "p.planlh=?,p.planyh=?,p.plancb=? where p.id=1";
		Query query = session.createQuery(hql);
		query.setString(0, format);
		query.setDouble(1, plan.getPlansl());
		query.setDouble(2, plan.getPlandh());
		query.setDouble(3, plan.getPlanfh());
		query.setDouble(4, plan.getPlanlh());
		query.setDouble(5, plan.getPlanyh());
		query.setDouble(6, plan.getPlancb());
		query.executeUpdate();
	}
}
