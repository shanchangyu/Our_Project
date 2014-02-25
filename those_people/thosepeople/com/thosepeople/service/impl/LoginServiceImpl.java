/**
 * 
 */
package com.thosepeople.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.thosepeople.dao.UserDao;
import com.thosepeople.service.LoginService;
import com.thosepeople.util.EncryptUtil;

/**
 * @author chenzhuo
 * 
 */
public class LoginServiceImpl implements InitializingBean, LoginService {
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean verrifyTheUserPassWord(String email, String passWord){
		String savedPassWord = userDao.getPassWordByEmail(email);
		if (StringUtils.isEmpty(savedPassWord)) {
			return false;
		}
		String encrptPassWord = EncryptUtil.generatePassWord(email, passWord);
		if (encrptPassWord.equals(savedPassWord)) {
			return true;
		}
		return false;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(userDao, "userDao should not null!");
	}

}
