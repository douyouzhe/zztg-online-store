package com.ztgg.ecommerce.service.impl;

import java.io.File;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ztgg.ecommerce.dao.ShopDao;
import com.ztgg.ecommerce.dto.ShopDto;
import com.ztgg.ecommerce.entity.Shop;
import com.ztgg.ecommerce.enums.ShopStateEnum;
import com.ztgg.ecommerce.exceptions.ShopOperationException;
import com.ztgg.ecommerce.service.ShopService;
import com.ztgg.ecommerce.util.ImageUtil;
import com.ztgg.ecommerce.util.PathUtil;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDao shopDao;

	@Override
	@Transactional
	public ShopDto addShop(Shop shop, File thumbnail) {
		// empty shop input
		if (shop == null) {
			return new ShopDto(ShopStateEnum.NULL_SHOP);
		}
		try {
			// set status to CHECK
			shop.setEnableStatus(0);
			shop.setTimeCreated(new Date());
			shop.setTimeUpdated(new Date());
			
			int effectedNum = shopDao.insertShop(shop);
			
			if (effectedNum <= 0) {
				throw new ShopOperationException("error creating new shop");
			} else {
				if (thumbnail != null) {
					// shop image
					try {
						addShopImg(shop, thumbnail);
					} catch (Exception e) {
						throw new ShopOperationException("addShopImg error:" + e.getMessage());
					}
					// update shop image
					effectedNum = shopDao.updateShop(shop);
					if (effectedNum <= 0) {
						throw new ShopOperationException("update ShopImg failed");
					}
				}
			}
		} catch (Exception e) {
			throw new ShopOperationException("addShop error:" + e.getMessage());
		}
		return new ShopDto(ShopStateEnum.CHECK, shop);
	}

	private void addShopImg(Shop shop, File thumbnail) {
		String dest = PathUtil.getShopImagePath(shop.getShopId());
		String shopImgAddr = ImageUtil.generateThumbnail(thumbnail, dest);
		shop.setShopImg(shopImgAddr);
	}
}
