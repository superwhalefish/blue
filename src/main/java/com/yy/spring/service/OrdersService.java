package com.yy.spring.service;

import java.util.List;
import java.util.Map;

import com.yy.spring.entity.OrderInfo;
import com.yy.spring.entity.Orders;

public interface OrdersService {
Map<String,Object> getOrd(Integer page,Integer limit,Orders orders);
/**
 * 商品发货
 * @param orders
 * @return
 */
Integer updateofhstatus(Orders orders);
/**
 * 查看订单详情
 * @param ordnumber
 * @return
 */
List<OrderInfo> getOrdInfo(String ordnumber);
}
