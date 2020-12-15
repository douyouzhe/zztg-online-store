package com.ztgg.ecommerce.dao;

import com.ztgg.ecommerce.BaseTest;
import com.ztgg.ecommerce.entity.Area;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AreaDaoTest extends BaseTest{
	@Autowired
	private AreaDao areaDao;
	
	@Test
	public void testQueryArea(){
		List<Area> areaList = areaDao.queryArea();
		assertEquals(3, areaList.size());
	}
}
