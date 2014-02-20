/**
 * 
 */
package com.thosepeople.service.impl;

import java.sql.Timestamp;

import org.springframework.util.StringUtils;

import com.thosepeople.dao.UserDao;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.service.RegisterService;
import com.thosepeople.util.EncryptUtil;

/**
 * @author dft
 * 
 */
public class RegisterServiceImpl implements RegisterService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean registerUser(String realName, String nickName, String email,
			String passWord) throws BusinessException {
		if (StringUtils.isEmpty(realName) || StringUtils.isEmpty(nickName)
				|| StringUtils.isEmpty(email) || StringUtils.isEmpty(passWord)) {
			throw new BusinessException("The param is illegal!");
		}
		String encryptPassWord = EncryptUtil.generatePassWord(email, passWord);
		int result = userDao.registUser(realName, nickName, email,
				encryptPassWord);
		if (result == 1) {
			return true;
		}else{
			throw new BusinessException("Register user fail into the DB!");
		}
	}

	@Override
	public boolean verifyTheEmail(String email) throws BusinessException {
		if (StringUtils.isEmpty(email)) {
			throw new BusinessException("The param is illegal!");
		}
		int ifValid = userDao.ifEmailHasBeenRegistered(email);
		if (ifValid == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean completeUserInfoDetail(int uid, byte age, Boolean gender, String city,
			String school, String major, Timestamp enrollmentDate,
			int educationBackground, String signature) throws BusinessException {
		if (StringUtils.isEmpty(gender) || StringUtils.isEmpty(city)
				|| StringUtils.isEmpty(school) || StringUtils.isEmpty(major)
				|| StringUtils.isEmpty(enrollmentDate)
				|| StringUtils.isEmpty(educationBackground)) {
              throw new BusinessException("");
		}
		return false;
	}
}
