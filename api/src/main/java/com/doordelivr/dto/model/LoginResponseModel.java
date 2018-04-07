package com.doordelivr.dto.model;

import java.io.Serializable;
import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponseModel implements Serializable
{
    private static final long serialVersionUID = 390188445710839535L;
    @JsonProperty("AppId")
    private String appId;
    @JsonProperty("UserId")
    private String userId;
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("MobileNumber")
    private String mobileNumber;
    @JsonProperty("EmailAddress")
    private String email;
    @JsonProperty("Error")
    private ErrorModel errorModel;
    
    /**
     * @return the appId
     */
    public String getAppId()
    {
        return appId;
    }

    /**
     * @param appId
     *            the appId to set
     */
    public void setAppId(String appId)
    {
        this.appId = appId;
    }

    /**
     * @return the userId
     */
    public String getUserId()
    {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    /**
     * @return the userName
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @param userName
     *            the userName to set
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * @return the mobileNumber
     */
    public String getMobileNumber()
    {
        return mobileNumber;
    }

    /**
     * @param mobileNumber
     *            the mobileNumber to set
     */
    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the errorModel
     */
    public ErrorModel getErrorModel()
    {
        return errorModel;
    }

    /**
     * @param errorModel the errorModel to set
     */
    public void setErrorModel(ErrorModel errorModel)
    {
        this.errorModel = errorModel;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.appId, this.email, this.mobileNumber, this.userId, this.userName, this.errorModel);
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;

        if (Objects.nonNull(obj) && this.hashCode() == obj.hashCode() && obj instanceof LoginResponseModel)
        {
            LoginResponseModel value = (LoginResponseModel) obj;
            result = Objects.equals(value.getAppId(), this.getAppId())
                    && Objects.equals(value.getEmail(), this.getEmail())
                    && Objects.equals(value.getMobileNumber(), this.getMobileNumber())
                    && Objects.equals(value.getUserId(), this.getUserId())
                    && Objects.equals(value.getUserName(), this.getUserName())
                    && Objects.equals(value.errorModel,this.errorModel);
        }

        return result;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
