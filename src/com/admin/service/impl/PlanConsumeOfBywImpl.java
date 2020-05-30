package com.admin.service.impl;

import java.util.List;

import com.admin.dao.PlanConsumeOfBywDao;
import com.admin.dao.impl.PlanConsumeOfBywDaopImpl;
import com.admin.domain.PlanConsumeOfByw;
import com.admin.service.PlanConsumeOfBywService;
import com.admin.utils.HibernateUtils;

public class PlanConsumeOfBywImpl implements PlanConsumeOfBywService {

	private PlanConsumeOfBywDao pd = new PlanConsumeOfBywDaopImpl();

	public List<PlanConsumeOfByw> getCurrent() {
		HibernateUtils.getCurrentSession().beginTransaction();
		List<PlanConsumeOfByw> consume = pd .getCurrent();
		HibernateUtils.getCurrentSession().getTransaction().commit();
		return consume;
	}

	public void edit(PlanConsumeOfByw plan) {
		HibernateUtils.getCurrentSession().beginTransaction();
		try {
			pd.edit(plan);
		} catch (Exception e) {
			HibernateUtils.getCurrentSession().getTransaction().rollback();
			e.printStackTrace();
		}
		HibernateUtils.getCurrentSession().getTransaction().commit();
	}

}
