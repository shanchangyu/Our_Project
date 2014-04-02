package com.thosepeople.service.impl;

import org.springframework.beans.factory.InitializingBean;

import com.thosepeople.dao.JobDao;
import com.thosepeople.po.JobInfo;
import com.thosepeople.service.JobService;
import com.thosepeople.vo.JobDetailInfo;


/**
 * @author xuyingjie
 * 
 */

public class JobServiceImpl implements InitializingBean,JobService {

	JobDao jobDao;

	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}

	@Override
	public boolean postJobInfo(JobInfo job) {

		return jobDao.postJobInfo(job);

	}

	

	@Override
	public JobDetailInfo loadJobDetail(int jid) {
		return jobDao.loadJobDetailInfo(jid);
	}


	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}



}
