/**
 * 
 */
package com.thosepeople.service;

import com.thosepeople.exception.BusinessException;
import com.thosepeople.vo.UserInfo;


/**
 * @author chenzhuo
 *
 */
public interface LoginService {
    boolean verrifyTheUserPassWord(String email,String passWord);
    UserInfo getUserDetail(String email) throws BusinessException;
}
