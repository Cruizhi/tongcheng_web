package com.crz.service.impl;

import com.crz.entity.User;
import com.crz.repository.UserRepository;
import com.crz.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUser(String phone, String password) {

		User user = new User();
		user = userRepository.findUserByPhone(phone);
		if(user == null){
			log.error("【登录】账号不正确，id={}",phone);
			user = new User();
			user.setPhone("false");
		}else{
			if(user.getPassword().equals(password)){
				return user;
			}else{
				log.error("【登录】密码不正确，id={}",phone);
				user.setPhone("false");
			}
		}

		return user;
	}

}
