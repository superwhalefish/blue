package com.yy.spring.service;

import java.util.List;
import java.util.Map;

import com.yy.spring.entity.Product;

public interface ProductService {
	/**
	 * 商品接口测试
	 * @return
	 */
	public Map<String,Object> getpro();
	/**
	 * 修改上架状态
	 * @param pid
	 * @param pstatus
	 * @return
	 */
	Integer product_edit_pstatus(Integer pid,Integer pstatus);
	
	/**
	 * 商品推荐状态
	 * @param ptstatus
	 * @param pid
	 * @return
	 */
	Integer product_edit_ptstatus(Integer ptstatus,Integer pid);
	/**
	 * 获取商品详情
	 * @param pid
	 * @return
	 */
	Map<String,Object> getProInfo(Integer pid);
}
