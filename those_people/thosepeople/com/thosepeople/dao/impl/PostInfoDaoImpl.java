/**
 * 
 */
package com.thosepeople.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.CollectionUtils;

import com.mysql.jdbc.Statement;
import com.thosepeople.dao.PostInfoDao;
import com.thosepeople.model.LoveInfo;

/**
 * @author chenzhuo
 * 
 */
public class PostInfoDaoImpl extends JdbcDaoSupport implements PostInfoDao {
	private static final BeanPropertyRowMapper<LoveInfo> rowMapper = new BeanPropertyRowMapper<>(
			LoveInfo.class);
	static {
		rowMapper.setPrimitivesDefaultedForNullValue(true);
	}

	@Override
	public int postLove(int uid, String title, String selfDescribe,
			String expectOther, String contactWay) {
		final String post_sql = " insert into love_info(uid,title,selfDescribe,"
				+ "expectOther,contactWay) value( "
				+ uid
				+ ","
				+ title
				+ ","
				+ selfDescribe + "," + expectOther + "," +"'"+ contactWay + "' );";
		System.out.println(post_sql);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.getJdbcTemplate().update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(post_sql, Statement.RETURN_GENERATED_KEYS);
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}

	private static final String I_LIKE_THIS_POST = " insert ignore into post_i_like(uid,infoId) value(?,?) ";
	private static final String UPDATE_INFO_LIKE_NUM = " update love_info_detail set like_num=like_num+1 ";

	/**
	 * if the uid has liked this info return 0,else update the info's like num
	 * and return 1
	 */
	@Override
	public int likeInfo(int infoId, int uid) {
		int effectNum = this.getJdbcTemplate().update(I_LIKE_THIS_POST,
				new Object[] { uid, infoId });
		if (effectNum == 0) {
			return 0;
		} else {
			this.getJdbcTemplate().update(UPDATE_INFO_LIKE_NUM);
			return 1;
		}
	}

	private static final String GET_INFO_BY_INFOID = " select * from love_info where id=? ";

	@Override
	public LoveInfo getLoveInfoById(int infoId) {
		List<LoveInfo> result = this.getJdbcTemplate().query(
				GET_INFO_BY_INFOID, new Object[] { infoId }, rowMapper);
		if(!CollectionUtils.isEmpty(result)){
			return result.get(0);
		}
		return null;
	}

}
