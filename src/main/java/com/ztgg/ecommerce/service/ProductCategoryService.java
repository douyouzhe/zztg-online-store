package com.ztgg.ecommerce.service;

import java.util.List;

import com.ztgg.ecommerce.dto.ProductCategoryExecution;
import com.ztgg.ecommerce.entity.ProductCategory;
import com.ztgg.ecommerce.exceptions.ProductCategoryOperationException;


public interface ProductCategoryService {
	/**
	 * 
	 * 
	 * @param long shopId
	 * @return List<ProductCategory>
	 */
	List<ProductCategory> getProductCategoryList(long shopId);	
	
	
	/**
	 * 
	 * @param productCategory
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException;
	
	/**
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 * @throws RuntimeException
	 */
	ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
			throws ProductCategoryOperationException;
}
