package com.thosepeople.dao.impl;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.dao.HouseDao;
import com.thosepeople.vo.HouseInfo;
/**
 * @author shanchangyu
 * 
 */
public class HouseDaoImpl extends JdbcDaoSupport implements HouseDao {
	private static final BeanPropertyRowMapper<HouseInfo> rowMapper = new BeanPropertyRowMapper<HouseInfo>(
			HouseInfo.class);
	static {
		rowMapper.setPrimitivesDefaultedForNullValue(true);
	}
	private static final String INSERT_HOUSE_INFO = " insert into house_info (title,infoType,houseType,infoDescribe,contactWay,uid,postTime) values(?,?,?,?,?,?,?) ";
	@Override
	public int insertHouse(HouseInfo houseinfo) {

		 int ret = -1;
		    try {	    
		      ret = this.getJdbcTemplate().update(INSERT_HOUSE_INFO,
						new Object[] { houseinfo.getTitle(), houseinfo.getInfoType(), houseinfo.getHouseType(), houseinfo.getInfoDescribe(),houseinfo.getContactWay(),houseinfo.getUid(), houseinfo.getPostTime()});
		    }
		    catch (Exception e) {
		    	ret =0;
		    }
		    return ret;
	}

	private static final String GET_HOUSE_INFO = "select h.*,u.nickName,u_d.headPicPath from house_info h,user u,user_detail u_d where h.id=? and h.uid=u.id and h.uid=u_d.uid ";
	@Override
	public HouseInfo getDetailHouseInfo(int infoId) {
		List<HouseInfo> result = this.getJdbcTemplate().query(
				GET_HOUSE_INFO, new Object[] { infoId }, rowMapper);
		if(!CollectionUtils.isEmpty(result)){
			return result.get(0);
		}
		return null;
	}


}
