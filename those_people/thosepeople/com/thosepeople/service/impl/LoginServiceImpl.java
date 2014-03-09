/**
 * 
 */
package com.thosepeople.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.thosepeople.dao.UserDao;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.service.LoginService;
import com.thosepeople.util.EncryptUtil;
import com.thosepeople.vo.UserInfo;

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
	public boolean verrifyTheUserPassWord(String email, String passWord) {
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
	public UserInfo getUserDetail(String email) throws BusinessException {
		if (StringUtils.isEmpty(email)) {
			return null;
		}
		UserInfo userInfo = userDao.getDetailUserInfo(email);
		if (userInfo == null) {
			throw new BusinessException(" Get userInfo from db fail!");
		}
		return userInfo;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(userDao, "userDao should not null!");
	}
}
