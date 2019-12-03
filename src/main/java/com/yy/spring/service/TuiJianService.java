package com.yy.spring.service;

import java.util.Map;

import com.yy.spring.entity.TuiJian;

public interface TuiJianService {
	/**
	 * 获取折扣表
	 * 
	 * @param page
	 * @param limit
	 * @param shopid
	 * @return
	 */
	Map<String, Object> getTuijian(Integer page, Integer limit, String shopid);

	/**
	 * 修改折扣信息
	 * 
	 * @param tuiJian
	 * @return
	 */
	Integer edittuijian(TuiJian tuiJian);
/**
 * 添加折扣商品
 * @param tuiJian
 * @return
 */
	Integer addtuijian(TuiJian tuiJian);
/**
 * 删除优惠
 * @param tid
 * @return
 */
Integer del(Integer tid);
}
