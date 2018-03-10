package com.doordelivr.mssql.dao.xml.model.fetchcategory;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.StreamingHttpOutputMessage;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Parameters {

	@JacksonXmlProperty(localName = "SearchCategory")
	private String searchCategory;
	
	@JacksonXmlProperty(localName = "SearchSubCategory")
	private String searchSubCategory;
	
	@JacksonXmlProperty(localName = "SearchProducts")
	private String searchProducts;

	/**
	 * @return the searchCategory
	 */
	public String getSearchCategory() {
		return searchCategory;
	}

	/**
	 * @param searchCategory the searchCategory to set
	 */
	public void setSearchCategory(String searchCategory) {
		this.searchCategory = searchCategory;
	}

	/**
	 * @return the searchSubCategory
	 */
	public String getSearchSubCategory() {
		return searchSubCategory;
	}

	/**
	 * @param searchSubCategory the searchSubCategory to set
	 */
	public void setSearchSubCategory(String searchSubCategory) {
		this.searchSubCategory = searchSubCategory;
	}

	/**
	 * @return the searchProducts
	 */
	public String getSearchProducts() {
		return searchProducts;
	}

	/**
	 * @param searchProducts the searchProducts to set
	 */
	public void setSearchProducts(String searchProducts) {
		this.searchProducts = searchProducts;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	
}
