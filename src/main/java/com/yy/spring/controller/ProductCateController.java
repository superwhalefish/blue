package com.yy.spring.controller;

import java.util.List;
import java.util.Map;

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
	@PostMapping("/productcategroy_getprocate")
	public Map<String,Object> productcategroy_getprocate(Integer page,Integer limit,String cpname){
		return productCategoryService.findProCate(page,limit,cpname);
	}
	@PostMapping("productcategroy_updatecate")
	public Integer productcategroy_updatecate(ProductCategroy productCategroy) {
		return productCategoryService.updateCate(productCategroy);
	}
	@PostMapping("productcategroy_deletecate")
	public Integer productcategroy_deletecate(Integer cpid) {
		return productCategoryService.deleteCateByCpid(cpid);
	}
	@PostMapping("productcategroy_addcate")
	public Integer productcategroy_addcate(ProductCategroy productCategroy) {
		return productCategoryService.addCate(productCategroy);
	}
}
