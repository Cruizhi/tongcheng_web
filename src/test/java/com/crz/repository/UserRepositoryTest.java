package com.crz.repository;

import com.crz.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void findByUserId(){
		User user = userRepository.findUserById(2);
		Assert.assertNotEquals(0,user);
	}

	@Test
	public void findUserByPhone(){
		User user = userRepository.findUserByPhone("123123");
		Assert.assertNotEquals(0,user);
	}

}