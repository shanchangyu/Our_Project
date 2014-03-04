/**
 * 
 */
package com.thosepeople.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chenzhuo
 * 
 */
@Controller
@RequestMapping("/upload_head_pic")
public class HeadPictureHandle {
	public void handleTheUploadPic(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("x") int x,
			@RequestParam("y") int y, @RequestParam("heigth") int heigth,
			@RequestParam("width") int width) {
          
	}
}
