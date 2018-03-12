package com.doordelivr.mssql.dao.xml.model.saveorder;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class SaveOrder {
//	@JacksonXmlElementWrapper(localName = "OrderDetails", useWrapping = false)
	@JacksonXmlProperty(localName = "OrderDetails")
	private List<OrderDetails> details;

	/**
	 * @return the details
	 */
	public List<OrderDetails> getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(List<OrderDetails> details) {
		this.details = details;
	}
	
}
