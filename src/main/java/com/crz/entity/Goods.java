package com.crz.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Goods {

	@Id
	private Integer id;
	private String userid;
	private String token;
	private String type;
	private String title;
	private String content;
	private String price;
	private String assortment;
	private String linkphone;
	private String carriage;
	private String comment;
	private String city;
	private String pic0;
	private String pic1;
	private String pic2;
	private String pic3;
	private String pic4;
	private String pic5;
	private String pic6;
	private Boolean status;
}
