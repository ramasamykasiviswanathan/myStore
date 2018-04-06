package com.doordelivr.dto.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShowShopsResponseModel implements Serializable
{
    private static final long serialVersionUID = -7703268782865524882L;
    @JsonProperty("Retailers")
    private List<ShopInformationModel> shopInformationModels;

    @JsonProperty("Error")
    private ErrorModel errorModel;

    /**
     * @return the shopInformationModels
     */
    public List<ShopInformationModel> getShopInformationModels()
    {
        return shopInformationModels;
    }

    /**
     * @param shopInformationModels
     *            the shopInformationModels to set
     */
    public void setShopInformationModels(List<ShopInformationModel> shopInformationModels)
    {
        this.shopInformationModels = shopInformationModels;
    }

    /**
     * @return the errorModel
     */
    public ErrorModel getErrorModel()
    {
        return errorModel;
    }

    /**
     * @param errorModel
     *            the errorModel to set
     */
    public void setErrorModel(ErrorModel errorModel)
    {
        this.errorModel = errorModel;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.errorModel, this.shopInformationModels);
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;

        if (Objects.nonNull(obj) && this.hashCode() == obj.hashCode() && obj instanceof ShowShopsResponseModel)
        {
            ShowShopsResponseModel value = (ShowShopsResponseModel) obj;
            result = Objects.equals(value.getErrorModel(), this.getErrorModel())
                    && Objects.equals(value.getShopInformationModels(), this.getShopInformationModels());
        }

        return result;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
