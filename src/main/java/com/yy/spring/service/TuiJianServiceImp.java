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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yy.spring.entity.Product;
import com.yy.spring.entity.TuiJian;
import com.yy.spring.repositry.ProductRepositry;
import com.yy.spring.repositry.TuiJianRepositry;

@Service
public class TuiJianServiceImp implements TuiJianService {
//获取折扣信息
	@Autowired
	private TuiJianRepositry tuiJianRepositry;
	@Autowired
	private ProductRepositry productRepositry;

	@Override
	public Map<String, Object> getTuijian(Integer page, Integer limit, String shopid) {
		// TODO Auto-generated method stub
		PageRequest pagerequest = PageRequest.of(page - 1, limit);
		Page<TuiJian> findAll = tuiJianRepositry.findAll(get(shopid), pagerequest);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", findAll.getTotalElements());
		map.put("data", findAll.getContent());
		return map;
	}

	@SuppressWarnings("unused")
	private Specification<TuiJian> get(final String shopid) {
		return new Specification<TuiJian>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<TuiJian> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				Predicate conjunction = criteriaBuilder.conjunction();
				List<Expression<Boolean>> expressions = conjunction.getExpressions();
				if (!StringUtils.isEmpty(shopid)) {
					expressions.add(criteriaBuilder.equal(root.<String>get("pshopid"), shopid));
				}
				return conjunction;
			}
		};

	}

//修改折扣信息
	@Override
	public Integer edittuijian(TuiJian tuiJian) {
		// TODO Auto-generated method stub
		Integer i = null;
		TuiJian saveAndFlush = tuiJianRepositry.saveAndFlush(tuiJian);
		if (saveAndFlush != null) {
			i = 1;
		} else {
			i = 0;
		}
		return i;
	}

//添加折扣商品
	@Override
	public Integer addtuijian(TuiJian tuiJian) {
		Integer i = null;
		Product tuijian1 = productRepositry.findAllByPshopid(tuiJian.getPshopid());
		if (tuijian1 != null) {
			TuiJian findtuijian = tuiJianRepositry.findAllByPshopid(tuiJian.getPshopid());
			if (findtuijian != null) {
				if (tuiJian.getPshopid().equals(findtuijian.getPshopid())) {
					tuiJian.setTid(findtuijian.getTid());
					TuiJian saveAndFlush = tuiJianRepositry.saveAndFlush(tuiJian);
					if (saveAndFlush != null) {
						i = 2;// 此商品商品已被优惠，优惠数据已更新
					} else {
						i = 0;// 添加失败
					}
				} else {
					TuiJian saveAndFlush = tuiJianRepositry.saveAndFlush(tuiJian);
					if (saveAndFlush != null) {
						i = 1;// 添加成功
					} else {
						i = 0;// 添加失败
					}
				}
			} else {
				System.out.println(tuiJian);
				TuiJian saveAndFlush = tuiJianRepositry.saveAndFlush(tuiJian);
				if (saveAndFlush != null) {
					i = 1;// 添加成功
				} else {
					i = 0;// 添加失败
				}
			}

		} else {
			i = 3;// 此商品不存在
		}
		return i;
	}

//删除
	@Override
	public Integer del(Integer tid) {
		// TODO Auto-generated method stub
		Integer i = null;
		tuiJianRepositry.deleteById(tid);
		boolean existsById = tuiJianRepositry.existsById(tid);
		if (existsById) {
			i = 0;
		} else {
			i = 1;
		}
		return i;
	}

}
