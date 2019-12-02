package com.yy.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yy.spring.entity.Repertory;
import com.yy.spring.service.RepertoryService;

@RestController
@CrossOrigin
public class RepertoryController {
	@Autowired
	private RepertoryService repertoryService;

//获取库存
	@PostMapping("/repertory_getrep")
	public Map<String, Object> getRep(Integer page, Integer limit, String shopid) {
		return repertoryService.getRep(page, limit, shopid);

	}

	// 修改库存
	@PostMapping("/repertory_update")
	public Integer repertory_update(Repertory repertory) {
		
		return repertoryService.updateRep(repertory);
	}
	//添加库存
	@PostMapping("/repertory_add")
	public Integer repertory_add(Repertory repertory) {
		return repertoryService.repertory_add(repertory);
		
	}
}
