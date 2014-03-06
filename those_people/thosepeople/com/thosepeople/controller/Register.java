/**
 * 
 */
package com.thosepeople.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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

import com.thosepeople.exception.BusinessException;
import com.thosepeople.exception.SystemException;
import com.thosepeople.service.RegisterService;
import com.thosepeople.util.PictureUtil;
import com.thosepeople.vo.UserInfo;

/**
 * @author chenzhuo
 * 
 */
@Controller
@RequestMapping("/register")
@SessionAttributes({ "uid", "realName", "nickName", "headPicPath" })
public class Register {
	@Autowired
	@Qualifier("registerService")
	private RegisterService registerService;

	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}

	private static final String TEMP_PATH = "upload\\temp";
	private static final String SAVE_PATH = "upload\\headpic";
	private static final String RESPONSE_PATH = "upload/headpic";

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
		return new ModelAndView("complete_detail_info");
	}

	@RequestMapping(value = "verifyEmail", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Boolean> verifyTheEamil(
			@RequestParam("email") String email) {
		Map<String, Boolean> result = new HashMap<>(1);
		Boolean flag = registerService.verifyTheEmail(email);
		result.put("result", flag);
		return result;
	}

	@RequestMapping(value = "/handle_head_pic", method = RequestMethod.POST)
	public void handleTheUploadPic(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("uid") int uid,
			ModelMap model) {

		String serverPath = request.getSession().getServletContext()
				.getRealPath("/");
		if (!new File(serverPath + TEMP_PATH).isDirectory()) {
			new File(serverPath + TEMP_PATH).mkdirs();
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(50 * 1024);// 50k阀值，超过后以临时文件形式存储到硬盘
		factory.setRepository(new File(serverPath + TEMP_PATH));
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		fileUpload.setFileSizeMax(2 * 1024 * 1024);// 最大上传现实1M
		try {
			List<FileItem> fileItem = fileUpload.parseRequest(request);
			Iterator<FileItem> it = fileItem.iterator();
			if (!it.hasNext()) {
				return;
			}
			int x = 0, y = 0, width = 0, height = 0;
			String suffix = null;
			String tempSavePath = null;
			while (it.hasNext()) {
				FileItem item = it.next();
				if (item.isFormField()) {
					switch (item.getFieldName()) {
					case "x":
						x = Integer.parseInt(item.getString());
					case "y":
						y = Integer.parseInt(item.getString());
					case "width":
						width = Integer.parseInt(item.getString());
					case "heigth":
						height = Integer.parseInt(item.getString());
					}
				} else {
					suffix = PictureUtil.getSuffix(item.getName());
					tempSavePath = PictureUtil.saveTmpImg(item, suffix, "001",
							serverPath);
				}
			}
			String fileName = System.currentTimeMillis() + "_" + uid + "."
					+ suffix;
			String targetPath = serverPath + File.separator + SAVE_PATH
					+ File.separator;
			PictureUtil.cutImage(tempSavePath, targetPath + fileName, suffix,
					x, y, width, height);
			String savePath="../" + RESPONSE_PATH + "/" + fileName;
			model.put("headPicPath",savePath);
			new File(tempSavePath.toString()).delete();
			PrintWriter out = response.getWriter();
			out.print("<script>parent.callbackupload('" + savePath+ "')</script>");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("completeDetailInfo")
	public ModelAndView completeDetailUserInfo(
			@ModelAttribute("uid") int uid,
			@ModelAttribute("realName") String realName,
			@ModelAttribute("nickName") String nickName,
			@ModelAttribute("headPicPath") String headPicPath,
			@RequestParam("gender") boolean gender,
			@RequestParam("city") String city,
			@RequestParam("school") String school,
			@RequestParam("major") String major,
			@RequestParam("enrollmentDate") String enrollmentDate,
			@RequestParam("company") String company,
			@RequestParam(value = "signature", required = false) String signature,
			@RequestParam("showType") boolean showType,
			SessionStatus sessionStatus, HttpSession session) {
		boolean result = registerService.completeUserInfoDetail(uid, gender,
				city, school, major, enrollmentDate, signature, showType,
				company,headPicPath);
		UserInfo userInfo = new UserInfo();
		if (result) {
			userInfo.setUid(uid);
			userInfo.setCity(city);
			userInfo.setEnrollmentDate(enrollmentDate);
			userInfo.setGender(gender);
			userInfo.setMajor(major);
			userInfo.setNickName(nickName);
			userInfo.setRealName(realName);
			userInfo.setSchool(school);
			userInfo.setSignature(signature);
			userInfo.setShowType(showType);
			userInfo.setHeadPicPath(headPicPath);
			// put the user account info to the HttpSession
			session.setAttribute("userInfo", userInfo);
			// after complete the detail info clean the scope session
			sessionStatus.setComplete();
		}
		return new ModelAndView("home").addObject("userInfo", userInfo);
	}

}
