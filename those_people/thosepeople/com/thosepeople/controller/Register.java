/**
 * 
 */
package com.thosepeople.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thosepeople.exception.BusinessException;
import com.thosepeople.service.RegisterService;

/**
 * @author chenzhuo
 * 
 */
@Controller
@RequestMapping("/register")
public class Register {
	@Autowired
	@Qualifier("registerService")
	private RegisterService registerService;

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	@RequestMapping("registUser")
	public ModelAndView register(@RequestParam("realName") String realName,
			@RequestParam("nickName") String nickName,
			@RequestParam("passWord") String passWord,
			@RequestParam("email") String email) throws BusinessException {
		registerService.registerUser(realName, nickName, email, passWord);
		return new ModelAndView("register_success");
	}

	@RequestMapping("verifyEmail")
	@ResponseBody
	public Map<String, Boolean> verifyTheEamil(
			@RequestParam("email") String email) throws BusinessException {
		Map<String, Boolean> result = new HashMap<>(1);
		Boolean flag = registerService.verifyTheEmail(email);
		result.put("verrifyResult", flag);
		return result;
	}

	@RequestMapping("completeDetailInfo")
	public ModelAndView completeDetailUserInfo(
			@RequestParam(value = "age", required = false) int age,
			@RequestParam("gender") String gender,
			@RequestParam("city") String city,
			@RequestParam("school") String school,
			@RequestParam("major") String major,
			@RequestParam("enrollmentDate") String enrollmentDate,
			@RequestParam("educationBackground") String educationBackground,
			@RequestParam(value = "signature", required = false) String signature) throws BusinessException {
		
		return null;
	}

}
