/**
 * 
 */
package com.thosepeople.dao.impl;

import java.sql.Timestamp;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.dao.UserDao;

/**
 * @author chenzhuo
 * 
 */
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

	private static final String REGISTER_USER = " insert into user(realName,nickName,passWord,email) value(?,?,?,?) ";

	@Override
	public int registUser(String realName, String nickName, String email,
			String passWord) {
		return this.getJdbcTemplate().update(REGISTER_USER,
				new Object[] { realName, nickName, passWord, email });

	}

	private static final String VERIFY_EMAIL = " select count(0) from user where email=? ";

	@Override
	public int ifEmailHasBeenRegistered(String email) {
		return this.getJdbcTemplate().queryForObject(VERIFY_EMAIL,
				new Object[] { email }, Integer.class);
	}

	private static final String GET_PASSWORD_BY_EMAIL = " select passWord from user where email=? limit 1 ";

	@Override
	public String getPassWordByEmail(String email) {
		return this.getJdbcTemplate().queryForObject(GET_PASSWORD_BY_EMAIL,
				new Object[] { email }, String.class);
	}

	private static final String COMPLETE_USER_DETAIL = " insert into user_info(age,gender,city,school,major,"
			+ "enrollmentDate,educationBackground,signature) value(?,?,?,?,?,?,?,?) ";

	@Override
	public int completeUserInfoDetail(int uid, byte age, Boolean gender,
			String city, String school, String major, Timestamp enrollmentDate,
			int educationBackground, String signature) {
		return this.getJdbcTemplate().update(
				COMPLETE_USER_DETAIL,
				new Object[] { uid, age, gender, city, school, major,
						enrollmentDate, educationBackground, signature });
	}
}
