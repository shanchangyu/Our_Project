/**
 * 
 */
package com.thosepeople.service.impl;

import org.springframework.util.StringUtils;

import com.thosepeople.dao.IUserDao;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.service.RegisterService;

/**
 * @author dft
 * 
 */
public class RegisterServiceImpl implements RegisterService {

	private IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean registerUser(String realName, String nickName, String email,
			String passWord) throws BusinessException {
		if (StringUtils.isEmpty(realName) || StringUtils.isEmpty(nickName)
				|| StringUtils.isEmpty(email) || StringUtils.isEmpty(passWord)) {
			throw new BusinessException("The param is illegal!");
		}

		return false;
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
}
