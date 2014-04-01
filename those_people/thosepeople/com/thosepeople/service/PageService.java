package com.thosepeople.service;

import java.util.List;


/**
 * 
 * @author xuyingjie
 *
 */
public interface PageService {
	
	List getMoreInfo(String keyword,int pageNum,int pageSize,String tableName);
}
