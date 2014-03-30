/**
 * 
 */
package com.thosepeople.dao;

/**
 * @author chenzhuo
 * 
 */
public interface PostCommentDao {
	int postComment(int infoId, int commentUserId, int beRepliedUserId,
			String commentContent,String tableName);
}
