package com.thosepeople.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chenzhuo
 * 
 */
@Controller
@RequestMapping("/user")
public class UserSet {

	@RequestMapping("/userInfo")
	public ModelAndView goUserInfo(){
		return new ModelAndView("user_info_page");
	}
	
	@RequestMapping("/forgetPassword")
	public ModelAndView goChangePassword(){
		return new ModelAndView("forget_password");
	}
	
	@RequestMapping("/login")
	public ModelAndView goLogin(){
		return new ModelAndView("login");
	}
}
