/**
 * 
 */
package com.thosepeople.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thosepeople.model.LoveInfo;
import com.thosepeople.service.PostLoveService;
import com.thosepeople.vo.UserInfo;

/**
 * @author chenzhuo
 * 
 */
@RequestMapping("/post_love_info")
public class PostLoveInfo {

	@Autowired
	@Qualifier("")
	private PostLoveService postLoveService;
	
	public void setPostLoveService(PostLoveService postLoveService) {
		this.postLoveService = postLoveService;
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ModelAndView postLoveInfo(@RequestParam("title") String title,
			@RequestParam("selfDescribe") String selfDescribe,
			@RequestParam("expectOther") String expectOther,
			@RequestParam("contactWay") String contactWay,
			HttpSession session) {
		UserInfo ui=(UserInfo) session.getAttribute("userInfo");
		LoveInfo loveInfo=postLoveService.postLoveInfo(ui.getUid(), title, selfDescribe, expectOther, contactWay);
		return new ModelAndView("love_info_detail").addObject("loveInfo",loveInfo);
	}

}
