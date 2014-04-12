package com.thosepeople.dao;

/**
 * 
 * @author xuyingjie
 *
 */


public interface VisitCountDao {
	boolean addVisitCount(int id,String tableName);
	int getVisitCount(int id,String tableName);
}
