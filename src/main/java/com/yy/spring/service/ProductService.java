package com.yy.spring.service;

import java.util.List;
import java.util.Map;

import com.yy.spring.entity.Product;

public interface ProductService {
	/**
	 * 商品接口测试
	 * 
	 * @return
	 */
	public Map<String, Object> getpro(Integer page, Integer limit,String search_pname, String search_shopid,String search_startprice,String search_endprice,String search_startuptime,String search_enduptime,String search_pstatus,String search_ptstatus);

	/**
	 * 修改上架状态
	 * 
	 * @param pid
	 * @param pstatus
	 * @return
	 */
	Integer product_edit_pstatus(Integer pid, Integer pstatus);

	/**
	 * 商品推荐状态
	 * 
	 * @param ptstatus
	 * @param pid
	 * @return
	 */
	Integer product_edit_ptstatus(Integer ptstatus, Integer pid);

	/**
	 * 获取商品详情
	 * 
	 * @param pid
	 * @return
	 */
	Map<String, Object> getProInfo(Integer pid);

	/**
	 * 商品添加
	 * 
	 * @param product
	 * @return
	 */
	Integer addpro(Product product);

	/**
	 * 修改商品价格
	 * 
	 * @param pprice
	 * @param pid
	 * @return
	 */
	Integer editpriceBypid(Integer pprice, Integer pid);

	/**
	 * 删除商品信息
	 * 
	 * @param pid
	 * @return
	 */
	public Integer delproinfo(Integer pid);
}
