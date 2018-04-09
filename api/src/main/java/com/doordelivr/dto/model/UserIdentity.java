package com.doordelivr.dto.model;

import java.io.Serializable;
import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class UserIdentity implements Serializable
{
    private static final long serialVersionUID = -7732500950017438412L;

    public UserIdentity()
    {
      // Empty Constructor
    }
    
    @JsonProperty("MobileNumber")
    private String mobileNumber;

    @JsonProperty("EmailAddress")
    private String emailAddress;

    @JsonProperty("Password")
    private String password;

    @JsonProperty("NewPassword")
    private String newPassword;

    @JsonProperty("OTP")
    private String otp;
    
    @JsonProperty("RetailerCode")
    private String retailerCode;
    
    @JsonProperty("Name")
    private String name;

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
     * @return the emailAddress
     */
    public String getEmailAddress()
    {
        return emailAddress;
    }

    /**
     * @param emailAddress
     *            the emailAddress to set
     */
    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the newPassword
     */
    public String getNewPassword()
    {
        return newPassword;
    }

    /**
     * @param newPassword
     *            the newPassword to set
     */
    public void setNewPassword(String newPassword)
    {
        this.newPassword = newPassword;
    }

    /**
     * @return the otp
     */
    public String getOtp()
    {
        return otp;
    }

    /**
     * @param otp
     *            the otp to set
     */
    public void setOtp(String otp)
    {
        this.otp = otp;
    }

    /**
     * @return the retailerCode
     */
    public String getRetailerCode()
    {
        return retailerCode;
    }

    /**
     * @param retailerCode the retailerCode to set
     */
    public void setRetailerCode(String retailerCode)
    {
        this.retailerCode = retailerCode;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.emailAddress, this.mobileNumber, this.password, this.newPassword, this.otp, this.retailerCode, this.name);
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;

        if (Objects.nonNull(obj) && this.hashCode() == obj.hashCode() && obj instanceof UserIdentity)
        {
            UserIdentity value = (UserIdentity) obj;
            result = Objects.equals(value.getEmailAddress(), this.getEmailAddress())
                    && Objects.equals(value.getMobileNumber(), this.getMobileNumber())
                    && Objects.equals(value.getNewPassword(), this.getNewPassword())
                    && Objects.equals(value.getRetailerCode(), this.getRetailerCode())
                    && Objects.equals(value.getOtp(), this.getOtp())
                    && Objects.equals(value.getName(), this.getName());
        }

        return result;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
