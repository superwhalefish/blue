package com.yy.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.yy.spring.entity.OrderInfo;
import com.yy.spring.entity.Orders;
import com.yy.spring.entity.Product;
import com.yy.spring.repositry.OrderInfoRepositry;
import com.yy.spring.repositry.OrdersRepositry;
import com.yy.spring.utils.Random;

@Service
public class OrdersServiceImp implements OrdersService {
	@Autowired
	private OrdersRepositry ordersRepositry;
	@Autowired
	private OrderInfoRepositry orderInfoRepositry;

	@Override
	public Map<String, Object> getOrd(Integer page, Integer limit, Orders orders) {
		// TODO Auto-generated method stub
		PageRequest pageable = PageRequest.of(page - 1, limit);
		Page<Orders> findAll = ordersRepositry.findAll(get(orders), pageable);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", findAll.getTotalElements());
		map.put("data", findAll.getContent());
		return map;
	}

	@SuppressWarnings("unused")
	private Specification<Orders> get(final Orders orders) {
		return new Specification<Orders>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				Predicate conjunction = criteriaBuilder.conjunction();
				List<Expression<Boolean>> expressions = conjunction.getExpressions();
				if (!StringUtils.isEmpty(orders.getOrdnumber())) {
					expressions.add(criteriaBuilder.equal(root.<String>get("ordnumber"), orders.getOrdnumber()));
				}
				if (!StringUtils.isEmpty(orders.getOpaystatus())) {
					expressions.add(criteriaBuilder.equal(root.<String>get("opaystatus"), orders.getOpaystatus()));
				}
				if (!StringUtils.isEmpty(orders.getOfhstatus())) {
					expressions.add(criteriaBuilder.equal(root.<String>get("ofhstatus"), orders.getOfhstatus()));
				}
				if (!StringUtils.isEmpty(orders.getOjsstatus())) {
					expressions.add(criteriaBuilder.equal(root.<String>get("ojsstatus"), orders.getOjsstatus()));
				}
				if (!StringUtils.isEmpty(orders.getPjstatus())) {
					expressions.add(criteriaBuilder.equal(root.<String>get("pjstatus"), orders.getPjstatus()));
				}
				if (!StringUtils.isEmpty(orders.getXordtime())) {
					expressions.add(
							criteriaBuilder.greaterThanOrEqualTo(root.<String>get("xordtime"), orders.getXordtime()));
				}
				return conjunction;
			}
		};

	}

//订单发货
	@Override
	public Integer updateofhstatus(Orders orders) {
		// TODO Auto-generated method stub
		String newTime = new Random().getNewTime();
		Orders findAllByOid = ordersRepositry.findByOid(orders.getOid());
		findAllByOid.setFordtime(newTime);
		findAllByOid.setOfhstatus(orders.getOfhstatus());
		Orders saveAndFlush = ordersRepositry.saveAndFlush(findAllByOid);
		Integer i = null;
		if (saveAndFlush != null) {
			i = 1;
		} else {
			i = 0;
		}
		return i;
	}

//查看订单详情
	@Override
	public List<OrderInfo> getOrdInfo(String ordnumber) {
		// TODO Auto-generated method stub
		List<OrderInfo> ordinfo=orderInfoRepositry.findAllByOrdnumber(ordnumber);
		List<String> olist=new ArrayList<String>();
		for(int i=0;i<ordinfo.size();i++) {
			olist.add(ordinfo.get(i).getOrdnumber());
		}
		List<OrderInfo> orderinfo=ordersRepositry.findAllByOrdnumber(olist);
		return orderinfo;
	}
}
