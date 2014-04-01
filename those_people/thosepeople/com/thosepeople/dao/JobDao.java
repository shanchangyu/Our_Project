package com.thosepeople.dao;

import java.util.List;

import com.thosepeople.po.JobInfo;
import com.thosepeople.vo.JobDetailInfo;
import com.thosepeople.vo.JobInfoProfile;



/**
 * 
 * @author xuyingjie
 *
 */

public interface JobDao {

	boolean postJobInfo(final JobInfo job);
	List<JobInfoProfile> loadJobInfo(String key);
	JobDetailInfo loadJobDetailInfo(int jid);
}
