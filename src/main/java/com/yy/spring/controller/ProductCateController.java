package com.yy.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yy.spring.entity.ProductCategroy;
import com.yy.spring.service.ProductCategoryService;

@RestController
@CrossOrigin
public class ProductCateController {
	@Autowired
	private ProductCategoryService productCategoryService;
	@PostMapping("/productcategory_getProCate")
	public List<ProductCategroy> getProCate() {
		List<ProductCategroy> proCate = productCategoryService.getProCate();
		return proCate;

	}
}
