package com.ztgg.ecommerce.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ztgg.ecommerce.BaseTest;
import com.ztgg.ecommerce.dto.ShopDto;
import com.ztgg.ecommerce.entity.Area;
import com.ztgg.ecommerce.entity.Shop;
import com.ztgg.ecommerce.entity.ShopCategory;
import com.ztgg.ecommerce.entity.User;
import com.ztgg.ecommerce.enums.ShopStateEnum;
import com.ztgg.ecommerce.exceptions.ShopOperationException;


public class ShopServiceTest extends BaseTest {
	@Autowired
	private ShopService shopService;

	@Test
	public void testAddShop() throws ShopOperationException, FileNotFoundException {
		Shop shop = mockANewShop(1L, 2, 1L);
		File shopImg = new File("/Users/youzhedou/Desktop/workspace/online-store/src/main/resources/test-images/bookstoreimg.png");
		InputStream inputStream = new FileInputStream(shopImg);
		ShopDto shopDto = shopService.addShop(shop, inputStream, shopImg.getName());
		assertEquals(ShopStateEnum.CHECK.getState(), shopDto.getState());
	}
	
	private Shop mockANewShop(Long userId, Integer areaId, Long shopCategoryId) {
		Shop shop = new Shop();
		User owner = new User();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		
		owner.setUserId(userId);
		area.setAreaId(areaId);
		shopCategory.setShopCategoryId(shopCategoryId);
		
		shop.setArea(area);
		shop.setOwner(owner);
		shop.setShopCategory(shopCategory);
		shop.setShopName("newshopusingsericeUT1");
		shop.setShopDesc("this is a shop generated by the unit test");
		shop.setShopAddr("123 Boyton Ave");
		shop.setPhone("4323456753");
		shop.setShopImg("testImg");
		shop.setTimeCreated(new Date());
		shop.setEnableStatus(0);
		shop.setPriority(1);
		
		return shop;
	}
}
