package com.thosepeople.service.impl;

import java.util.List;

import com.thosepeople.dao.PageDao;
import com.thosepeople.service.PageService;

public class PageServiceImpl implements PageService{

	private PageDao pagedao;

	public void setPagedao(PageDao pagedao) {
		this.pagedao = pagedao;
	}

	@Override
	public List getMoreInfo(String keyword,int pageNum,int pageSize,String tableName) {
		
		return pagedao.getMoreInfo(keyword,pageNum,pageSize,tableName);
	}
	
	
}
