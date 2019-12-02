package com.yy.spring.service;

import java.util.Map;

import com.yy.spring.entity.Repertory;

public interface RepertoryService {
	/**
	 * 获取商品库存数据
	 * 
	 * @param page
	 * @param limit
	 * @param shopid
	 * @return
	 */
	public Map<String, Object> getRep(Integer page, Integer limit, String shopid);

	/**
	 * 修改库存信息
	 * 
	 * @param repertory
	 * @return
	 */
	public Integer updateRep(Repertory repertory);

	/**
	 * 
	 * @param repertory
	 * @return
	 */
	public Integer repertory_add(Repertory repertory);
}
