package com.mds.domain.productprofile;

import java.math.BigDecimal;

public class ProductProfile {
	
	private Integer productNo;
	private String productName;
	private String productType;
	private BigDecimal amount;
	private String currency;
	private String country;
	private int term;
	private String status;
	private String approvalDate;
	private String createdDate;
	private String lastModifiedDate;
	
	public int getProductNo() {
		return productNo;
	}
	
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getTerm() {
		return term;
	}
	
	public void setTerm(int term) {
		this.term = term;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getApprovalDate() {
		return approvalDate;
	}
	
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}
	
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Override
	public String toString() {
		return "ProductProfile [productNo=" + productNo + ", productName=" + productName + ", productType="
				+ productType + ", amount=" + amount + ", currency=" + currency + ", country=" + country + ", term="
				+ term + ", status=" + status + ", approvalDate=" + approvalDate + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}
}
