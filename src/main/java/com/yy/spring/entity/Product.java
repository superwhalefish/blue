package com.yy.spring.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Table(name = "product")
@Entity
@Component
public class Product {
	@Id
	@GeneratedValue
	private Integer pid;
	private String pname;
	private Double pprice;
	private Integer pimgid;
	private Integer clicknum;
	private Integer pshopid;
	private Integer cpid;
	private Integer pstatus;
	private Integer ptstatus;
	@Transient
	private ProductCategroy productCategroy;
	@Transient
	private ProductImg productImg;
	@Transient
	private Repertory repertory;
}
