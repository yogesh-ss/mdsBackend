package com.mds.productprofile.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mds.dao.productprofile.ProductProfileDAO;
import com.mds.domain.productprofile.ProductProfile;
import com.mds.productprofile.service.ProductProfileService;
import com.mds.util.ProductProfileUtil;

@Component
public class ProductProfileServiceImpl implements ProductProfileService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private  ProductProfileDAO productProfileDAO;

	@Override
	public String createProfile(ProductProfile  productProfile) {
		
		productProfile.setProductNo(ProductProfileUtil.getRandomNumber());
		logger.debug("Create a product profile " + productProfile.getProductNo());
		
		productProfile.setApprovalDate(null);
		productProfile.setCreatedDate(ProductProfileUtil.getCurrentTimeSatmpAsString());
		productProfile.setLastModifiedDate(ProductProfileUtil.getCurrentTimeSatmpAsString());
	    return productProfileDAO.createProfile(productProfile);
	}

	@Override
	public String updateProfile(ProductProfile  productProfile) {
		return null;
	}

	@Override
	public List<ProductProfile> retrieveAllProfiles() {
		
		logger.debug("Retrieve all Product profiles");
		return productProfileDAO.retrieveAllProfiles();
	}

	@Override
	public ProductProfile retrieveProfile(Integer profileNumber) {
		
		logger.debug("Retrieve a Product profile for " +profileNumber);
		return productProfileDAO.retrieveProfileById(profileNumber);
	}
	
}
