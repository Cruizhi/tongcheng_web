package com.crz.service;

import com.crz.entity.User;

public interface LoginService {

	//查询用户是否存在
	User findUser(String phone,String password);
}
