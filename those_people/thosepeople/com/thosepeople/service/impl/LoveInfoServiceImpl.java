/**
 * 
 */
package com.thosepeople.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.thosepeople.dao.LoveDao;
import com.thosepeople.model.LoveInfo;
import com.thosepeople.service.LoveInfoService;
import com.thosepeople.vo.LoveInfoOutline;
import com.thosepeople.vo.SimpleLoveInfo;

/**
 * @author chenzhuo
 *
 */
public class LoveInfoServiceImpl implements InitializingBean, LoveInfoService{
    LoveDao loveDao;
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
	}

	@Override
	public List<SimpleLoveInfo> listLoveInfoBySchool(String userSchool) {
		if(StringUtils.isEmpty(userSchool))
		return Collections.emptyList();
	     List<LoveInfoOutline> outlineResult=loveDao.listLoveInfoBySchool(userSchool);
	     List<Integer> postUserIdList=new ArrayList<>(5);
	     for(LoveInfoOutline infoOutline:outlineResult){
	      int postUserId=infoOutline.getPostUserId();
	      postUserIdList.add(postUserId);
	     }
	     return null;
	}

}
