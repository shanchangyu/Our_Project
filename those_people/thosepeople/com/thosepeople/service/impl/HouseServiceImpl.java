package com.thosepeople.service.impl;

import com.thosepeople.dao.HouseDao;
import com.thosepeople.service.HouseService;
import com.thosepeople.vo.HouseInfo;

/**
 * @author shanchangyu
 * 
 */
public class HouseServiceImpl implements  HouseService {
    HouseDao houseDao;
	public HouseDao getHouseDao() {
		return houseDao;
	}

	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}

	@Override
	public int insertHouse(HouseInfo houseinfo) {
		return houseDao.insertHouse(houseinfo);
	}


	@Override
	public HouseInfo getDetailHouseInfo(int id) {
		// TODO Auto-generated method stub
		return houseDao.getDetailHouseInfo(id);
	}



}
