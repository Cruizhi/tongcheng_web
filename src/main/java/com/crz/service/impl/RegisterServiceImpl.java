package com.crz.service.impl;

import com.crz.entity.User;
import com.crz.repository.UserRepository;
import com.crz.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private UserRepository userRepository;


	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
}
