package com.yy.spring.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.yy.spring.entity.Fenye;
import com.yy.spring.entity.Orders;
import com.yy.spring.entity.Wuliu;

@Mapper
public interface OrderMapper {
	//查询所有订单
	List<Orders> selectOrders(Fenye<Orders> fenye);
	//查询总条数
	Integer orderCount(Fenye<Orders> fenye);
	//根据订单编号查询商品
	List<Orders> selectProduct(String ordnumber);
	//根据oid查询订单编号
	Orders selectOrdNumber(Integer oid);
	//修改订单状态
	Integer upda(Orders order);
	
	
	
	

}
