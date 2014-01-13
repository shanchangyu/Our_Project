/**
 * 
 */
package com.thosepeople.service.impl;

import com.thosepeople.dao.TestDao;
import com.thosepeople.service.TestService;

/**
 * @author dft
 *
 */
public class TestServiceImpl implements TestService{
	
	private TestDao dao;

	public TestDao getDao() {
		return dao;
	}

	public void setDao(TestDao dao) {
		this.dao = dao;
	}
	
	

}
