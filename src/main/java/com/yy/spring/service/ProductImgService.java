package com.yy.spring.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.yy.spring.entity.ProductImg;

public interface ProductImgService {
	/**
	 * 查询图片
	 * 
	 * @param page
	 * @param limit
	 * @param shopid
	 * @return
	 */
	public Map<String, Object> getImg(Integer page, Integer limit, String shopid);
	/**
	 * 图片上传
	 * @return
	 */
	public Map<String,Object>uploadImg(MultipartFile file, HttpServletRequest request);
	/**
	 * 图片修改
	 * @param productImg
	 * @return
	 */
	public Integer productImgEdit(ProductImg productImg);
	/**
	 * 删除图片
	 * @param iid
	 * @return
	 */
	public Integer delByIid(Integer iid);
	/**
	 * 添加图片
	 * @param productImg
	 * @return
	 */
	public Integer productImg_add(ProductImg productImg);
}
