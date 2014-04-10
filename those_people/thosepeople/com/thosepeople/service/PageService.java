package com.thosepeople.service;

import java.util.List;


/**
 * 
 * @author xuyingjie
 *
 */

public interface PageService {
	
	@SuppressWarnings("rawtypes")
	List getMoreInfo(String keyword,int pageNum,String tableName);
}
