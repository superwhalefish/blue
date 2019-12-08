package com.yy.spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.directory.DirContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yy.spring.dao.ProductDao;
import com.yy.spring.entity.Product;
import com.yy.spring.entity.ProductImg;
import com.yy.spring.entity.Repertory;
import com.yy.spring.repositry.ProductImgRepositry;
import com.yy.spring.repositry.ProductRepositry;
import com.yy.spring.repositry.RepertoryRepositry;
import com.yy.spring.utils.Random;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

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
	public Map<String, Object> getpro(Integer page, Integer limit, String search_pname, String search_shopid,
			String search_startprice, String search_endprice, String search_startuptime, String search_enduptime,
			String search_pstatus, String search_ptstatus) {
		// TODO Auto-generated method stub
		Pageable pagerequest = PageRequest.of(page - 1, limit, Direction.DESC, "pid");
		Page<Product> findAll = productRepositry.findAll(get(search_pname, search_shopid, search_startprice, search_endprice, search_startuptime, search_enduptime, search_pstatus, search_ptstatus),
				pagerequest);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", findAll.getTotalElements());
		map.put("data", findAll.getContent());
		return map;
	}

	@SuppressWarnings("unused")
	private Specification<Product> get(final String search_pname, final String search_shopid,
			final String search_startprice, final String search_endprice, final String search_startuptime,
			final String search_enduptime, final String search_pstatus, final String search_ptstatus) {
		return new Specification<Product>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				Predicate conjunction = criteriaBuilder.conjunction();
				List<Expression<Boolean>> expressions = conjunction.getExpressions();
				if (!StringUtils.isEmpty(search_pname)) {
					expressions.add(criteriaBuilder.like(root.<String>get("pname"), search_pname));
				}
				if (!StringUtils.isEmpty(search_shopid)) {
					expressions.add(criteriaBuilder.equal(root.<String>get("shopid"), search_shopid));
				}
				if (!StringUtils.isEmpty(search_startprice)) {
					double parseDouble = Double.parseDouble(search_startprice);
					expressions.add(criteriaBuilder.greaterThanOrEqualTo(root.<Double>get("pprice"), parseDouble));
				}
				if (!StringUtils.isEmpty(search_endprice)) {
					double parseDouble = Double.parseDouble(search_endprice);
					expressions.add(criteriaBuilder.lessThanOrEqualTo(root.<Double>get("pprice"), parseDouble));
				}
				if (!StringUtils.isEmpty(search_startuptime)) {
					expressions
							.add(criteriaBuilder.greaterThanOrEqualTo(root.<String>get("uptime"), search_startuptime));
				}
				if (!StringUtils.isEmpty(search_enduptime)) {
					expressions.add(criteriaBuilder.lessThanOrEqualTo(root.<String>get("uptime"), search_enduptime));
				}
				if (!StringUtils.isEmpty(search_pstatus)) {
					int parseInt = Integer.parseInt(search_pstatus);
					expressions.add(criteriaBuilder.equal(root.<Integer>get("pstatus"), parseInt));
				}
				if (!StringUtils.isEmpty(search_ptstatus)) {
					int parseInt = Integer.parseInt(search_ptstatus);
					expressions.add(criteriaBuilder.equal(root.<Integer>get("ptstatus"), parseInt));
				}
				return conjunction;
			}
		};

	}

//上架
	@Override
	public Integer product_edit_pstatus(Integer pid, Integer pstatus) {
		// TODO Auto-generated method stub
		String newTime = new Random().getNewTime();
		Product product = new Product();
		product.setPid(pid);
		product.setPstatus(pstatus);
		product.setUptime(newTime);
		Integer product_edit_pstatus = productDao.product_edit_pstatus(product);
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
		Integer i = null;
		if (existsById) {
			i = 0;
		} else {
			i = 1;
		}
		return i;
	}

}
