package com.ztgg.ecommerce.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.ztgg.ecommerce.BaseTest;
import com.ztgg.ecommerce.entity.ProductImg;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductImgDaoTest extends BaseTest {
	@Autowired
	private ProductImgDao productImgDao;

	@Test
	public void testABatchInsertProductImg() throws Exception {
		// add two images to product with id===1
		ProductImg productImg1 = new ProductImg();
		productImg1.setImgAddr("img1");
		productImg1.setImgDesc("testimg1");
		productImg1.setPriority(1);
		productImg1.setTimeCreated(new Date());
		productImg1.setProductId(1L);
		ProductImg productImg2 = new ProductImg();
		productImg2.setImgAddr("img2");
		productImg2.setPriority(1);
		productImg2.setTimeCreated(new Date());
		productImg2.setProductId(1L);
		List<ProductImg> productImgList = new ArrayList<ProductImg>();
		productImgList.add(productImg1);
		productImgList.add(productImg2);
		int effectedNum = productImgDao.batchInsertProductImg(productImgList);
		assertEquals(2, effectedNum);
	}

	@Test
	public void testBQueryProductImgList() {
		List<ProductImg> productImgList = productImgDao.queryProductImgList(1L);
		assertEquals(2, productImgList.size());
	}

	@Test
	public void testCDeleteProductImgByProductId() throws Exception {
		long productId = 1;
		int effectedNum = productImgDao.deleteProductImgByProductId(productId);
		assertEquals(2, effectedNum);
	}
}
