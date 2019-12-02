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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yy.spring.entity.Repertory;
import com.yy.spring.repositry.RepertoryRepositry;

@Service
public class RepertoryServiceImp implements RepertoryService {
	@Autowired
	private RepertoryRepositry repertoryRepositry;

	@Override
	public Map<String, Object> getRep(Integer page, Integer limit, String shopid) {
		// TODO Auto-generated method stub
		Pageable pagerequest = PageRequest.of(page - 1, limit);
		Page<Repertory> findAll = repertoryRepositry.findAll(get(shopid), pagerequest);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", findAll.getTotalElements());
		map.put("data", findAll.getContent());
		return map;
	}

	@SuppressWarnings("unused")
	private Specification<Repertory> get(final String shopid) {
		return new Specification<Repertory>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Repertory> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				// TODO Auto-generated method stub
				Predicate conjunction = criteriaBuilder.conjunction();
				List<Expression<Boolean>> expressions = conjunction.getExpressions();
				if (!StringUtils.isEmpty(shopid)) {
					expressions.add(criteriaBuilder.equal(root.<String>get("shopid"), "shopid"));
				}
				return conjunction;
			}
		};

	}

//修改库存
	@Override
	public Integer updateRep(Repertory repertory) {
		// TODO Auto-generated method stub

		List<Repertory> findAllByShopid = repertoryRepositry.findAllByShopid(repertory.getShopid());
		Integer j = null;
		if (findAllByShopid != null) {
			for (int i = 0; i < findAllByShopid.size(); i++) {
				if (repertory.getRpcolor().equals(findAllByShopid.get(i).getRpcolor())) {
					if (repertory.getRtype().equals(findAllByShopid.get(i).getRtype())) {
						findAllByShopid.get(i).setRpcolor(repertory.getRpcolor());
						findAllByShopid.get(i).setRtype(repertory.getRtype());
						findAllByShopid.get(i).setRpnum(repertory.getRpnum() + findAllByShopid.get(i).getRpnum());
						Repertory saveAndFlush = repertoryRepositry.saveAndFlush(findAllByShopid.get(i));
						if (saveAndFlush != null) {
							j = 1;
						} else {
							j = 0;
						}
					} else {
						Repertory saveAndFlush = repertoryRepositry.saveAndFlush(repertory);
						if (saveAndFlush != null) {
							j = 1;
						} else {
							j = 0;
						}
					}
				} else {
					Repertory saveAndFlush = repertoryRepositry.saveAndFlush(repertory);
					if (saveAndFlush != null) {
						j = 1;
					} else {
						j = 0;
					}
				}
			}
		} else {
			Repertory saveAndFlush = repertoryRepositry.saveAndFlush(repertory);
			if (saveAndFlush != null) {
				j = 1;
			} else {
				j = 0;
			}
		}

		/*
		 * Repertory save = repertoryRepositry.save(repertory); Integer i = null; if
		 * (save != null) { i = 1; } else { i = 0; }
		 */
		return j;
	}

//添加
	@Override
	public Integer repertory_add(Repertory repertory) {
		// TODO Auto-generated method stub
		List<Repertory> findAllByShopid = repertoryRepositry.findAllByShopid(repertory.getShopid());
		Integer j = null;
		if (findAllByShopid != null) {
			for (int i = 0; i < findAllByShopid.size(); i++) {
				if (repertory.getRpcolor().equals(findAllByShopid.get(i).getRpcolor())) {
					if (repertory.getRtype().equals(findAllByShopid.get(i).getRtype())) {
						findAllByShopid.get(i).setRpcolor(repertory.getRpcolor());
						findAllByShopid.get(i).setRtype(repertory.getRtype());
						findAllByShopid.get(i).setRpnum(repertory.getRpnum() + findAllByShopid.get(i).getRpnum());
						Repertory saveAndFlush = repertoryRepositry.saveAndFlush(findAllByShopid.get(i));
						if (saveAndFlush != null) {
							j = 1;
						} else {
							j = 0;
						}
					} else {
						Repertory saveAndFlush = repertoryRepositry.saveAndFlush(repertory);
						if (saveAndFlush != null) {
							j = 1;
						} else {
							j = 0;
						}
					}
				} else {
					Repertory saveAndFlush = repertoryRepositry.saveAndFlush(repertory);
					if (saveAndFlush != null) {
						j = 1;
					} else {
						j = 0;
					}
				}
			}
		} else {
			j=2;
			/*
			 * Repertory saveAndFlush = repertoryRepositry.saveAndFlush(repertory); if
			 * (saveAndFlush != null) { j = 1; } else { j = 0; }
			 */
		}

		return j;
	}
}
