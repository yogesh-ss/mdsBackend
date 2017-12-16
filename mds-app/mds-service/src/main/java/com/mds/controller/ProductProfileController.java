package com.mds.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mds.service.ProductProfileService;

@RestController
public class ProductProfileController {
	
		private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
		@Autowired
		private ProductProfileService productProfileService;
		
		@RequestMapping(value="/create", method=RequestMethod.GET, produces={"application/json"})
		public String Create() {
			
			logger.debug("Debug: MDS - Create endPoint invoked...");
			logger.info("Info: MDS- Create endPoint invoked...");
			return productProfileService.create();
		}
		
}