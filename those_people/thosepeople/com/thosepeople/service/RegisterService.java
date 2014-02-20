/**
 * 
 */
package com.thosepeople.service;

import java.sql.Timestamp;

import com.thosepeople.exception.BusinessException;

/**
 * @author chenzhuo
 *
 */
public interface RegisterService {
  boolean registerUser(String realName,String nickName,String email,String passWord) throws BusinessException;
  boolean verifyTheEmail (String email) throws BusinessException;
  boolean completeUserInfoDetail(int uid, byte age, Boolean gender, String city,
			String school, String major, Timestamp enrollmentDate,
			int educationBackground, String signature) throws BusinessException;
}
