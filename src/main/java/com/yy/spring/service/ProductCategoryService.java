package com.yy.spring.service;

import java.util.List;
import java.util.Map;

import com.yy.spring.entity.ProductCategroy;

public interface ProductCategoryService {
	/**
	 * 获取商品类别
	 * 
	 * @return
	 */
	public List<ProductCategroy> getProCate();
/**
 * 条件查询
 * @param page
 * @param limit
 * @param cpname
 * @return
 */
	public Map<String, Object> findProCate(Integer page, Integer limit, String cpname);
	/**
	 * 修改类别
	 * @param productCategroy
	 * @return
	 */
	Integer updateCate(ProductCategroy productCategroy);
	/**
	 * 删除类别
	 * @param cpid
	 * @return
	 */
	Integer deleteCateByCpid(Integer cpid);
	/**
	 * 添加类别
	 * @param productCategroy
	 * @return
	 */
	Integer addCate(ProductCategroy productCategroy);
}
