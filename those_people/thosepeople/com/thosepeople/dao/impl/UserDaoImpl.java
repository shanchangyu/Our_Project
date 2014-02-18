/**
 * 
 */
package com.thosepeople.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.thosepeople.dao.IUserDao;

/**
 * @author chenzhuo
 *
 */
public class UserDaoImpl extends JdbcDaoSupport implements IUserDao{

	@Override
	public boolean registUser(String realName, String nickName, String email,
			String passWord) {
		return false;
	}

	private static final String VERIFY_EMAIL="select count(0) from user where email=? ";
	@Override
	public int ifEmailHasBeenRegistered(String email) {
		return 0;
	}

}
