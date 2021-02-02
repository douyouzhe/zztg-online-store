package com.ztgg.ecommerce.service;


import com.ztgg.ecommerce.dto.ImageHolder;
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
	ShopDto addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
	
	/**
	 * get shop by ID
	 * 
	 * @param shopId
	 * @return
	 */
	Shop getByShopId(long shopId);

	/**
	 * update shop Info
	 * 
	 * @param shop
	 * @param shopImg
	 * @return
	 * @throws ShopOperationException
	 */
	ShopDto modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
	
	/**
	 * return pagintaed shop list based on filters
	 * 
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ShopDto getShopList(Shop shopCondition, int pageIndex, int pageSize);
}
