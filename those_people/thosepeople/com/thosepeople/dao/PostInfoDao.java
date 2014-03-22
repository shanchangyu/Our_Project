/**
 * 
 */
package com.thosepeople.dao;

import com.thosepeople.model.LoveInfo;

/**
 * @author chenzhuo
 *
 */
public interface PostInfoDao {
  int postLove(int uid,String title,String selfDescribe,String expectOther,String contactWay);
  int likeInfo(int infoId,int uid);
  LoveInfo getLoveInfoById(int infoId);
}
