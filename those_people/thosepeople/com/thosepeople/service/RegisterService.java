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
  boolean registerUser(String userName,String nickName,String email,String passWord) throws BusinessException;
  boolean verifyTheEmail(String email);
}
