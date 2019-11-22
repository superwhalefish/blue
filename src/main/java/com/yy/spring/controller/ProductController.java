package com.yy.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yy.spring.entity.Product;
import com.yy.spring.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/product_getpro")
	public Map<String,Object> getpro(Integer page,Integer limit) {
		System.out.println("hahahhahaha");
		System.out.println(page+"<===当前页，显示行====》"+limit);
		Map<String, Object> getpro = productService.getpro();
		return getpro; 

	}
	
	/**
	 * 商品上架状态
	 * @param pid
	 * @param pstatus
	 * @return
	 */
	@PostMapping("/product_edit_pstatus")
	public Integer product_edit_pstatus(Integer pid,Integer pstatus){
		Integer product_edit_pstatus = productService.product_edit_pstatus(pid,pstatus);
		return product_edit_pstatus;
	}
	/**
	 * 商品推荐状态
	 * @param ptstatus
	 * @param pid
	 * @return
	 */
	@PostMapping("/product_edit_ptstatus")
	public Integer product_edit_ptstatus(Integer ptstatus,Integer pid ) {
		System.out.println("hahahha");
		System.out.println(ptstatus);
		System.out.println(pid);
		Integer product_edit_ptstatus = productService.product_edit_ptstatus(ptstatus, pid);
		return product_edit_ptstatus;
		
	}
	@PostMapping("/product_look_pid")
	public Map<String,Object> product_look_pid(Integer pid){
		Map<String, Object> proInfo = productService.getProInfo(pid);
		System.out.println(proInfo);
		return proInfo;
		
	}
}
