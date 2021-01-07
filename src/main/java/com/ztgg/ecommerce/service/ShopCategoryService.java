package com.ztgg.ecommerce.service;

import java.util.List;

import com.ztgg.ecommerce.entity.ShopCategory;



public interface ShopCategoryService {

	/**
	 * 
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
