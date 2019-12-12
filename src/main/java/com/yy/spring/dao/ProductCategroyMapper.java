package com.yy.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yy.spring.entity.ProductCategroy;


@Mapper
public interface ProductCategroyMapper {
	/**
	 * 查询商品分类
	 */
	List<ProductCategroy> selectProductcategroy();
}
