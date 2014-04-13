package com.thosepeople.dao;

import com.thosepeople.vo.HouseInfo;


/**
 * @author shanchangyu
 * 
 */
public interface HouseDao {
	public int postHouseInfo(String title, String infoType, String houseType,String infoDescribe,
			String contactWay, int uid, String postTime);
		public HouseInfo getDetailHouseInfo(int infoId);

}
