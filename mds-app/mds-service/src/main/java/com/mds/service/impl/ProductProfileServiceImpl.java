package com.mds.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mds.service.ProductProfileService;

@Component
public class ProductProfileServiceImpl implements ProductProfileService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Override
	public String create() {
		
		
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warn message");
	    logger.error("This is an error message");
		
		
		return "ProductProfile Created .." ;
	}
	
	
}
