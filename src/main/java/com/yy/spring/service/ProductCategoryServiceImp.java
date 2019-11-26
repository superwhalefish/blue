package com.yy.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yy.spring.entity.ProductCategroy;
import com.yy.spring.repositry.ProductCategroyRepositry;

@Service
public class ProductCategoryServiceImp implements ProductCategoryService {
	@Autowired
	public ProductCategroyRepositry productCategroyRepositry;

//查所有
	@Override
	public List<ProductCategroy> getProCate() {
		// TODO Auto-generated method stub
		List<ProductCategroy> findAll = productCategroyRepositry.findAll();
		return findAll;
	}

//条件查所有
	@Override
	public Map<String, Object> findProCate(Integer page, Integer limit, String cpname) {
		// TODO Auto-generated method stub
		List<ProductCategroy> findAll = productCategroyRepositry.findAll();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", findAll.size());
		map.put("data", findAll);
		return map;
	}

	@Override
	public Integer updateCate(ProductCategroy productCategroy) {
		// TODO Auto-generated method stub
		ProductCategroy saveAndFlush = productCategroyRepositry.saveAndFlush(productCategroy);
		if(saveAndFlush!=null) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public Integer deleteCateByCpid(Integer cpid) {
		// TODO Auto-generated method stub
		
		productCategroyRepositry.deleteById(cpid);
		if(productCategroyRepositry.existsById(cpid)) {
			return 0;
		}else {
			return 1;
		}
	}

	@Override
	public Integer addCate(ProductCategroy productCategroy) {
		// TODO Auto-generated method stub
		
		ProductCategroy save = productCategroyRepositry.save(productCategroy);
		if(save!=null) {
			return 1;
		}else {
			return 0;
		}
	}

}
