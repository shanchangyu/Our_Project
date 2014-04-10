package com.thosepeople.service;

import com.thosepeople.vo.HouseInfo;
/**
 * @author shanchangyu
 * 
 */
public interface HouseService {
	public int insertHouse(HouseInfo houseinfo);
	public HouseInfo getDetailHouseInfo(int id);

}
