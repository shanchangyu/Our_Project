/**
 * 
 */
package com.thosepeople.service;

import java.util.List;

import com.thosepeople.model.LoveInfo;
import com.thosepeople.vo.SimpleLoveInfo;

/**
 * @author chenzhuo
 *
 */
public interface LoveInfoService {
   LoveInfo postLoveInfo(int uid,String userSchool,String title,String selfDescribe,String expectOther,String contactWay);
   List<SimpleLoveInfo> listLoveInfoBySchool(String userSchool);
}
