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
  boolean completeUserInfoDetail(int uid,boolean gender, String city,
			String school, String major, String enrollmentDate,String signature,boolean showType,String company,String headPicPath);
  void saveheadPicPath(int uid,String path);
}
