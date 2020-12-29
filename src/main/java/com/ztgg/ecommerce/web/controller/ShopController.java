package com.ztgg.ecommerce.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ztgg.ecommerce.dto.ShopDto;
import com.ztgg.ecommerce.entity.Shop;
import com.ztgg.ecommerce.entity.User;
import com.ztgg.ecommerce.enums.ShopStateEnum;
import com.ztgg.ecommerce.exceptions.ShopOperationException;
import com.ztgg.ecommerce.service.ShopService;
import com.ztgg.ecommerce.util.HttpServletRequestUtil;


@Controller
@RequestMapping("/shopadmin")
public class ShopController {
	
	@Autowired
	ShopService shopService;
	
	@RequestMapping(value = "/registershop", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> registerShop(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
	
		// 1.get and transform all input data
		
		//for shop object
		String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
		ObjectMapper mapper = new ObjectMapper();
		Shop shop = null;
		try {
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("errMsg", e.getMessage());
			return modelMap;
		}
		
		// for image
		CommonsMultipartFile shopImg = null;
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		if (commonsMultipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
			shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "can't upload empty image");
			return modelMap;
		}
		// 2.register shop
		if (shop != null && shopImg != null) {
			// TODO: manually set owner info here, but should get it from session in the future
			User owner = new User();
			owner.setUserId(1L);
			shop.setOwner(owner);
			ShopDto shopDto;
			try {
				shopDto = shopService.addShop(shop, shopImg.getInputStream(),shopImg.getOriginalFilename());
				if (shopDto.getState() == ShopStateEnum.CHECK.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", shopDto.getStateInfo());
				}
			} catch (ShopOperationException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			} catch (IOException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.getMessage());
			}
			return modelMap;
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "can't insert empty shop");
			return modelMap;
		}
	}
}
