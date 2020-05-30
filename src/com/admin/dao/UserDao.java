package com.admin.dao;

import com.admin.domain.User_Admin;

public interface UserDao {

	User_Admin getByUserCode(String user_name);

}
