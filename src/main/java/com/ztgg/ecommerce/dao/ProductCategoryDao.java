package com.ztgg.ecommerce.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;


import com.ztgg.ecommerce.entity.ProductCategory;


public interface ProductCategoryDao {
	/**
	 * guery ProductCategory by ShopId
	 * 
	 * @param long shopId
	 * @return List<ProductCategory>
	 */
	List<ProductCategory> queryProductCategoryList(long shopId);
	
	/**
	 * batch add
	 * 
	 * @param productCategoryList
	 * @return
	 */
	int batchInsertProductCategory(List<ProductCategory> productCategoryList);

	/**
	 * delete product category
	 * 
	 * @param productCategoryId
	 * @param shopId
	 * @return effectedNum
	 */
	int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);
}
