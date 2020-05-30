package com.admin.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.admin.domain.User_Mina;

public interface UserOfMinaService {

	List<User_Mina> getAll(DetachedCriteria dc);

	void save(User_Mina user);

	void delete(int uid);

}
