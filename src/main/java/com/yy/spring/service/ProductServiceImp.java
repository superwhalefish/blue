package com.yy.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yy.spring.dao.ProductDao;
import com.yy.spring.entity.Product;
import com.yy.spring.entity.ProductImg;
import com.yy.spring.entity.Repertory;
import com.yy.spring.repositry.ProductImgRepositry;
import com.yy.spring.repositry.ProductRepositry;
import com.yy.spring.repositry.RepertoryRepositry;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductRepositry productRepositry;
	@Autowired
	private ProductImgRepositry productImgRepositry;
	@Autowired
	private RepertoryRepositry repertoryRepositry;
	@Autowired
	private ProductDao productDao;

	@Override
	public Map<String, Object> getpro() {
		// TODO Auto-generated method stub
		List<Product> findAll = productRepositry.findAll();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", findAll.size());
		map.put("data", findAll);
		return map;
	}
//上架
	@Override
	public Integer product_edit_pstatus(Integer pid, Integer pstatus) {
		// TODO Auto-generated method stub
		Integer product_edit_pstatus = productDao.product_edit_pstatus(pstatus, pid);
		Integer i=null;
		if(product_edit_pstatus>0) {
			i=1;
		}else {
			i=0;
		}
		return i;
	}
//推荐
	@Override
	public Integer product_edit_ptstatus(Integer ptstatus, Integer pid) {
		// TODO Auto-generated method stub
		System.out.println("商品id===>"+pid);
		System.out.println("产品状态=====》"+ptstatus);
		Integer product_edit_pstatus = productDao.product_edit_ptstatus(ptstatus, pid);
		Integer i=null;
		if(product_edit_pstatus>0) {
			i=1;
		}else {
			i=0;
		}
		return i;
	}
	//商品 和 商品类别
	@Override
	public	Map<String,Object> getProInfo(Integer pid) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		List<Product> proAndCate = productDao.getProAndCate(pid);
		List<Repertory> findAllByRidpid = repertoryRepositry.findAllByRidpid(pid);
		List<ProductImg> proimg=productImgRepositry.findAllByIid(pid);
		map.put("pro", proAndCate);
		map.put("img",proimg);
		map.put("rep", findAllByRidpid);
		return map;
	}

}
