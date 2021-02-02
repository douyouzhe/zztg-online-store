package com.ztgg.ecommerce.service;

import java.util.List;

import com.ztgg.ecommerce.dto.ImageHolder;
import com.ztgg.ecommerce.dto.ProductExecution;
import com.ztgg.ecommerce.entity.Product;
import com.ztgg.ecommerce.exceptions.ProductOperationException;

public interface ProductService {
	/**
	 * 
	 * 
	 * @param productCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);

	/**
	 * 
	 * 
	 * @param productId
	 * @return
	 */
	Product getProductById(long productId);

	/**
	 * 
	 * 
	 * @param product
	 * @param thumbnail
	 * @param productImgs
	 * @return
	 * @throws ProductOperationException
	 */
	ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
			throws ProductOperationException;

	/**
	 * 
	 * 
	 * @param product
	 * @param thumbnail
	 * @param productImgs
	 * @return
	 * @throws ProductOperationException
	 */
	ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
			throws ProductOperationException;
}
