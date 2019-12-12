package com.yy.spring.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yy.spring.entity.Wuliu;
@Mapper
public interface WuliuMapper {
	   //添加物流信息
		Integer addWuliu(Wuliu wuliu);

}
