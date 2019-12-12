package com.yy.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yy.spring.dao.OrderMapper;
import com.yy.spring.entity.Fenye;
import com.yy.spring.entity.Orders;

@RestController
@CrossOrigin
public class OrdersController {
	@Autowired
	public OrderMapper orderMapper;

	// 查询所有订单
	@PostMapping("/selectOrder")
	public Map<String, Object> selectOder(Integer page, Integer limit, Orders order) {
		Fenye<Orders> fenye = new Fenye<Orders>();
		fenye.setPage((page-1)*limit);
		fenye.setPagesize(limit);
		//搜索
		fenye.setOrder(order);
		List<Orders> selectOrders = orderMapper.selectOrders(fenye);
		Integer orderCount = orderMapper.orderCount(fenye);
		fenye.setTotal(orderCount);
		fenye.setRows(selectOrders);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);// 状态码
		map.put("msg", ""); // 提示消息
		map.put("count", selectOrders.size());// 分页总条数
		map.put("data", selectOrders);// 数据（表格填充数据）
		return map;
	}

	// 根据订单编号查询商品
	@PostMapping("/selectProduct")
	public List<Orders> selectProduct(String ordnumber) {
		List<Orders> selectProduct = orderMapper.selectProduct(ordnumber);
		return selectProduct;
	}
	
	//根据oid查询订单编号
	@PostMapping("/selectOrdNumber")
	public Orders selectOrdNumber(Integer oid) {
		Orders selectOrdNumber = orderMapper.selectOrdNumber(oid);
		return selectOrdNumber;
	}
   //修改订单状态
	@PostMapping("/upda")
	public Integer upda(Orders order) {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = simpleDateFormat.format(new Date());
		order.setFordtime(format);
		Integer upda = orderMapper.upda(order);
		return upda;
	}
}
