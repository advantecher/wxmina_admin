package com.admin.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.admin.domain.User_Mina;

public interface UserOfMinaDao {

	List<User_Mina> getAll(DetachedCriteria dc);

	void save(User_Mina user);

	void delete(int uid);

	
}
