package com.doordelivr.mssql.dao.xml.model;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class OrderDetails {

	@JacksonXmlProperty(localName = "OrderNumber")
	private String orderNO;
	
	@JacksonXmlProperty(localName = "OrderDate")
	private String orderDate;
	
	@JacksonXmlProperty(localName = "productID")
	private String productID;
	
	@JacksonXmlProperty(localName = "price")
	private String price;
	
	@JacksonXmlProperty(localName = "quantity")
	private String quantity;
	
	@JacksonXmlProperty(localName = "image_link")
	private String imageLink;

	/**
	 * @return the orderNO
	 */
	public String getOrderNO() {
		return orderNO;
	}

	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * @return the productID
	 */
	public String getProductID() {
		return productID;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @return the imageLink
	 */
	public String getImageLink() {
		return imageLink;
	}

	/**
	 * @param orderNO the orderNO to set
	 */
	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @param productID the productID to set
	 */
	public void setProductID(String productID) {
		this.productID = productID;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @param imageLink the imageLink to set
	 */
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	
	
}
