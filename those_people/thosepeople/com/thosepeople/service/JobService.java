package com.thosepeople.service;


import com.thosepeople.po.JobInfo;
import com.thosepeople.vo.JobDetailInfo;

public interface JobService {

	boolean postJobInfo(JobInfo job);
	JobDetailInfo loadJobDetail(int jid);
}
