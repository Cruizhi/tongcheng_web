package com.crz.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@DynamicUpdate
public class Recruit {

	private String recruittype;
	@Id
	private String userid;
	private String token;
	private String type;
	private String name;
	private String number;
	private String duration;
	private String period;
	private String wages;
	private String payroll;
	private String address;
	private String welfare;
	private String content;
	private String linkman;
	private String linkphone;
	private String company;
	private String date;
	private String city;
}
