package com.admin.dao;

import java.util.List;

import com.admin.domain.PlanConsumeOfByw;

public interface PlanConsumeOfBywDao {

	List<PlanConsumeOfByw> getCurrent();

	void edit(PlanConsumeOfByw plan);

}
