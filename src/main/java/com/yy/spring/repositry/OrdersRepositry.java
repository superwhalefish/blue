package com.yy.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yy.spring.entity.Orders;

public interface OrdersRepositry extends JpaRepository<Orders, Integer>,JpaSpecificationExecutor<Orders> {

	
	Orders findAllByOid(Integer oid);
}
