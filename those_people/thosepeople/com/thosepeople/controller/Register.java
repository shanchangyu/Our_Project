/**
 * 
 */
package com.thosepeople.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.thosepeople.constant.EducationBackground;
import com.thosepeople.exception.BusinessException;
import com.thosepeople.exception.SystemException;
import com.thosepeople.service.RegisterService;
import com.thosepeople.vo.UserInfo;

/**
 * @author chenzhuo
 * 
 */
@Controller
@RequestMapping("/register")
@SessionAttributes({ "uid,realName,nickName" })
public class Register {
	@Autowired
	@Qualifier("registerService")
	private RegisterService registerService;

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	@RequestMapping(value = "registUser", method = RequestMethod.POST)
	public ModelAndView register(@RequestParam("realName") String realName,
			@RequestParam("nickName") String nickName,
			@RequestParam("passWord") String passWord,
			@RequestParam("email") String email, ModelMap model)
			throws BusinessException {
		int result = registerService.getUidAfterRegisterUser(realName,
				nickName, email, passWord);
		if (result <= 0) {
			throw new SystemException("register user fail !");
		}
		model.put("uid", result);
		model.put("realName", realName);
		model.put("nickName", nickName);
		return new ModelAndView("register_success");
	}

	@RequestMapping(value="verifyEmail",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Boolean> verifyTheEamil(
			@RequestParam("email") String email) throws BusinessException {
		Map<String, Boolean> result = new HashMap<>(1);
		Boolean flag = registerService.verifyTheEmail(email);
		result.put("result", flag);
		return result;
	}

	
	@RequestMapping("completeDetailInfo")
	public ModelAndView completeDetailUserInfo(
			@ModelAttribute("uid") int uid,
			@ModelAttribute("realName") String realName,
			@ModelAttribute("nickName") String nickName,
			@RequestParam(value = "birthday", required = false) String birthday,
			@RequestParam("gender") int gender,
			@RequestParam("city") String city,
			@RequestParam("school") String school,
			@RequestParam("major") String major,
			@RequestParam("enrollmentDate") String enrollmentDate,
			@RequestParam("educationBackground") int educationBackground,
			@RequestParam(value = "signature", required = false) String signature,
			SessionStatus sessionStatus, HttpSession session)
			throws BusinessException {
		boolean result = registerService.completeUserInfoDetail(uid, birthday,
				gender, city, school, major, enrollmentDate,
				educationBackground, signature);
		UserInfo userInfo = new UserInfo();
		if (result) {
			userInfo.setBirthday(birthday);
			userInfo.setCity(city);
			userInfo.setEducationBackGround(EducationBackground
					.getDegreeByLevel(educationBackground));
			userInfo.setEnrollmentDate(enrollmentDate);
			userInfo.setGender(gender);
			userInfo.setMajor(major);
			userInfo.setNickName(nickName);
			userInfo.setRealName(realName);
			userInfo.setSchool(school);
			userInfo.setSignature(signature);
			// put the user account info to the HttpSession
			session.setAttribute("userInfo", userInfo);
			// after complete the detail info clean the scope session
			sessionStatus.setComplete();
		}
		return new ModelAndView("home").addObject("userInfo", userInfo);
	}

}
