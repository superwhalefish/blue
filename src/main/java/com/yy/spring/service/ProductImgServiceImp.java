package com.yy.spring.service;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.yy.spring.entity.ProductImg;
import com.yy.spring.repositry.ProductImgRepositry;
import com.yy.spring.utils.FileUploadUtil;

@Service
public class ProductImgServiceImp implements ProductImgService {
	@Autowired
	private ProductImgRepositry productImgRepositry;

//获取图片
	@Override
	public Map<String, Object> getImg(Integer page, Integer limit, String shopid) {
		// TODO Auto-generated method stub
		PageRequest pagerequest = PageRequest.of(page - 1, limit);
		Page<ProductImg> findAll = productImgRepositry.findAll(get(shopid), pagerequest);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", findAll.getTotalElements());
		map.put("data", findAll.getContent());
		return map;
	}

	@SuppressWarnings("unused")
	private Specification<ProductImg> get(String shopid) {
		return new Specification<ProductImg>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<ProductImg> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				Predicate conjunction = criteriaBuilder.conjunction();
				List<Expression<Boolean>> expressions = conjunction.getExpressions();
				if (!StringUtils.isEmpty(shopid)) {
					expressions.add(criteriaBuilder.equal(root.<String>get("shopid"), shopid));
				}

				return conjunction;
			}
		};

	}

	@Override
	public Map<String, Object> uploadImg(MultipartFile file, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Map<String, Object> data = new HashMap<>();
		String url = "";
		if (!file.isEmpty()) {
			url = FileUploadUtil.saveImage(file, "D:\\desk\\freework\\X-admin-v2.2\\houtai\\bluewhale\\image\\",
					request);
		}
		data.put("url", url);
		return data;
	}

//修改图片
	@Override
	public Integer productImgEdit(ProductImg productImg) {
		// TODO Auto-generated method stub
		System.out.println(productImg);
		ProductImg save = productImgRepositry.save(productImg);
		Integer i = null;
		if (save != null) {
			i = 1;
		} else {
			i = 0;
		}
		return i;
	}

//删除图片
	@Override
	public Integer delByIid(Integer iid) {
		// TODO Auto-generated method stub
		productImgRepositry.deleteById(iid);
		boolean existsById = productImgRepositry.existsById(iid);
		Integer i = null;
		if (existsById) {
			i = 0;
		} else {
			i = 1;
		}
		return i;
	}

//添加图片
	@Override
	public Integer productImg_add(ProductImg productImg) {
		// TODO Auto-generated method stub
		ProductImg saveAndFlush = productImgRepositry.saveAndFlush(productImg);
		Integer i = null;
		if (saveAndFlush != null) {
			i = 1;
		} else {
			i = 0;
		}
		return i;
	}

}
