package com.mds.mapper.productprofile;

import org.apache.ibatis.annotations.Mapper;

import com.mds.domain.productprofile.ProductProfile;

import java.util.List;

/* 
 * ProductProfileMapper interface contains the methods for performing database transactions 
 */
@Mapper
public interface ProductProfileMapper {
	
    String addProfile(ProductProfile profile);
    
    String updateProfile(ProductProfile profile); 
    
	List<ProductProfile> getAllProfiles();
	
	ProductProfile getProfileById(Integer id);

}
