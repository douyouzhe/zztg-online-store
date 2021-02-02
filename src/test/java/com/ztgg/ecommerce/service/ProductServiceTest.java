package com.ztgg.ecommerce.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ztgg.ecommerce.BaseTest;
import com.ztgg.ecommerce.dto.ImageHolder;
import com.ztgg.ecommerce.dto.ProductExecution;
import com.ztgg.ecommerce.entity.Product;
import com.ztgg.ecommerce.entity.ProductCategory;
import com.ztgg.ecommerce.entity.Shop;
import com.ztgg.ecommerce.enums.ProductStateEnum;
import com.ztgg.ecommerce.exceptions.ShopOperationException;

public class ProductServiceTest extends BaseTest {
	@Autowired
	private ProductService productService;

	@Test
	public void testAddProduct() throws ShopOperationException, FileNotFoundException {
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(1L);
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(8L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("test1");
		product.setProductDesc("test1");
		product.setPriority(20);
		product.setTimeCreated(new Date());
		product.setEnableStatus(ProductStateEnum.SUCCESS.getState());

		File thumbnailFile = new File("/Users/youzhedou/Desktop/workspace/online-store/src/main/resources/test-images/bookstoreimg.png");
		InputStream is = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), is);

		File productImg1 = new File("/Users/youzhedou/Desktop/workspace/online-store/src/main/resources/test-images/1.jpeg");
		InputStream is1 = new FileInputStream(productImg1);
		File productImg2 = new File("/Users/youzhedou/Desktop/workspace/online-store/src/main/resources/test-images/2.png");
		InputStream is2 = new FileInputStream(productImg2);
		
		List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));

		ProductExecution pe = productService.addProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}

	@Test
	@Ignore
	public void testModifyProduct() throws ShopOperationException, FileNotFoundException {
		
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(1L);
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(8L);
		product.setProductId(1L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("modify1");
		product.setProductDesc("modify1");

		File thumbnailFile = new File("/Users/youzhedou/Desktop/workspace/online-store/src/main/resources/test-images/bookstoreimg.png");
		InputStream is = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), is);

		File productImg1 = new File("/Users/youzhedou/Desktop/workspace/online-store/src/main/resources/test-images/1.jpeg");
		InputStream is1 = new FileInputStream(productImg1);
		File productImg2 = new File("/Users/youzhedou/Desktop/workspace/online-store/src/main/resources/test-images/2.png");
		InputStream is2 = new FileInputStream(productImg2);
		List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));
	
		ProductExecution pe = productService.modifyProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}

}
