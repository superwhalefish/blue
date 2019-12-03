package com.yy.spring.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yy.spring.entity.TuiJian;

public interface TuiJianRepositry extends JpaRepository<TuiJian, Integer>,JpaSpecificationExecutor<TuiJian>{
/**
 * 根据商品编号查询商品是否已经折扣
 * @param pshopid
 * @return
 */
	TuiJian findAllByPshopid(String pshopid);


}
