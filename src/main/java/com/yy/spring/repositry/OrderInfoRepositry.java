package com.yy.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yy.spring.entity.OrderInfo;

public interface OrderInfoRepositry extends JpaRepository<OrderInfo, Integer> {
	/**
	 * 查询订单详情
	 * 
	 * @param ordnumber
	 * @return
	 */
	List<OrderInfo> findAllByOrdnumber(String ordnumber);

}
