package com.thosepeople.dao;

import java.util.List;
@SuppressWarnings("rawtypes")
public interface PageDao {

	List getMoreInfo(String keyword, int pageNum,int pageSize,String tableName);
}
