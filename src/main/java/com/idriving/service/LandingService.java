package com.idriving.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LandingService {

	private static final Logger logger = LoggerFactory.getLogger(LandingService.class);

	public String getDesc() {

		logger.debug("getDesc() is executed!");

		return "Report Impaired Driving";

	}

	public String getTitle(String name) {

		logger.debug("getTitle() is executed! $name : {}", name);

		if(StringUtils.isEmpty(name)){
			return "Impaired Driver";
		}else{
			return "Hello " + name;
		}
		
	}

}