/**
 * 
 */
package com.thosepeople.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.thosepeople.dao.InfoCommonDao;
import com.thosepeople.dao.LoveDao;
import com.thosepeople.dao.UserDao;
import com.thosepeople.model.InfoStatistics;
import com.thosepeople.model.LoveInfo;
import com.thosepeople.service.LoveInfoService;
import com.thosepeople.vo.LoveInfoOutline;
import com.thosepeople.vo.SimpleLoveInfo;
import com.thosepeople.vo.UserInfoOutline;

/**
 * @author chenzhuo
 *
 */
public class LoveInfoServiceImpl implements InitializingBean, LoveInfoService{
    LoveDao loveDao;
    UserDao userDao;
    InfoCommonDao infoCommonDao;
	public void setInfoCommonDao(InfoCommonDao infoCommonDao) {
		this.infoCommonDao = infoCommonDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setLoveDao(LoveDao loveDao) {
		this.loveDao = loveDao;
	}

	@Override
	public LoveInfo postLoveInfo(int uid,String userSchool,String title, String selfDescribe,
			String expectOther,String contactWay) {
		if(StringUtils.isEmpty(title)||StringUtils.isEmpty(expectOther)||StringUtils.isEmpty(selfDescribe)){
			return null;
		}
		int generateId=loveDao.postLove(uid,userSchool,title,selfDescribe, expectOther, contactWay);
		if(generateId>0){
			return loveDao.getLoveInfoById(generateId);
		}
		return null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(loveDao, "The loveDao should not null !");
		Assert.notNull(userDao,"The userDao should not null !");
		Assert.notNull(infoCommonDao, "The infoCommonDao should not null !");
	}

	@Override
	public List<SimpleLoveInfo> listLoveInfoBySchool(String userSchool) {
		if(StringUtils.isEmpty(userSchool))
		return Collections.emptyList();
	     List<LoveInfoOutline> outlineResult=loveDao.listLoveInfoBySchool(userSchool);
	     List<Integer> postUserIdList=new ArrayList<>(5);
	     List<Integer> infoIdList=new ArrayList<>();
	     for(LoveInfoOutline infoOutline:outlineResult){
	      int postUserId=infoOutline.getUid();
	      int infoId=infoOutline.getId();
	      postUserIdList.add(postUserId);
	      infoIdList.add(infoId);
	     }
	     List<UserInfoOutline> uInfoOutline=userDao.getUserInfoOutline(postUserIdList);
	     List<InfoStatistics> infoStatistics=infoCommonDao.getInfoStatisticByIdList(infoIdList);
	     Map<Integer,UserInfoOutline> uInfoMap=new HashMap<>(5);
	     
	     for(UserInfoOutline uio:uInfoOutline){
	    	    
	     }
	     return null;
	}

}
