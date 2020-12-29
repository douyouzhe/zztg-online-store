package com.ztgg.ecommerce.service;

import java.io.InputStream;

import com.ztgg.ecommerce.dto.ShopDto;
import com.ztgg.ecommerce.entity.Shop;
import com.ztgg.ecommerce.exceptions.ShopOperationException;

public interface ShopService {

	/**
	 * register for a new shop, with image processing
	 * 
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 */
	ShopDto addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
