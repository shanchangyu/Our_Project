package com.thosepeople.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thosepeople.exception.BusinessException;
import com.thosepeople.service.PageService;
import com.thosepeople.vo.InfoProfile;

public class Page {

	@Autowired
	@Qualifier("pageService")
	private PageService pageService;
	
	@RequestMapping("/moreInfo")
	@ResponseBody
	public Map<String, Object> loadMoreJobInfo (
			@RequestParam(value="currentPage",required=false) String keyword,
			@RequestParam(value="currentPage",required=false) Integer currentPage,
			@RequestParam("infoType") int infoType) throws BusinessException
	{
		if (infoType < 0 || infoType > 4) {
			throw new BusinessException("The infoType is wrong!");
		}
		int pageNum;
		if(currentPage==null){
			pageNum=1;
		}
		else
		{
			pageNum = currentPage+1;
		}

		
		List<InfoProfile> list=pageService.getMoreInfo(keyword, pageNum,infoType);

		if(list==null ||list.size()==0)
		{
			Map<String, Object> modelMap = new HashMap<String, Object>(1);  
			modelMap.put("success", "false");  	
			return modelMap;
			
		}
		else
		{
			Map<String, Object> modelMap = new HashMap<String, Object>(3);  
			modelMap.put("currentPage", pageNum);
			modelMap.put("data", list);  
			modelMap.put("success", "true");  		 
			return modelMap; 
		}
	}
}
