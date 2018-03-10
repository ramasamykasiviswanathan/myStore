package com.doordelivr.mssql.dao.xml.model.fetchcategory;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "InputParam")
public class InputParam {
	@JacksonXmlProperty(localName = "SP_Type")
	private String spType;
	@JacksonXmlProperty(localName = "AppId")
	private String appID;
	@JacksonXmlProperty(localName = "User_Id")
	private String userID;
	@JacksonXmlProperty(localName = "Retailer_Id")
	private String retailerID;
	@JacksonXmlProperty(localName = "Params")
	private Parameters parameters;
	
	/**
	 * @return the spType
	 */
	public String getSpType() {
		return spType;
	}
	/**
	 * @param spType the spType to set
	 */
	public void setSpType(String spType) {
		this.spType = spType;
	}
	/**
	 * @return the appID
	 */
	public String getAppID() {
		return appID;
	}
	/**
	 * @param appID the appID to set
	 */
	public void setAppID(String appID) {
		this.appID = appID;
	}
	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
	 * @return the retailerID
	 */
	public String getRetailerID() {
		return retailerID;
	}
	/**
	 * @param retailerID the retailerID to set
	 */
	public void setRetailerID(String retailerID) {
		this.retailerID = retailerID;
	}
	/**
	 * @return the parameters
	 */
	public Parameters getParameters() {
		return parameters;
	}
	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	
}
