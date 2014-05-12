/**
 * 
 */
package com.thosepeople.service;

import com.thosepeople.model.LoveInfo;

/**
 * @author chenzhuo
 *
 */
public interface PostLoveInfoService {
   LoveInfo postLoveInfo(int uid,String userSchool,String title,String selfDescribe,String expectOther,String contactWay);
}
