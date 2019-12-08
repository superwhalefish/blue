package com.yy.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yy.spring.entity.OrderInfo;

public interface OrderInfoRepositry extends JpaRepository<OrderInfo, Integer>{

}
