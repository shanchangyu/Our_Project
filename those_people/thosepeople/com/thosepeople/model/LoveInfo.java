/**
 * 
 */
package com.thosepeople.model;

import java.util.Date;

/**
 * @author chenzhuo
 *
 */
public class LoveInfo {
  private int id;
  private int uid;
  private String title;
  private String selfDescribe;
  private String expectOther;
  private Date postTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSelfDescribe() {
		return selfDescribe;
	}

	public void setSelfDescribe(String selfDescribe) {
		this.selfDescribe = selfDescribe;
	}

	public String getExpectOther() {
		return expectOther;
	}

	public void setExpectOther(String expectOther) {
		this.expectOther = expectOther;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
}
