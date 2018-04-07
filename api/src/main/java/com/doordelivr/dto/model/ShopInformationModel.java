package com.doordelivr.dto.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShopInformationModel
{
    @JsonProperty("ID")
    private String retailerId;
    @JsonProperty("Name")
    private String retailerName;
    @JsonProperty("Business")
    private String retailerBusiness;
    @JsonProperty("StoreID")
    private String storeIdentifier;
    @JsonProperty("TAndC")
    private String termsAndCond;

    /**
     * @return the retailerId
     */
    public String getRetailerId()
    {
        return retailerId;
    }

    /**
     * @param retailerId
     *            the retailerId to set
     */
    public void setRetailerId(String retailerId)
    {
        this.retailerId = retailerId;
    }

    /**
     * @return the retailerName
     */
    public String getRetailerName()
    {
        return retailerName;
    }

    /**
     * @param retailerName
     *            the retailerName to set
     */
    public void setRetailerName(String retailerName)
    {
        this.retailerName = retailerName;
    }

    /**
     * @return the retailerBusiness
     */
    public String getRetailerBusiness()
    {
        return retailerBusiness;
    }

    /**
     * @param retailerBusiness
     *            the retailerBusiness to set
     */
    public void setRetailerBusiness(String retailerBusiness)
    {
        this.retailerBusiness = retailerBusiness;
    }

    /**
     * @return the storeIdentifier
     */
    public String getStoreIdentifier()
    {
        return storeIdentifier;
    }

    /**
     * @param storeIdentifier
     *            the storeIdentifier to set
     */
    public void setStoreIdentifier(String storeIdentifier)
    {
        this.storeIdentifier = storeIdentifier;
    }

    /**
     * @return the termsAndCond
     */
    public String getTermsAndCond()
    {
        return termsAndCond;
    }

    /**
     * @param termsAndCond
     *            the termsAndCond to set
     */
    public void setTermsAndCond(String termsAndCond)
    {
        this.termsAndCond = termsAndCond;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.retailerBusiness, this.retailerId, this.retailerName, this.storeIdentifier,
                this.termsAndCond);
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;

        if (Objects.nonNull(obj) && this.hashCode() == obj.hashCode() && obj instanceof ShopInformationModel)
        {
            ShopInformationModel value = (ShopInformationModel) obj;
            result = Objects.equals(value.getRetailerBusiness(), this.getRetailerBusiness())
                    && Objects.equals(value.getRetailerId(), this.getRetailerId())
                    && Objects.equals(value.getRetailerName(), this.getRetailerName())
                    && Objects.equals(value.getStoreIdentifier(), this.getStoreIdentifier())
                    && Objects.equals(value.getTermsAndCond(), this.getTermsAndCond());
        }

        return result;
    }
}
