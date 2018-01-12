package com.mds.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mds.domain.productprofile.ProductProfile;
import com.mds.productprofile.service.ProductProfileService;

@RestController
public class ProductProfileController {
		
		private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
		@Autowired
		private ProductProfileService productProfileService;
		
		// Create Product Profile
		//@RequestMapping(value="/productProfile/create", method=RequestMethod.GET, produces={"application/json"})
		
		@PostMapping(path = "/productProfile/create", consumes = "application/json", produces = "application/json")
		public String createProductProfile(@RequestBody ProductProfile productProfile) {
			
			logger.debug("Debug: MDS - Product Profile Create endPoint invoked...");
			logger.info("Info: MDS- Create endPoint invoked...");
			return productProfileService.createProfile(productProfile);
		}
		
		// Update  Product Profile
		@PostMapping(path = "/productProfile/update", consumes = "application/json", produces = "application/json")
		public String updateProductProfile(ProductProfile productProfile ) {
					
			logger.debug("Debug: MDS - Product Profile update endPoint invoked...");
			//productProfileService.updateProfile(productProfile);
			return null;
		}
		
		// Retrieve a Product Profile
		@GetMapping("/productProfile/retrieve/{id}")
		public ResponseEntity<ProductProfile> retrieveProductProfileByNo(@PathVariable("id") Integer id) {
			
			logger.debug("Debug: MDS - Retrive product profile endPoint invoked...");
			
			ProductProfile productProfile = productProfileService.retrieveProfile(id);
			return new ResponseEntity<ProductProfile>(productProfile, HttpStatus.OK);
		}
		
		// Retrieve all Product Profiles
		@GetMapping("/productProfile/retrieve/all")
		public ResponseEntity<List<ProductProfile>> retrieveAllProductProfiles() {

			logger.debug("Debug: MDS -  Retrive all Product Profiles endPoint invoked...");
			
			List<ProductProfile> profileList = productProfileService.retrieveAllProfiles();
			return new ResponseEntity<List<ProductProfile>>(profileList, HttpStatus.OK);
		}
				
		

}