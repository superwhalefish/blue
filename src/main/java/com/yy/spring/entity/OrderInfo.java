package com.yy.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@Table(name = "orderinfo")
@Entity
public class OrderInfo {
	@Id
	@GeneratedValue
	private Integer ordid;
	private String ordnumber;
	private Integer pid;
	private Integer pnum;
	private String rcolor;
	private String rtype;
}
