package com.thosepeople.service.impl;

import java.util.List;

import com.thosepeople.constant.InfoType;
import com.thosepeople.dao.PageDao;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.service.PageService;
import com.thosepeople.vo.InfoProfile;


public class PageServiceImpl implements PageService{

	private PageDao pagedao;

	public void setPagedao(PageDao pagedao) {
		this.pagedao = pagedao;
	}

	@Override
	public List<InfoProfile> getMoreInfo(String keyword,int pageNum,int infoType) throws BusinessException {
		InfoType it = InfoType.getInfoTypeByValue(infoType);
		return pagedao.getMoreInfo(keyword,pageNum,it);
	}
	
	@Override
	public int getInfoCount(String keyword, int infoType)
			throws BusinessException {
		InfoType it = InfoType.getInfoTypeByValue(infoType);
		return pagedao.getPageCount(keyword, it);
	}
	
}
