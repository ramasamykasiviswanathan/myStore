package com.doordelivr.mssql.dao.xml.model;

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

	@JacksonXmlProperty(localName = "Orders")
	private SaveOrder order;

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
	 * @return the order
	 */
	public SaveOrder getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(SaveOrder order) {
		this.order = order;
	}

}
