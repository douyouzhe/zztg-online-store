package com.ztgg.ecommerce.dao;


import java.util.List;
import com.ztgg.ecommerce.entity.Area;

public interface AreaDao {
	/**
	 * return all area list
	 * @return areaList
	 */
	List<Area> queryArea();
}
