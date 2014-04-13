package com.thosepeople.service;

import com.thosepeople.vo.HouseInfo;
/**
 * @author shanchangyu
 * 
 */
public interface HouseService {
	int postHouseInfo(String title, String infoType, String houseType,String infoDescribe,
			String contactWay, int uid, String postTime);
	HouseInfo getDetailHouseInfo(int id);

}
