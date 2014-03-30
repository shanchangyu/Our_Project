/**
 * 
 */
package com.thosepeople.service;

import com.thosepeople.exception.BusinessException;

/**
 * @author chenzhuo
 * 
 */
public interface PostCommentService {
	boolean postComment(int infoId, int commentUserId, int fromCommentUserTo,
			String commentContent,int infoType) throws BusinessException;
	String getTheNickNameWhoBeReplied(int uid);
}
