package com.doordelivr.mssql.dao.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = -2836777799213488158L;
	private Integer productCode;
	private String productName;
	private Double stock;
	private Double mrp;

	public Product(Integer productCode, String productName, Double stock, Double mrp) {
		this.productCode = productCode;
		this.productName = productName;
		this.stock = stock;
		this.mrp = mrp;
	}

	/**
	 * @return the productCode
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductCode")
	public Integer getProductCode() {
		return productCode;
	}

	/**
	 * @return the productName
	 */
	@Column(name = "ProductName")
	public String getProductName() {
		return productName;
	}

	/**
	 * @return the stock
	 */
	@Column(name = "Stock")
	public Double getStock() {
		return stock;
	}

	/**
	 * @return the mrp
	 */
	@Column(name = "MRP")
	public Double getMrp() {
		return mrp;
	}

	/**
	 * @param productCode
	 *            the productCode to set
	 */
	public void setProductCode(Integer productCode) {
		this.productCode = productCode;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @param stock
	 *            the stock to set
	 */
	public void setStock(Double stock) {
		this.stock = stock;
	}

	/**
	 * @param mrp
	 *            the mrp to set
	 */
	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (this.hashCode() == obj.hashCode() && obj instanceof Product) {
			Product products = (Product) obj;
			if (Objects.equals(this.getStock(), products.getStock()) && Objects.equals(this.getMrp(), products.getMrp())
					&& Objects.equals(this.getProductCode(), products.getProductCode())
					&& Objects.equals(this.getProductName(), products.getProductName())) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getMrp(), this.getProductCode(), this.getProductName(), this.getStock());
	}
}
