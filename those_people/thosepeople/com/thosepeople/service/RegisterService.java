/**
 * 
 */
package com.thosepeople.service;
import com.thosepeople.exception.BusinessException;

/**
 * @author chenzhuo
 *
 */
public interface RegisterService {
  int getUidAfterRegisterUser(String realName,String nickName,String email,String passWord) throws BusinessException;
  boolean verifyTheEmail (String email);
  boolean completeUserInfoDetail(int uid,String birthday, int gender, String city,
			String school, String major, String enrollmentDate,
			int educationBackground, String signature);
}
