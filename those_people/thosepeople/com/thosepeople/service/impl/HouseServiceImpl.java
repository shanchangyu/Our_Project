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
	public int postHouseInfo(String title, String infoType, String houseType,String infoDescribe,
			String contactWay, int uid, String postTime) {
		
		int generateId=houseDao.postHouseInfo( title,infoType, houseType,infoDescribe,contactWay, uid, postTime);
		if(generateId>0){
			return generateId;
		}
		return 0;
	}

	@Override
	public HouseInfo getDetailHouseInfo(int id) {
		// TODO Auto-generated method stub
		return houseDao.getDetailHouseInfo(id);
	}



}
