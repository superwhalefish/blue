package com.yy.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yy.spring.entity.Product;
import com.yy.spring.entity.ProductCategroy;
import com.yy.spring.repositry.ProductCategroyRepositry;
import com.yy.spring.repositry.ProductRepositry;

@Service
public class ProductCategoryServiceImp implements ProductCategoryService {
	@Autowired
	public ProductCategroyRepositry productCategroyRepositry;

	@Autowired
	private ProductRepositry productRepositry;

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
		Pageable pagerequest = PageRequest.of(page - 1, limit);
		Page<ProductCategroy> findAll = productCategroyRepositry.findAll(get(cpname), pagerequest);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", findAll.getTotalElements());
		map.put("data", findAll.getContent());
		return map;
	}

	@SuppressWarnings("unused")
	private Specification<ProductCategroy> get(final String cpname) {
		return new Specification<ProductCategroy>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<ProductCategroy> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				Predicate conjunction = criteriaBuilder.conjunction();
				List<Expression<Boolean>> expressions = conjunction.getExpressions();
				if (!StringUtils.isEmpty(cpname)) {
					expressions.add(criteriaBuilder.like(root.<String>get("cpname"), cpname));
				}
				return conjunction;
			}
		};
	}

//修改名称
	@Override
	public Integer updateCate(ProductCategroy productCategroy) {
		// TODO Auto-generated method stub
		ProductCategroy saveAndFlush = productCategroyRepositry.saveAndFlush(productCategroy);
		if (saveAndFlush != null) {
			return 1;
		} else {
			return 0;
		}
	}

//删除
	@Override
	public Integer deleteCateByCpid(Integer cpid) {
		// TODO Auto-generated method stub
		List<Product> pro = productRepositry.findAllByCpid(cpid);
		Integer i = null;
		if (pro.size() > 0) {
			i = 2;
		} else {
			productCategroyRepositry.deleteById(cpid);
			if (productCategroyRepositry.existsById(cpid)) {
				i = 0;
			} else {
				i = 2;
			}
		}
		return i;

	}

//添加
	@Override
	public Integer addCate(ProductCategroy productCategroy) {
		// TODO Auto-generated method stub

		ProductCategroy save = productCategroyRepositry.save(productCategroy);
		if (save != null) {
			return 1;
		} else {
			return 0;
		}
	}

}
