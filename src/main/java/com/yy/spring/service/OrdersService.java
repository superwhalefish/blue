package com.yy.spring.service;

import java.util.Map;

import com.yy.spring.entity.Orders;

public interface OrdersService {
Map<String,Object> getOrd(Integer page,Integer limit,Orders orders);
/**
 * 商品发货
 * @param orders
 * @return
 */
Integer updateofhstatus(Orders orders);
}
