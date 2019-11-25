package com.yy.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yy.spring.entity.Repertory;

public interface RepertoryRepositry extends JpaRepository<Repertory, Integer>, JpaSpecificationExecutor<Repertory> {
	/**
	 * 根据商品编号查询商品库存
	 * 
	 * @param ridpid
	 * @return
	 */
	List<Repertory> findAllByShopid(String shopid);

	/**
	 * 删除改商品的库存
	 * 
	 * @param pshopid
	 */
	void deleteByShopid(String pshopid);
}
