/**
 * 
 */
package com.thosepeople.model;

/**
 * @author zhuo statistics the info's visit times,comment times and like times
 */
public class InfoStatistics {
	private int visitNum;
	private int likeNum;
	private int commentNum;

	public int getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(int visitNum) {
		this.visitNum = visitNum;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
}
