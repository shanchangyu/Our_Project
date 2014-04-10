package com.thosepeople.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.dao.PageDao;
import com.thosepeople.vo.HouseInfo;
import com.thosepeople.vo.JobInfoProfile;

@SuppressWarnings("rawtypes")
public class PageDaoImpl extends JdbcDaoSupport implements PageDao{

	private static final BeanPropertyRowMapper<JobInfoProfile> rowMapper = new BeanPropertyRowMapper<JobInfoProfile>(JobInfoProfile.class);
	private static final BeanPropertyRowMapper<HouseInfo> HouseInfoRowMapper = new BeanPropertyRowMapper<HouseInfo>(HouseInfo.class);
	
	
	
	
	private static final String LOAD_JOB_INFO = "select j.id, j.title,j.workplace,j.jobtype,j.postdate,u.nickName,u_d.headPicPath from job_info j,user u,user_detail u_d where j.uid=u.id and j.uid=u_d.uid "
			+ "order by j.postdate desc limit ?,?";
	
	private static final String LOAD_LOVE_INFO ="";
	private static final String LOAD_HOUSE_INFO =" select h.id,h.title,h.infoType,h.houseType,h.postTime,u.nickName,u_d.headPicPath from house_info h, user u,user_detail u_d where h.uid=u.id and h.uid=u_d.uid "
			+ "order by h.postTime desc limit ?,?";
	private static final String LOAD_ACTIVITY_INFO ="";
	

	@Override
	public List getMoreInfo(String keyword, int pageNum, int pageSize,String tableName) {


		switch(tableName)
		{
		case "job":
			return getMoreJobInfo(keyword,pageNum,pageSize);
		case "love":
			return getMoreLoveInfo(keyword,pageNum,pageSize);
		case "house":
			return getMoreHouseInfo(keyword,pageNum,pageSize);
		case "activity":
			return getMoreActivityInfo(keyword,pageNum,pageSize);
		default:
			return null;

		}
	}


	private List<JobInfoProfile> getMoreJobInfo(String keyword ,int pageNum,int pageSize)
	{
		List<JobInfoProfile> list = new ArrayList<JobInfoProfile>(pageSize);

		if(keyword==null)
		{
			list = this.getJdbcTemplate().query(LOAD_JOB_INFO,new Object[]{(pageNum-1)*pageSize,pageSize},rowMapper);
		}
		return list;
	}
	
	

	private List getMoreLoveInfo(String keyword ,int pageNum,int pageSize)
	{

		return null;
	}
	
	private List getMoreHouseInfo(String keyword ,int pageNum,int pageSize)
	{
		List<HouseInfo> list = new ArrayList<HouseInfo>(pageSize);

		if(keyword==null)
		{
			list = this.getJdbcTemplate().query(LOAD_HOUSE_INFO,new Object[]{(pageNum-1)*pageSize,pageSize},HouseInfoRowMapper);
		}
		return list;
	}
	
	private List getMoreActivityInfo(String keyword ,int pageNum,int pageSize)
	{

		return null;
	}

}
