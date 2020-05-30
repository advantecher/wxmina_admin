package com.admin.service;

import java.util.List;

import com.admin.domain.PlanConsumeOfByw;

public interface PlanConsumeOfBywService {
	//获得当前白洋湾计划消耗数据
	List<PlanConsumeOfByw> getCurrent();

	void edit(PlanConsumeOfByw plan);

}
