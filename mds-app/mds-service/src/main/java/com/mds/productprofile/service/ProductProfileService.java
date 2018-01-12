package com.mds.productprofile.service;

import java.util.List;

import com.mds.domain.productprofile.ProductProfile;

public interface ProductProfileService {
	
	String createProfile(ProductProfile productProfile);
	
	String updateProfile(ProductProfile productProfile);
	
	List<ProductProfile> retrieveAllProfiles();
	
	ProductProfile retrieveProfile(Integer profileNumber);
	
}
