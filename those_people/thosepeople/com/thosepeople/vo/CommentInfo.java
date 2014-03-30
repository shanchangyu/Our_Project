/**
 * 
 */
package com.thosepeople.vo;

/**
 * @author chenzhuo
 * 
 */
public class CommentInfo {
	private String commentUserHeadPic;
	private int commentUserId;
	private String commentConten;
	private int fromCommentUserTo;
	private String commentTime;

	public String getCommentUserHeadPic() {
		return commentUserHeadPic;
	}

	public void setCommentUserHeadPic(String commentUserHeadPic) {
		this.commentUserHeadPic = commentUserHeadPic;
	}

	public int getCommentUserId() {
		return commentUserId;
	}

	public void setCommentUserId(int commentUserId) {
		this.commentUserId = commentUserId;
	}

	public String getCommentConten() {
		return commentConten;
	}

	public void setCommentConten(String commentConten) {
		this.commentConten = commentConten;
	}

	public int getFromCommentUserTo() {
		return fromCommentUserTo;
	}

	public void setFromCommentUserTo(int fromCommentUserTo) {
		this.fromCommentUserTo = fromCommentUserTo;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

}
