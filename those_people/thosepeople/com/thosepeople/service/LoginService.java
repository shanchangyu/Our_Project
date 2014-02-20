/**
 * 
 */
package com.thosepeople.service;

import com.thosepeople.exception.BusinessException;

/**
 * @author chenzhuo
 *
 */
public interface LoginService {
    boolean verrifyTheUserPassWord(String email,String passWord) throws BusinessException;
}
