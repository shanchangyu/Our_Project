package com.thosepeople.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.dao.PageDao;
import com.thosepeople.vo.JobInfoProfile;

public class PageDaoImpl extends JdbcDaoSupport implements PageDao{

	private static final BeanPropertyRowMapper<JobInfoProfile> rowMapper = new BeanPropertyRowMapper<JobInfoProfile>(JobInfoProfile.class);

	private static final String LOAD_JOB_INFO="select j.id, j.title,j.workplace,j.jobtype,j.postdate,u.nickName,u_d.headPicPath from job j,user u,user_detail u_d"
			+ " where id ＞="
			+ "( select id from job order by job.postdate desc limit ?,1 "
			+ ")order by job.postdate desc limit 10 ";



	@Override
	public List getMoreInfo(String keyword, int pageNum, int pageSize,String tableName) {


		switch(tableName)
		{
		case "job":
			return getMoreJobInfo(keyword,pageNum,pageSize);
		default:
			return null;

		}
	}


	private List<JobInfoProfile> getMoreJobInfo(String keyword ,int pageNum,int pageSize)
	{
		List<JobInfoProfile> list = new ArrayList<JobInfoProfile>(10);

		if(keyword==null)
		{
			list = this.getJdbcTemplate().query(LOAD_JOB_INFO,new Object[]{pageNum*pageSize+1},rowMapper);
		}
		return list;
	}

}
