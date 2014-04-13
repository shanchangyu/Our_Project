package com.thosepeople.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.dao.VisitCountDao;

/**
 * 
 * @author xuyingjie
 *
 */
public class VisitCountDapImpl extends JdbcDaoSupport implements VisitCountDao {
	
	private static final String update_SQL = "update %s set visitCnt = visitCnt+1 where id = ?";
	private static final String select_SQL = "select visitCnt from %s where id = ?";

	@Override
	public boolean addVisitCount(int id, String tableName) {
		
		String sql = String.format(update_SQL ,tableName);
		int result = getJdbcTemplate().update(sql, new Object[]{id});
		
		if (result ==1)
		{
			return true;
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getVisitCount(int id, String tableName) {
		
		String sql = String.format(select_SQL ,tableName);
		int result = getJdbcTemplate().queryForInt(sql, new Object[]{id});

		return result;
	}
	
	
}
