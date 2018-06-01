package com.crz.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {

	@Id
	public Integer id;
	public String phone;
	public String password;
	public String username;
	public String email;
	public String sex;
	public String address;
	public String pic;
	public String token;

}
