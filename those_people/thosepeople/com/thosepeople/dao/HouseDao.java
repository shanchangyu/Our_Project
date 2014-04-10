package com.thosepeople.dao;

import com.thosepeople.vo.HouseInfo;


/**
 * @author shanchangyu
 * 
 */
public interface HouseDao {
		public int insertHouse(HouseInfo houseinfo);
		public HouseInfo getDetailHouseInfo(int infoId);

}
