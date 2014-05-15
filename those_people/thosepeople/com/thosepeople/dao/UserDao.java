/**
 * 
 */
package com.thosepeople.dao;

import java.util.Date;
import java.util.List;

import com.thosepeople.vo.UserInfo;
import com.thosepeople.vo.UserInfoOutline;

/**
 * @author chenzhuo
 * 
 */
public interface UserDao {
	int registUser(String realName, String nickName, String email,
			String passWord);

	int ifEmailHasBeenRegistered(String email);

	String getPassWordByEmail(String email);

	int completeUserInfoDetail(int uid,boolean gender, String city,
			String school, String major, Date enrollmentDate, String signature,boolean showType,String company,String headPicPath);
	void saveHeadPicPath(int uid,String path);
	UserInfo getDetailUserInfo(String email);
	String getUserNickNameById(int id);
	List<UserInfoOutline> getUserInfoOutline(List<Integer> userIdList);
	}
