package com.ztgg.ecommerce.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ztgg.ecommerce.BaseTest;
import com.ztgg.ecommerce.entity.Area;

public class AreaServiceTest extends BaseTest{
	@Autowired
	private AreaService areaService;
	
	@Test
	public void testGetAreaList() {
		List<Area> list = areaService.getAreaList();
		assertEquals(list.size(), 6);
		assertEquals(list.get(0).getAreaName(), "newyork");
		// more test
	}
}