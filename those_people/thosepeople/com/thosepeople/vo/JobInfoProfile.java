package com.thosepeople.vo;

public class JobInfoProfile {

	
	private int id;
	private String nickName;
	private String headPicPath;
	private String title;
	private String workPlace;
	private String jobtype;
	private String postDate;  //发布日期
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadPicPath() {
		return headPicPath;
	}
	public void setHeadPicPath(String headPicPath) {
		this.headPicPath = headPicPath;
	}
	public String getJobtype() {
		switch(jobtype)
		{
		case "1":
			return "实习生";
		case "2":
			return "校园招聘";
		case "3":
			return "社会招聘";
		default:
			return "";

		}
	}
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	
}
