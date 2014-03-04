/**
 * 
 */
package com.thosepeople.controller;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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
	private final static String SAVE_PATH = "upload/headpic/";
	private final static String TMP_PATH = "upload/tmppic/";

	@RequestMapping("/handle_head_pic")
	public void handleTheUploadPic(HttpServletRequest request,
			HttpServletResponse response, @RequestParam("x") int x,
			@RequestParam("y") int y, @RequestParam("height") int height,
			@RequestParam("width") int width) {
		String serverPath = request.getSession().getServletContext()
				.getRealPath("/");
		if (!new File(serverPath + SAVE_PATH).isDirectory()) {
			new File(serverPath + SAVE_PATH).mkdirs();
		}
		if (!new File(serverPath + TMP_PATH).isDirectory()) {
			new File(serverPath + TMP_PATH).mkdirs();
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(50 * 1024);// 50k阀值，超过后以临时文件形式存储到硬盘
		factory.setRepository(new File(serverPath + TMP_PATH));
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		fileUpload.setFileSizeMax(1024 * 1024);// 最大上传现实1M
		try {
			List<FileItem> fileItem = fileUpload.parseRequest(request);
			FileItem headPic = fileItem.get(0);
			FileInputStream fileInputStream;
			ImageInputStream imgInputStream;
			fileInputStream = (FileInputStream) headPic.getInputStream();
			imgInputStream = ImageIO.createImageInputStream(fileInputStream);
			Iterator<ImageReader> it = ImageIO.getImageReaders(imgInputStream);
			if (!it.hasNext()) {
				return;
			}
			ImageReader imgReader = it.next();
			ImageReadParam imgReadParam = imgReader.getDefaultReadParam();
			imgReader.setInput(imgInputStream, true, true);
			Rectangle rect = new Rectangle(x, y, width, height);
			imgReadParam.setSourceRegion(rect);
			BufferedImage imgBuffer;
			try {
				imgBuffer = imgReader.read(0, imgReadParam);
			} finally {
				imgReader.dispose();
				imgInputStream.close();
			}
			ImageIO.write(imgBuffer, " jpg ", new File(SAVE_PATH));
		} catch (FileUploadException | IOException e) {
			e.printStackTrace();
		}

	}
}
