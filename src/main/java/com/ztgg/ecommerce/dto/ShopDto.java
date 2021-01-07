package com.ztgg.ecommerce.dto;

import java.util.List;

import com.ztgg.ecommerce.entity.Shop;
import com.ztgg.ecommerce.enums.ShopStateEnum;

public class ShopDto {
	
	private int state;
	private String stateInfo;
	private int count;
	private Shop shop;
	private List<Shop> shopList;
	
	public ShopDto() {
	}

	// shop CRUD failed case
	public ShopDto(ShopStateEnum stateEnum) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
	}

	// shop CRUD success case
	public ShopDto(ShopStateEnum stateEnum, Shop shop) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shop = shop;
	}

	// shop CRUD success case
	public ShopDto(ShopStateEnum stateEnum, List<Shop> shopList) {
		this.state = stateEnum.getState();
		this.stateInfo = stateEnum.getStateInfo();
		this.shopList = shopList;
	}
	

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public List<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}
}