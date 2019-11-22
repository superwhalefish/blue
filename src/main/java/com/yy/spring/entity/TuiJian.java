package com.yy.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Entity
@Table(name = "tuijian")
@Component
public class TuiJian {
	@Id
	@GeneratedValue
	private Integer tid;
	private Integer pid;
	private double tyouhui;
}
