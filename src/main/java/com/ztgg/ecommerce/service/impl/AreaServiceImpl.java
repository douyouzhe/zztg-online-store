package com.ztgg.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztgg.ecommerce.dao.AreaDao;
import com.ztgg.ecommerce.entity.Area;
import com.ztgg.ecommerce.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService{
	
	@Autowired
	private AreaDao areaDao;

	@Override
	public List<Area> getAreaList() {
		return areaDao.queryArea();
	}
}