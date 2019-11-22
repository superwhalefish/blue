package com.yy.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Table(name = "repertory")
@Data
@Component
public class Repertory {
	@Id
	@GeneratedValue
	private Integer rid;
	private Integer ridpid;
	private String rtype;
	private Integer rpnum;
	private String rpcolor;

}