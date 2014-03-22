/**
 * 
 */
package com.thosepeople.service;

import com.thosepeople.model.LoveInfo;

/**
 * @author chenzhuo
 *
 */
public interface PostLoveService {
   LoveInfo postLoveInfo(int uid,String title,String selfDescribe,String expectOther,String contactWay);
}
