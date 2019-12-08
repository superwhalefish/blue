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
	public Map<String, Object> getpro(Integer page, Integer limit,String search_pname, String search_shopid,String search_startprice,String search_endprice,String search_startuptime,String search_enduptime,String search_pstatus,String search_ptstatus) {
		//String search_pname, String search_shopid,String search_startprice,String search_endprice,String search_startuptime,String search_enduptime,String search_pstatus,String search_ptstatus
		Map<String, Object> getpro = productService.getpro(page, limit, search_pname, search_shopid, search_startprice, search_endprice, search_startuptime, search_enduptime, search_pstatus, search_ptstatus);
		return getpro;

	}

	/**
	 * 商品上架状态
	 * 
	 * @param pid
	 * @param pstatus
	 * @return
	 */
	@PostMapping("/product_edit_pstatus")
	public Integer product_edit_pstatus(Integer pid, Integer pstatus) {
		Integer product_edit_pstatus = productService.product_edit_pstatus(pid, pstatus);
		return product_edit_pstatus;
	}

	/**
	 * 商品推荐状态
	 * 
	 * @param ptstatus
	 * @param pid
	 * @return
	 */
	@PostMapping("/product_edit_ptstatus")
	public Integer product_edit_ptstatus(Integer ptstatus, Integer pid) {
		System.out.println("hahahha");
		System.out.println(ptstatus);
		System.out.println(pid);
		Integer product_edit_ptstatus = productService.product_edit_ptstatus(ptstatus, pid);
		return product_edit_ptstatus;

	}
/**
 * 查看商品详情
 * @param pid
 * @return
 */
	@PostMapping("/product_look_pid")
	public Map<String, Object> product_look_pid(Integer pid) {
		Map<String, Object> proInfo = productService.getProInfo(pid);
		System.out.println(proInfo);
		return proInfo;

	}
/**
 * 添加商品
 * @param product
 * @return
 */
	@PostMapping("/product_addpro")
	public Integer product_addpro(Product product) {
		return productService.addpro(product);

	}
	/**
	 * 修改商品价格
	 * @param pprice
	 * @param pid
	 * @return
	 */
	@PostMapping("/product_editprice")
	public Integer product_editprice(Integer pprice,Integer pid) {
		return productService.editpriceBypid(pprice, pid);
		
	}
	/**
	 * 删除商品信息
	 * @return
	 */
	@PostMapping("/product_delByShopId")
	public Integer del(Integer pid) {
		return productService.delproinfo(pid);
		
	}
}
