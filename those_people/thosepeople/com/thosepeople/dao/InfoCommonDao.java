/**
 * 
 */
package com.thosepeople.dao;

import java.util.List;

import com.thosepeople.model.InfoStatistics;

/**
 * @author zhuo
 * 所有信息公用的dao,不同信息相同操作放到此Dao
 */
public interface InfoCommonDao {
	List<InfoStatistics> getInfoStatisticByIdList(List<Integer> idList);
}
