package com.ztgg.ecommerce.dao;

import com.ztgg.ecommerce.entity.Shop;


public interface ShopDao {

	/**
	 * register a new shop
	 * 
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);

	/**
	 * update existing shop
	 * 
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
