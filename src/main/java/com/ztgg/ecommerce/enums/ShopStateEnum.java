package com.ztgg.ecommerce.enums;

public enum ShopStateEnum {
	CHECK(0, "verifying info provied"), 
	OFFLINE(-1, "the shop is offline because of violation"), 
	SUCCESS(1, "the shop is created successfully"), 
	PASS(2, "the info provided is verified"), 
	INNER_ERROR(-1001,"internal sys error"),
	NULL_SHOPID(-1002, "ShopId is null"),
	NULL_SHOP(-1003, "shop is null");
	
	private int state;
	private String stateInfo;

	// private constructor
	private ShopStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public static ShopStateEnum stateOf(int state) {
		for (ShopStateEnum stateEnum : values()) {
			if (stateEnum.getState() == state) {
				return stateEnum;
			}
		}
		return null;
	}

	// no setters
	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

}
