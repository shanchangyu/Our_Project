package com.thosepeople.service;

import com.thosepeople.constant.InfoType;


/**
 * 
 * @author xuyingjie
 *
 */
public interface VisitCountService {
	
	boolean addVisitCount(int id,InfoType it);
	int getVisitCount(int id, InfoType it);

}
