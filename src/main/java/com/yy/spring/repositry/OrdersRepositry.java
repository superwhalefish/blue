package com.yy.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yy.spring.entity.OrderInfo;
import com.yy.spring.entity.Orders;

public interface OrdersRepositry extends JpaRepository<Orders, Integer>,JpaSpecificationExecutor<Orders> {

	
	Orders findByOid(Integer oid);
/**
 * 查询详情
 * @param olist
 * @return
 */
	List<OrderInfo> findAllByOrdnumber(List<String> olist);
}
