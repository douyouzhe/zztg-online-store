package com.ztgg.ecommerce.dao;

import java.util.List;

import com.ztgg.ecommerce.entity.ProductImg;



public interface ProductImgDao {

	/**
	 * 
	 * 
	 * @param productId
	 * @return
	 */
	List<ProductImg> queryProductImgList(long productId);

	/**
	 * Batch insert
	 * 
	 * @param productImgList
	 * @return
	 */
	int batchInsertProductImg(List<ProductImg> productImgList);

	/**
	 * 
	 * 
	 * @param productId
	 * @return
	 */
	int deleteProductImgByProductId(long productId);
}
