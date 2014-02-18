/**
 * 
 */
package com.thosepeople.dao;

/**
 * @author chenzhuo
 *
 */
public interface IUserDao{
   boolean registUser(String realName,String nickName,String email,String passWord);
   int ifEmailHasBeenRegistered(String email);
}
