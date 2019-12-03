package com.yy.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yy.spring.entity.TuiJian;
import com.yy.spring.service.TuiJianService;

@RestController
@CrossOrigin
public class TuiJianController {
	@Autowired
	private TuiJianService tuiJianService;

//获取数据
	@PostMapping("/tuiJian_getTuijian")
	public Map<String, Object> getTuiJian(Integer page, Integer limit, String shopid) {

		return tuiJianService.getTuijian(page, limit, shopid);

	}

	// 修改
	@PostMapping("/tuiJian_edit")
	public Integer tuiJian_edit(TuiJian tuiJian) {

		return tuiJianService.edittuijian(tuiJian);

	}

	// 添加
	@PostMapping("/tuijian_add")
	public Integer tuiJian_add(TuiJian tuiJian) {
		return tuiJianService.addtuijian(tuiJian);

	}
	//删除
	@PostMapping("/tuijian_del")
	public Integer tuijian_del(Integer tid) {
		return tuiJianService.del(tid);
		
	}

}
