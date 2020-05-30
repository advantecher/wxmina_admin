package com.admin.web.action;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.admin.domain.PlanConsumeOfByw;
import com.admin.service.PlanConsumeOfBywService;
import com.admin.service.impl.PlanConsumeOfBywImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PlanConsumeOfBywAction extends ActionSupport implements ModelDriven<PlanConsumeOfByw>{
	private PlanConsumeOfByw plan = new PlanConsumeOfByw();
	private PlanConsumeOfBywService ps = new PlanConsumeOfBywImpl();

	public String show() throws Exception {
		List<PlanConsumeOfByw> current = ps .getCurrent();
		ActionContext.getContext().getSession().put("list", current);
		return "show";
	}
	
	
	public String edit() throws Exception {
		try {
			ps.edit(plan);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	
	}


	@Override
	public PlanConsumeOfByw getModel() {
		return plan ;
	}
	
}
