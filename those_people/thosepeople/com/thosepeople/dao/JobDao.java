package com.thosepeople.dao;

import com.thosepeople.po.JobInfo;
import com.thosepeople.vo.JobDetailInfo;



/**
 * 
 * @author xuyingjie
 *
 */

public interface JobDao {

	boolean postJobInfo(final JobInfo job);
	JobDetailInfo loadJobDetailInfo(int jid);
}
