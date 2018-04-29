package com.zjipst.cjj.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TestController {

	public TestController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/javaservices/test", method = RequestMethod.POST)
	public String appFeedBack(
			@RequestParam(value = "feedBackInfo") String feedBackInfo, 
			@RequestParam(value = "attachs", required = false) MultipartFile[] attachs,
			@RequestParam(value = "isrx", required = false) String isrx,
			HttpServletRequest request){
		
		if (StringUtils.isEmpty(feedBackInfo)) {
			return "feedBackInfo is null";
		}
		
		return "feedBackInfo="+feedBackInfo;
	}

}
