package com.ztgg.ecommerce.dao;

import java.util.List;
import com.ztgg.ecommerce.entity.Area;

public interface AreaDao{ // C Read U D
	/**
	 * this function returns a list of areas
	 * @return areaList
	 */
	List<Area> queryArea();
	
}