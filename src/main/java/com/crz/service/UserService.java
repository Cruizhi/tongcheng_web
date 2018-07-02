package com.crz.service;

import com.crz.entity.User;

public interface UserService {

	//查询用户是否存在
	User findUser(String phone, String password);

	//存储用户信息
	User saveUser(User user);
}
