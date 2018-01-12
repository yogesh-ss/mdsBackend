package com.mds.dao.productprofile;

import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mds.domain.productprofile.ProductProfile;

@Component
public class ProductProfileDAO  {
	
	@Autowired
	private final SqlSession sqlSession;
	
	public ProductProfileDAO(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}
	
	public String createProfile(ProductProfile productProfile) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		params.put("productNo", productProfile.getProductNo());
		params.put("productName", productProfile.getProductName());
		params.put("productType", productProfile.getProductType());
		params.put("amount", productProfile.getAmount());
		params.put("currency", productProfile.getCurrency());
		params.put("country", productProfile.getCountry());
		params.put("approvalDate", productProfile.getApprovalDate());
		params.put("term", productProfile.getTerm());
		params.put("status", productProfile.getStatus());
		params.put("createdDate", Timestamp.valueOf(productProfile.getCreatedDate()));
		params.put("lastModifiedDate", Timestamp.valueOf(productProfile.getLastModifiedDate()));
		
		System.out.println("createdDate =" + params.get("createdDate"));
		System.out.println("lastModifiedDate =" + params.get("lastModifiedDate"));
		
		sqlSession.selectOne("addProfile", params);
		String result = (String) params.get("message");
		
		return result;
	}

	public String updateProfile(ProductProfile productProfile) {
		return null;	
	}
	
	public ProductProfile retrieveProfileById(int id) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("productNo", id);
		
		sqlSession.selectOne("getProfileById", params);
		
		List<?> productProfileList = (List<?>) params.get("productProfile");
		
		ProductProfile productProfile = (ProductProfile) productProfileList.get(0);
		
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		//productProfile.setCreatedDate(sdf.format(Timestamp.valueOf(productProfile.getCreatedDate())));
		
		return productProfile;		
	}

	public List<ProductProfile> retrieveAllProfiles() {
		
		Map<String, List<ProductProfile>> params = new HashMap<String, List<ProductProfile>>();
		sqlSession.selectOne("getAllProfiles", params);
		List<ProductProfile> productProfileList = params.get("productProfileList");
		return productProfileList;
	}

}
