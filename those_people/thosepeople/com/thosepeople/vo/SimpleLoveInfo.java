/**
 * 
 */
package com.thosepeople.vo;

import java.util.List;

/**
 * @author zhuo
 * 
 */
public class SimpleLoveInfo {
	String title;
	String postTime;
	List<String> picturePathList;
	String postUser;
	String postUserHeadPicture;
	String postUserId;
	int visitCount;
	int likeCount;
	int commentCount;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPostTime() {
		return postTime;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

	public List<String> getPicturePathList() {
		return picturePathList;
	}

	public void setPicturePathList(List<String> picturePathList) {
		this.picturePathList = picturePathList;
	}

	public String getPostUser() {
		return postUser;
	}

	public void setPostUser(String postUser) {
		this.postUser = postUser;
	}

	public String getPostUserHeadPicture() {
		return postUserHeadPicture;
	}

	public void setPostUserHeadPicture(String postUserHeadPicture) {
		this.postUserHeadPicture = postUserHeadPicture;
	}

	public String getPostUserId() {
		return postUserId;
	}

	public void setPostUserId(String postUserId) {
		this.postUserId = postUserId;
	}

	public int getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(int visitCount) {
		this.visitCount = visitCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
}
