package com.thosepeople.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.thosepeople.exception.SystemException;
import com.thosepeople.po.JobInfo;
import com.thosepeople.service.JobService;
import com.thosepeople.service.PageService;
import com.thosepeople.vo.JobDetailInfo;
import com.thosepeople.vo.JobInfoProfile;
import com.thosepeople.vo.UserInfo;


/**
 * @author xuyingjie
 *
 */


@Controller
@RequestMapping("/job")
public class DealJobInfo {
	@Autowired
	@Qualifier("jobService")
	private JobService jobService;
	@Autowired
	@Qualifier("pageService")
	private PageService pageService;


	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}


	@RequestMapping(value="/postJobInfo", method = RequestMethod.POST)
	public ModelAndView postJobInfo(
			@RequestParam("jobInfoTitle")String title,
			@RequestParam("jobCompany")String company,
			@RequestParam("workplace")String workPlace,
			@RequestParam("jobContent")String jobContent,
			@RequestParam("jobRequire")String jobRequire,
			@RequestParam("jobType")int jobType,
			@RequestParam("contactEmail")String email,
			@RequestParam("contactTel")String tel,
			@RequestParam("uid")int uid,
			HttpSession session
			)
	{

		if( title==null ||title=="" 
				||company==null||company=="" 
				||workPlace==null||workPlace==""
				||jobContent==null||jobContent==""
				||jobRequire==null||jobRequire==""
				||jobType==0
				||email==null||email==""
				)
		{
			return new ModelAndView("404");
		}


		int login_id =  ((UserInfo)session.getAttribute("userInfo")).getUid();
		if(uid!=login_id)
		{
			throw new SystemException("post jobInfo fail,uid is illegal!");
		}

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today=format.format(new Date());

		JobInfo job = new JobInfo(uid,title,workPlace,jobType,today,company,jobContent,jobRequire,email,tel);

		boolean flag = jobService.postJobInfo(job);

		if(flag)
		{

			return loadJobInfo();
		}
		return new ModelAndView("404");
	}


	@RequestMapping("/showJobDetail")

	public ModelAndView showJobDetail(
			@RequestParam("uid")int uid,
			@RequestParam("j_id")int jid,
			HttpSession session)
	{

		JobDetailInfo detail=jobService.loadJobDetail(jid);


		if(detail!=null)
		{
			ModelMap modelMap=new ModelMap();
			modelMap.put("jobDetailInfo", detail);
			return new ModelAndView("job_info_detail",modelMap);
		}

		return new ModelAndView("404");

	}


	@RequestMapping("/jobInfo")
	@SuppressWarnings("unchecked")
	public ModelAndView loadJobInfo()
	{
		List<JobInfoProfile> list=(List<JobInfoProfile>)pageService.getMoreInfo(null, 1,"job");
		ModelMap	modelMap = new ModelMap();
		modelMap.put("jobInfo", list);
		return new ModelAndView("job_info",modelMap); 
	}

	@RequestMapping("/moreJobInfo")
	@SuppressWarnings("unchecked")
	@ResponseBody
	public Map<String, Object> loadMoreJobInfo(@RequestParam(value ="currentPage", required = false) Integer currentPage)
	{
		int pageNum;
		if(currentPage==null)
		{
			currentPage=1;
		}

		pageNum = currentPage+1;

		List<JobInfoProfile> list=(List<JobInfoProfile>)pageService.getMoreInfo(null, pageNum,"job");

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
