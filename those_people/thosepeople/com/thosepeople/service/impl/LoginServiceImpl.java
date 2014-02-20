/**
 * 
 */
package com.thosepeople.service.impl;

import org.springframework.util.StringUtils;

import com.thosepeople.dao.UserDao;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.service.LoginService;
import com.thosepeople.util.EncryptUtil;

/**
 * @author chenzhuo
 * 
 */
public class LoginServiceImpl implements LoginService {
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean verrifyTheUserPassWord(String email, String passWord)
			throws BusinessException {
		if (StringUtils.isEmpty(email) || StringUtils.isEmpty(passWord)) {
			throw new BusinessException("The param is illegal!");
		}
		String encrptPassWord = EncryptUtil.generatePassWord(email, passWord);
		String savedPassWord = userDao.getPassWordByEmail(email);
		if (StringUtils.isEmpty(encrptPassWord)) {
			throw new BusinessException("Get password wrong!");
		}
		if (encrptPassWord.equals(savedPassWord)) {
			return true;
		}
		return false;
	}

}
