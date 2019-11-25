package com.yy.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yy.spring.entity.ProductCategroy;
import com.yy.spring.repositry.ProductCategroyRepositry;
@Service
public class ProductCategoryServiceImp implements ProductCategoryService {
	@Autowired
	public ProductCategroyRepositry productCategroyRepositry;

	@Override
	public List<ProductCategroy> getProCate() {
		// TODO Auto-generated method stub
		List<ProductCategroy> findAll = productCategroyRepositry.findAll();
		return findAll;
	}

}
