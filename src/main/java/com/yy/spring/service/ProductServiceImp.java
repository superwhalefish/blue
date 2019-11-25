package com.yy.spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yy.spring.dao.ProductDao;
import com.yy.spring.entity.Product;
import com.yy.spring.entity.ProductImg;
import com.yy.spring.entity.Repertory;
import com.yy.spring.repositry.ProductImgRepositry;
import com.yy.spring.repositry.ProductRepositry;
import com.yy.spring.repositry.RepertoryRepositry;
import com.yy.spring.utils.Random;

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

//商品查询
	@Override
	public Map<String, Object> getpro(Integer page, Integer limit,String search_pname, String search_shopid,String search_startprice,String search_endprice,String search_startuptime,String search_enduptime,String search_pstatus,String search_ptstatus) {
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
		Integer i = null;
		if (product_edit_pstatus > 0) {
			i = 1;
		} else {
			i = 0;
		}
		return i;
	}

//推荐
	@Override
	public Integer product_edit_ptstatus(Integer ptstatus, Integer pid) {
		// TODO Auto-generated method stub
		System.out.println("商品id===>" + pid);
		System.out.println("产品状态=====》" + ptstatus);
		Integer product_edit_pstatus = productDao.product_edit_ptstatus(ptstatus, pid);
		Integer i = null;
		if (product_edit_pstatus > 0) {
			i = 1;
		} else {
			i = 0;
		}
		return i;
	}

	// 商品 和 商品类别
	@Override
	public Map<String, Object> getProInfo(Integer pid) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<Product> proAndCate = productDao.getProAndCate(pid);
		List<Repertory> findAllByRidpid = repertoryRepositry.findAllByShopid(proAndCate.get(0).getPshopid());
		List<ProductImg> proimg = productImgRepositry.findAllByShopid(proAndCate.get(0).getPshopid());
		map.put("pro", proAndCate);
		map.put("img", proimg);
		map.put("rep", findAllByRidpid);
		return map;
	}

	@Override
	public Integer addpro(Product product) {
		// TODO Auto-generated method stub
		System.out.println(product);
		Random random = new Random();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(date);
		product.setClicknum(0);
		product.setPstatus(2);
		product.setPtstatus(2);
		product.setUptime(format);
		product.setPshopid(random.getRand());
		System.out.println(product);
		Product saveAndFlush = productRepositry.saveAndFlush(product);
		Integer i = null;
		if (saveAndFlush != null) {
			i = 1;
		} else {
			i = 0;
		}
		return i;
	}

	@Override
	public Integer editpriceBypid(Integer pprice, Integer pid) {
		// TODO Auto-generated method stub

		return productDao.editpriceBypid(pprice, pid);
	}

	@Override
	@Transactional
	public Integer delproinfo(Integer pid) {
		// TODO Auto-generated method stub
		List<Product> proAndCate = productDao.getProAndCate(pid);
		repertoryRepositry.deleteByShopid(proAndCate.get(0).getPshopid());
		productImgRepositry.deleteByShopid(proAndCate.get(0).getPshopid());
		productRepositry.deleteById(pid);
		boolean existsById = productRepositry.existsById(pid);
		Integer i=null;
		if(existsById) {
			i=0;
		}else {
			i=1;
		}
		return i;
	}

}
