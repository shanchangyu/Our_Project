/**
 * 
 */
package com.thosepeople.dao;

import java.util.Date;

/**
 * @author chenzhuo
 * 
 */
public interface UserDao {
	int registUser(String realName, String nickName, String email,
			String passWord);

	int ifEmailHasBeenRegistered(String email);

	String getPassWordByEmail(String email);

	int completeUserInfoDetail(int uid,Boolean gender, String city,
			String school, String major, Date enrollmentDate,
			int educationBackground, String signature);
}
