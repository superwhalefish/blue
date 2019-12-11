package com.yy.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yy.spring.entity.OrderInfo;
import com.yy.spring.entity.Orders;
import com.yy.spring.entity.Product;
import com.yy.spring.service.OrdersService;

@RestController
@CrossOrigin
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
//72  4596  6724  7343  6145
	//获取订单
	@PostMapping("/orders_getord")
	public Map<String, Object> getOrd(Integer page, Integer limit, Orders orders) {
		Map<String, Object> ord = ordersService.getOrd(page, limit, orders);
		return ord;

	}
	//修改发货状态
	@PostMapping("/orders_updateofhstatus")
	public Integer updateofhstatus(Orders orders) {
		return ordersService.updateofhstatus(orders);
		
	}
	//查看订单信息
	@PostMapping("/orders_getOrdInfo")
	public List<OrderInfo> getordInfo(String ordnumber){
		
		return ordersService.getOrdInfo(ordnumber);
		
	}
}
