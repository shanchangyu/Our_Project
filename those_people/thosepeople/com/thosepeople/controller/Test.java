/**
 * 
 */
package com.thosepeople.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thosepeople.service.TestService;

/**
 * @author dft
 *
 */
@Controller
@RequestMapping(value="/mytest")
public class Test {
	
	private TestService testService;

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
	
	@RequestMapping(value="/test")
     public void test(){
    	 System.out.println("Hello World!!!!");
     }
}
