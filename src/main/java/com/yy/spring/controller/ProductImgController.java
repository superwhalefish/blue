package com.yy.spring.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yy.spring.entity.ProductImg;
import com.yy.spring.service.ProductImgService;
import com.yy.spring.utils.FileUploadUtil;

@RestController
@CrossOrigin
public class ProductImgController {
	@Autowired
	private ProductImgService productImgService;
//获取数据
	@PostMapping("/productImg_getImg")
	public Map<String, Object> getImg(Integer page, Integer limit, String shopid) {
		return productImgService.getImg(page, limit, shopid);

	}
//图片上传
	@PostMapping("/productImg_upload")
	public Map<String, Object> uploadImg(MultipartFile file, HttpServletRequest request) {
		 
	          return productImgService.uploadImg(file, request);
	}
	//图片修改
	@PostMapping("/productImg_update")
	public Integer upadeimg(ProductImg productImg) {
		
		return productImgService.productImgEdit(productImg);
		
	}
	//图片删除
	@PostMapping("/productImg_del")
	public Integer productImgDel(Integer iid) {
		return productImgService.delByIid(iid);
		
	}
	//图片添加
	@PostMapping("/productImg_add")
	public Integer productImg_add(ProductImg productImg) {
		return productImgService.productImg_add(productImg);
		
	}
}
