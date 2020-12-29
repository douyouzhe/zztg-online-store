package com.ztgg.ecommerce.service;

import java.io.File;

import com.ztgg.ecommerce.dto.ShopDto;
import com.ztgg.ecommerce.entity.Shop;

public interface ShopService {

	/**
	 * register for a new shop, with image processing
	 * 
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 */
	ShopDto addShop(Shop shop, File thumbnail);
}
