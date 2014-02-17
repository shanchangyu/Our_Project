/**
 * 
 */
package com.thosepeople.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chenzhuo
 * 
 */
@Controller
@RequestMapping("/register")
public class Register {
	public ModelAndView register(@RequestParam("userName") String userName,
			@RequestParam("nickName") String nickName,
			@RequestParam("passWord") String passWord,
			@RequestParam("email") String email) {
		
		return null;
	}

}
