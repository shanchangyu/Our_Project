package com.thosepeople.po;

public class JobInfo {

	private int id;
	private int uid;
	private String title;
	private String workplace;
	private String jobtype;
	private String postdate;
	
	private String company;
	private String content;
	private String require;
	private String email;
	private String tel;
	
	


	public JobInfo(int uid, String title, String workplace, String jobtype,
			String postdate, String company, String content, String require,
			String email, String tel) {
		super();
		this.uid = uid;
		this.title = title;
		this.workplace = workplace;
		this.jobtype = jobtype;
		this.postdate = postdate;
		this.company = company;
		this.content = content;
		this.require = require;
		this.email = email;
		this.tel = tel;
	}

	public int getId() {
		return id;
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
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public String getJobtype() {
		return jobtype;
	}
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
	public String getPostdate() {
		return postdate;
	}
	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	
	public Object[] toStrArray()
	{
		return new Object[]{uid,title,workplace,jobtype,postdate,company,content,require,email,tel};
	}
}
