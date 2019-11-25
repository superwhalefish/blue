package com.yy.spring.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yy.spring.entity.ProductImg;

public interface ProductImgRepositry extends JpaRepository<ProductImg, Integer>, JpaSpecificationExecutor<ProductImg> {
	/**
	 * 根据商品编号查询商品图片
	 * 
	 * @param iid
	 * @return
	 */
	List<ProductImg> findAllByShopid(String shopid);

	/**
	 * 删除该商品相关图片
	 * 
	 * @param pshopid
	 */
	void deleteByShopid(String pshopid);
}
