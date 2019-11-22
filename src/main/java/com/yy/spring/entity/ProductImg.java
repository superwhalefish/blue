package com.yy.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


import lombok.Data;

@Data
@Entity
@Table(name = "productimg")
@Component
public class ProductImg {
	@Id
	@GeneratedValue
	private Integer iid;
	private String iurl;
}