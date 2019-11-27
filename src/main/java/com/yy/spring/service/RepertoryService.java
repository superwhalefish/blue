package com.yy.spring.service;

import java.util.Map;

public interface RepertoryService {
	/**
	 * 获取商品库存数据
	 * @param page
	 * @param limit
	 * @param shopid
	 * @return
	 */
public Map<String,Object> getRep(Integer page,Integer limit,String shopid);
}
