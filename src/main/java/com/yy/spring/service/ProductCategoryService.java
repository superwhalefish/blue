package com.yy.spring.service;

import java.util.List;

import com.yy.spring.entity.ProductCategroy;

public interface ProductCategoryService {
	/**
	 * 获取商品类别
	 * 
	 * @return
	 */
	public List<ProductCategroy> getProCate();
}
