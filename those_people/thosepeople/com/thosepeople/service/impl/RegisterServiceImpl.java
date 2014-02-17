/**
 * 
 */
package com.thosepeople.service.impl;

import org.springframework.util.StringUtils;

import com.thosepeople.service.RegisterService;

/**
 * @author dft
 *
 */
public class RegisterServiceImpl implements RegisterService{

	@Override
	public boolean registerUser(String userName, String nickName, String email,
			String passWord) {
		if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(nickName)||StringUtils.isEmpty(email)
				||StringUtils.isEmpty(passWord)){
			
		}
		return false;
	}
}
