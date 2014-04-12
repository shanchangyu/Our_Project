package com.thosepeople.service.impl;

import com.thosepeople.constant.InfoType;
import com.thosepeople.dao.VisitCountDao;
import com.thosepeople.service.VisitCountService;


/**
 * 
 * @author xuyingjie
 *
 */


public class VisitCountServiceImpl implements VisitCountService{

	

	
	private VisitCountDao visitCountdao;
	public void setVisitDao(VisitCountDao visitCountDao) {
		this.visitCountdao = visitCountDao;
	}
	

	
	public VisitCountDao getVisitCountdao() {
		return visitCountdao;
	}

	public void setVisitCountdao(VisitCountDao visitCountdao) {
		this.visitCountdao = visitCountdao;
	}



	private static final String LOVE_INFO_TABLE ="love_info";
	private static final String JOB_INFO_TABLE ="job_info";
	private static final String HOUSE_INFO_TABLE ="house_info";
	private static final String ACTIVITY_INFO_TABLE ="activity_info";
	
	@Override
	public boolean addVisitCount(int id, InfoType it) {
	
		String tableName = null;
		switch (it) {
		case LOVE_INFO:
			tableName = LOVE_INFO_TABLE;
			break;
		case JOB_INFO:
			tableName = JOB_INFO_TABLE;
			break;
		case HOUSE_INFO:
			tableName = HOUSE_INFO_TABLE;
			break;
		case ACTIVITY_INFO:
			tableName = ACTIVITY_INFO_TABLE;
			break;
		default:
			break;
		}
		
		if(visitCountdao.addVisitCount(id, tableName))
		{
			return true;
		}
		
		return false;
	}
	
	@Override
	public int getVisitCount(int id, InfoType it) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
