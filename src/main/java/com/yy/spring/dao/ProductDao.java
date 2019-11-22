package com.yy.spring.dao;

import java.util.List;

import com.yy.spring.entity.Product;
import com.yy.spring.entity.ProductImg;

public interface ProductDao {
/**
 * 商品推荐状态
 * @param pstatus
 * @param pid
 * @return
 */
Integer product_edit_pstatus(Integer pstatus,Integer pid);
/**
 * 商品推荐状态
 * @param ptstatus
 * @param pid
 * @return
 */
Integer product_edit_ptstatus(Integer ptstatus,Integer pid);
/**
 * 查询商品详情
 * @param pid
 * @return
 */
List<Product> getProAndCate(Integer pid);

}
