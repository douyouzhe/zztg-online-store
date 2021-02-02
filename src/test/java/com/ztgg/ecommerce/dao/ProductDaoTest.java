package com.ztgg.ecommerce.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.ztgg.ecommerce.BaseTest;
import com.ztgg.ecommerce.entity.Product;
import com.ztgg.ecommerce.entity.ProductCategory;
import com.ztgg.ecommerce.entity.ProductImg;
import com.ztgg.ecommerce.entity.Shop;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductDaoTest extends BaseTest {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductImgDao productImgDao;

	@Test
	public void testAInsertProduct() throws Exception {
		Shop shop1 = new Shop();
		shop1.setShopId(10L);
		ProductCategory pc1 = new ProductCategory();
		pc1.setProductCategoryId(8L);
	
		Product product1 = new Product();
		product1.setProductName("test1");
		product1.setProductDesc("testDesc1");
		product1.setImgAddr("testimg1");
		product1.setPriority(1);
		product1.setEnableStatus(1);
		product1.setTimeCreated(new Date());
		product1.setTimeUpdated(new Date());
		product1.setShop(shop1);
		product1.setProductCategory(pc1);
		Product product2 = new Product();
		product2.setProductName("test2");
		product2.setProductDesc("testDesc2");
		product2.setImgAddr("testimg2");
		product2.setPriority(2);
		product2.setEnableStatus(0);
		product2.setTimeCreated(new Date());
		product2.setTimeUpdated(new Date());
		product2.setShop(shop1);
		product2.setProductCategory(pc1);
		Product product3 = new Product();
		product3.setProductName("test3");
		product3.setProductDesc("testDesc3");
		product3.setImgAddr("testimg3");
		product3.setPriority(3);
		product3.setEnableStatus(1);
		product3.setTimeCreated(new Date());
		product3.setTimeUpdated(new Date());
		product3.setShop(shop1);
		product3.setProductCategory(pc1);
		
		int effectedNum = productDao.insertProduct(product1);
		assertEquals(1, effectedNum);
		effectedNum = productDao.insertProduct(product2);
		assertEquals(1, effectedNum);
		effectedNum = productDao.insertProduct(product3);
		assertEquals(1, effectedNum);
	}

	@Test
	public void testBQueryProductList() throws Exception {
		Product productCondition = new Product();
		
		List<Product> productList = productDao.queryProductList(productCondition, 0, 3);
		assertEquals(3, productList.size());
		
		productCondition.setProductName("test");
		productList = productDao.queryProductList(productCondition, 0, 3);
		assertEquals(3, productList.size());
	}

	@Test
	public void testCQueryProductByProductId() throws Exception {
		long productId = 1;
		
		ProductImg productImg1 = new ProductImg();
		productImg1.setImgAddr("图片1");
		productImg1.setImgDesc("测试图片1");
		productImg1.setPriority(1);
		productImg1.setTimeCreated(new Date());
		productImg1.setProductId(productId);
		ProductImg productImg2 = new ProductImg();
		productImg2.setImgAddr("图片2");
		productImg2.setPriority(1);
		productImg2.setTimeCreated(new Date());
		productImg2.setProductId(productId);
		List<ProductImg> productImgList = new ArrayList<ProductImg>();
		productImgList.add(productImg1);
		productImgList.add(productImg2);
		int effectedNum = productImgDao.batchInsertProductImg(productImgList);
		assertEquals(2, effectedNum);
		
		Product product = productDao.queryProductById(productId);
		assertEquals(2, product.getProductImgList().size());
	
		effectedNum = productImgDao.deleteProductImgByProductId(productId);
		assertEquals(2, effectedNum);
	}

	@Test
	public void testDUpdateProduct() throws Exception {
		Product product = new Product();
		ProductCategory pc = new ProductCategory();
		Shop shop = new Shop();
		shop.setShopId(10L);
		pc.setProductCategoryId(8L);
		product.setProductId(1L);
		product.setShop(shop);
		product.setProductName("2nd product");
		product.setProductCategory(pc);
		int effectedNum = productDao.updateProduct(product);
		assertEquals(1, effectedNum);
	}

	@Test
	@Ignore
	public void testEUpdateProductCategoryToNull() {
		int effectedNum = productDao.updateProductCategoryToNull(8L);
		assertEquals(3, effectedNum);
	}

	@Test
	public void testFDeleteShopAuthMap() throws Exception {
		Product productCondition = new Product();
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(8L);
		productCondition.setProductCategory(pc);
		List<Product> productList = productDao.queryProductList(productCondition, 0, 3);
		assertEquals(3, productList.size());
		
		for (Product p : productList) {
			int effectedNum = productDao.deleteProduct(p.getProductId(), 10);
			assertEquals(1, effectedNum);
		}
	}
}
