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
	public boolean completeUserInfoDetail(int uid, int gender,
			String city, String school, String major, String enrollmentDate,
			int educationBackground, String signature) {
		if (uid <= 0) {
			throw new IllegalArgumentException(
					"The uid should be great more than zero!");
		}
		if (educationBackground < 1 || educationBackground > 7) {
			throw new IllegalArgumentException(
					"The educationBackground should be great than zero and less than eight !");
		}
		Boolean sex;
		if (gender == 0) {
			sex = true;// men
		} else if (gender == 1) {
			sex = false;// women
		} else {
			throw new IllegalArgumentException(
					"the gender should be zero or one !");
		}
		Date enrollmentTime = DateUtils.getDateOfYMDFormat(enrollmentDate);
		if (enrollmentTime == null) {
			throw new SystemException("parse string to date fial !");
		}
		int result = userDao.completeUserInfoDetail(uid, sex, city,
				school, major, enrollmentTime, educationBackground, signature);
		if (result == 1) {
			return true;
		} else {
			throw new SystemException("Insert into the DB fail!");
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(userDao, "userDao should not null!");
	}
}
