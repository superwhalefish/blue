package com.yy.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yy.spring.repositry.OrderInfoRepositry;

@Service
public class OrderInfoServiceImp implements OrderInfoService {
	@Autowired
	private OrderInfoRepositry orderInfoRepositry;

}
