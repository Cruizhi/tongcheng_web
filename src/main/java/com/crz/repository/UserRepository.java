package com.crz.repository;

import com.crz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends JpaRepository<User,Integer> {

	User findUserById(Integer Id);

	User findUserByPhone(String phone);
}
