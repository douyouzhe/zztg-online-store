package com.ztgg.ecommerce.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ztgg.ecommerce.entity.ShopCategory;


public interface ShopCategoryDao {
	/**
	 * return a list of shop categories
	 * 
	 * @param shopCategoryCondition
	 * @return
	 */
	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
