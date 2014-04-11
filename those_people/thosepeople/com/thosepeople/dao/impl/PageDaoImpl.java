package com.thosepeople.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.thosepeople.constant.InfoType;
import com.thosepeople.dao.PageDao;
import com.thosepeople.vo.InfoProfile;

/**
 * 
 * @author xuyingjie
 *
 */

public class PageDaoImpl extends JdbcDaoSupport implements PageDao{

	private static final BeanPropertyRowMapper<InfoProfile> rowMapper = new BeanPropertyRowMapper<InfoProfile>(InfoProfile.class);
	//TODO:通过sql语句中的select as,将查询结果同一为一个返回值，有利于后面的统一，或者在vo InfoProfile中添加个性化的字段来将返回结果统一
	private static final String LOAD_JOB_INFO = "select j.id, j.title,j.workplace,j.jobtype,j.postdate,u.nickName,u_d.headPicPath from job_info j,user u,user_detail u_d where j.uid=u.id and j.uid=u_d.uid "
			+ "order by j.postdate desc limit ?,?";
	
	private static final String LOAD_LOVE_INFO ="";
	private static final String LOAD_HOUSE_INFO ="";
	
	public List<InfoProfile> getMoreInfo(String keyword, int pageNum, int pageSize,InfoType it) {

		String sql=null;
		switch(it)
		{
		case JOB_INFO:
			sql = LOAD_JOB_INFO;
			break;
		case LOVE_INFO:
			sql = LOAD_LOVE_INFO;
			break;
		case HOUSE_INFO:
			sql = LOAD_HOUSE_INFO;
			break;
		default:
			return null;
		}
		return getMoreJobInfo(keyword,pageNum,pageSize,sql);
	}


	private List<InfoProfile> getMoreJobInfo(String keyword ,int pageNum,int pageSize,String sql)
	{
		List<InfoProfile> list = new ArrayList<InfoProfile>(pageSize);

		if(keyword==null)
		{
			list = this.getJdbcTemplate().query(sql,new Object[]{(pageNum-1)*pageSize,pageSize},rowMapper);
		}
		return list;
	}
	
}
