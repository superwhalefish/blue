package com.yy.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yy.spring.entity.Product;

public interface ProductRepositry extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
	/**
	 * 查询类别下的商品
	 * 
	 * @param cpid
	 * @return
	 */
	List<Product> findAllByCpid(Integer cpid);
/**
 * 根据shopid查询商品
 * @param pshopid
 * @return
 */
	Product findAllByPshopid(String pshopid);

}
