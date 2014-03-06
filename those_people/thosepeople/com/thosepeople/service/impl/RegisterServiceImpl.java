/**
 * 
 */
package com.thosepeople.service.impl;

import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.thosepeople.dao.UserDao;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.exception.SystemException;
import com.thosepeople.service.RegisterService;
import com.thosepeople.util.DateUtils;
import com.thosepeople.util.EncryptUtil;

/**
 * @author dft
 * 
 */
public class RegisterServiceImpl implements InitializingBean, RegisterService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int getUidAfterRegisterUser(String realName, String nickName,
			String email, String passWord) throws BusinessException {
		String encryptPassWord = EncryptUtil.generatePassWord(email, passWord);
		return userDao.registUser(realName, nickName, email, encryptPassWord);
	}

	@Override
	public boolean verifyTheEmail(String email) {
		int ifValid = userDao.ifEmailHasBeenRegistered(email);
		if (ifValid == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean completeUserInfoDetail(int uid, boolean gender,
			String city, String school, String major, String enrollmentDate, 
			String signature,boolean showType,String company,String headPicPath) {
		if (uid <= 0) {
			throw new IllegalArgumentException(
					"The uid should be great more than zero!");
		}
		Date enrollmentTime = DateUtils.getDateOfYMDFormat(enrollmentDate);
		if (enrollmentTime == null) {
			throw new SystemException("parse string to date fial !");
		}
		int result = userDao.completeUserInfoDetail(uid, gender, city,
				school, major, enrollmentTime,signature,showType,company,headPicPath);
		if (result == 1) {
			return true;
		} else {
			throw new SystemException("Insert into the DB fail!");
		}
	}

	
	@Override
	public void saveheadPicPath(int uid, String path) {
		
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(userDao, "userDao should not null!");
	}
}
