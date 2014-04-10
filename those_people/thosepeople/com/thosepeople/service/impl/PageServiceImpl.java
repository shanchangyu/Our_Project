package com.thosepeople.service.impl;

import java.util.List;

import com.thosepeople.dao.PageDao;
import com.thosepeople.service.PageService;


public class PageServiceImpl implements PageService{

	private PageDao pagedao;
	private int pageSize = 1;
	
	public void setPagedao(PageDao pagedao) {
		this.pagedao = pagedao;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getMoreInfo(String keyword,int pageNum,String tableName) {
		
		return pagedao.getMoreInfo(keyword,pageNum,pageSize,tableName);
	}
	
	
}
