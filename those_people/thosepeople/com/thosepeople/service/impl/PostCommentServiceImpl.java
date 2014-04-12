/**
 * 
 */
package com.thosepeople.service.impl;

import org.apache.commons.lang3.StringUtils;

import com.thosepeople.constant.InfoType;
import com.thosepeople.dao.PostCommentDao;
import com.thosepeople.dao.UserDao;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.service.PostCommentService;

/**
 * @author chenzhuo
 * 
 */
public class PostCommentServiceImpl implements PostCommentService {

	PostCommentDao postCommentDao;
	UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setPostCommentDao(PostCommentDao postCommentDao) {
		this.postCommentDao = postCommentDao;
	}

	private static final String LOVE_COMMENT_TABLE = "love_info_comment";
	private static final String JOB_COMMENT_TABLE = "job_info_comment";
	private static final String HOUSE_COMMENT_TABLE = "house_info_comment";
	private static final String ACTIVITY_COMMENT_TABLE = "activity_info_comment";

	@Override
	public boolean postComment(int infoId, int commentUserId,
			int beRepliedUserId, String commentContent, int infoType) throws BusinessException {
		if (StringUtils.isEmpty(commentContent) || commentUserId <= 0) {
			return false;
		}
		if (infoType < 0 || infoType > 4) {
			throw new BusinessException("The infoType is wrong!");
		}
		String tableName = null;
		InfoType it = InfoType.getInfoTypeByValue(infoType);
		switch (it) {
		case LOVE_INFO:
			tableName = LOVE_COMMENT_TABLE;
			break;
		case JOB_INFO:
			tableName = JOB_COMMENT_TABLE;
			break;
		case HOUSE_INFO:
			tableName = HOUSE_COMMENT_TABLE;
			break;
		case ACTIVITY_INFO:
			tableName = ACTIVITY_COMMENT_TABLE;
			break;
		}
		int result = postCommentDao.postComment(infoId, commentUserId,
				beRepliedUserId, commentContent, tableName);
		if (result == 1) {
			return true;
		}
		return false;
	}

	@Override
	public String getTheNickNameWhoBeReplied(int uid) {
       return userDao.getUserNickNameById(uid);
	}

}
