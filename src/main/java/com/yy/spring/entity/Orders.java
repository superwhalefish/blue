package com.yy.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Entity
@Component
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue
	private Integer oid;//id
	private String ordnumber;//订单编号
	private Integer ocid;//客户id
	private String consignee;//收货人
	private String oadress;//收货地址
	private String otel;//联系电话
	private String opaystatus;//付款状态
	private String opayway;//支付方式
	private String ofhstatus;//发货状态
	private String ojsstatus;//收货状态
	private String xordtime;//下单时间
	private String fordtime;//发货时间
	private String jsordtime;//签收时间
	private String pjstatus;//评价状态
}
