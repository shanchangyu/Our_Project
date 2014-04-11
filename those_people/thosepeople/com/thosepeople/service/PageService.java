package com.thosepeople.service;

import java.util.List;

import com.thosepeople.exception.BusinessException;
import com.thosepeople.vo.InfoProfile;


/**
 * 
 * @author xuyingjie
 *
 */

public interface PageService {
	
	List<InfoProfile> getMoreInfo(String keyword,int pageNum,int infoType) throws BusinessException;
	int getInfoCount(String keyword, int infoType)throws BusinessException;
}
