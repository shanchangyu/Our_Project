/**
 * 
 */
package com.thosepeople.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.dao.PostCommentDao;

/**
 * @author chenzhuo
 * 
 */
public class PostCommentDaoImpl extends JdbcDaoSupport implements
		PostCommentDao {

	private static final String INSERT_SQL = " insert into ";
	private static final String INSERT_DETAIL = " (infoId,commentUserId,"
			+ "beRepliedUserId,content ) value(?,?,?,?) ";

	@Override
	public int postComment(int infoId, int commentUserId,
			int beRepliedUserId, String commentContent,String tableName) {
		
		
		return this.getJdbcTemplate().update(
				INSERT_SQL+tableName+INSERT_DETAIL,
				new Object[] { infoId, commentUserId, beRepliedUserId,
						commentContent });
	}
}
