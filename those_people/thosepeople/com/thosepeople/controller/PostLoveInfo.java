/**
 * 
 */
package com.thosepeople.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thosepeople.model.LoveInfo;
import com.thosepeople.service.LoveInfoService;
import com.thosepeople.vo.UserInfo;

/**
 * @author chenzhuo
 * 
 */
@Controller
@RequestMapping("/post_love_info")
public class PostLoveInfo {

	@Autowired
	@Qualifier("loveInfoService")
	private LoveInfoService loveInfoService;
	
	public void setloveInfoService(LoveInfoService loveInfoService) {
		this.loveInfoService = loveInfoService;
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ModelAndView postLoveInfo(@RequestParam("infoTitle") String title,
			@RequestParam("selfDescribe") String selfDescribe,
			@RequestParam("expectOther") String expectOther,
			@RequestParam("contactWay") String contactWay,
			HttpSession session) {
		UserInfo ui=(UserInfo) session.getAttribute("userInfo");
		LoveInfo loveInfo=loveInfoService.postLoveInfo(ui.getUid(), ui.getSchool(),title, selfDescribe, expectOther, contactWay);
		return new ModelAndView("love_info_detail").addObject("loveInfo",loveInfo);
	}
}
