package com.thosepeople.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.dao.JobDao;
import com.thosepeople.dao.PageDao;
import com.thosepeople.po.JobInfo;
import com.thosepeople.vo.JobDetailInfo;
import com.thosepeople.vo.JobInfoProfile;


/**
 * 
 * @author xuyingjie
 *
 */

public class JobDaoImpl extends JdbcDaoSupport implements JobDao{


	private static final BeanPropertyRowMapper<JobInfoProfile> rowMapper = new BeanPropertyRowMapper<JobInfoProfile>(JobInfoProfile.class);
	private static final BeanPropertyRowMapper<JobDetailInfo> detailRowMapper = new BeanPropertyRowMapper<JobDetailInfo>(JobDetailInfo.class);
	static {
		rowMapper.setPrimitivesDefaultedForNullValue(true);
		detailRowMapper.setPrimitivesDefaultedForNullValue(true);
	}

	private static final String INSERT_JOB_INFO="insert into job(uid,title,workplace,jobtype,postdate,company,content,requires,email,tel) "
			+ "value(?,?,?,?,?,?,?,?,?,?)";


	@Override
	public boolean postJobInfo(final JobInfo job)
	{

		int result=this.getJdbcTemplate().update(INSERT_JOB_INFO, job.toStrArray());

		if(result ==1)
		{
			return true;
		}
		return false;
	}

	private static final String LOAD_JOB_INFO = "select j.id, j.title,j.workplace,j.jobtype,j.postdate,u.nickName,u_d.headPicPath from job j,user u,user_detail u_d where j.uid=u.id and j.uid=u_d.uid "
			+ "order by j.postdate desc limit 0,10";

	
	
	public List<JobInfoProfile> getMoreInfo(String keyword, int pageNum,int pageSize) {
		
		List<JobInfoProfile> list = new ArrayList<JobInfoProfile>(10);

		if(keyword==null)
		{
			list = this.getJdbcTemplate().query(LOAD_JOB_INFO,rowMapper);
		}
		return list;
	}

	
	private static final String LOAD_JOB_DETAIL_INFO ="select j.*,u.nickName,u_d.headPicPath from job j,user u,user_detail u_d where j.id=? and j.uid=u.id and j.uid=u_d.uid";

	@Override
	public JobDetailInfo loadJobDetailInfo(int jid) {
		
		List<JobDetailInfo> result =this.getJdbcTemplate().query(LOAD_JOB_DETAIL_INFO,new Object[]{jid},detailRowMapper);
		{
			if(!CollectionUtils.isEmpty(result))
			{
				return result.get(0);
			}
		}
		return null;
	
	}
}
