package com.crz.controller;

import com.crz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

//	@RequestMapping("/Login")
//	public
}
