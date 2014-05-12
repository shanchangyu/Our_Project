/**
 * 
 */
package com.thosepeople.dao;

import java.util.List;

import com.thosepeople.model.LoveInfo;
import com.thosepeople.vo.SimpleLoveInfo;

/**
 * @author chenzhuo
 *
 */
public interface LoveDao {
  int postLove(int uid,String userSchool,String title,String selfDescribe,String expectOther,String contactWay);
  int likeInfo(int infoId,int uid);
  LoveInfo getLoveInfoById(int infoId);
  List<SimpleLoveInfo> listLoveInfoBySchool(String schoolInfo);
}
