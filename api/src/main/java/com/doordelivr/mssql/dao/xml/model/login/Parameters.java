package com.doordelivr.mssql.dao.xml.model.login;

import java.io.Serializable;
import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Parameters implements Serializable
{
    private static final long serialVersionUID = 2849097437721761044L;

    @JacksonXmlProperty(localName = "MobileNumber")
    private String mobileNumber;

    @JacksonXmlProperty(localName = "EmailAddress")
    private String emailAddress;

    @JacksonXmlProperty(localName = "Password")
    private String password;

    @JacksonXmlProperty(localName = "NewPassword")
    private String newPassword;

    @JacksonXmlProperty(localName = "OTP")
    private String otp;

    @JacksonXmlProperty(localName = "RetailerCode")
    private String retailerCode;

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
     * @return the retailerCode
     */
    public String getRetailerCode()
    {
        return retailerCode;
    }

    /**
     * @param retailerCode
     *            the retailerCode to set
     */
    public void setRetailerCode(String retailerCode)
    {
        this.retailerCode = retailerCode;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.emailAddress, this.mobileNumber, this.password, this.newPassword, this.otp,
                this.retailerCode);
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean result = false;

        if (Objects.nonNull(obj) && this.hashCode() == obj.hashCode() && obj instanceof Parameters)
        {
            Parameters value = (Parameters) obj;
            result = Objects.equals(value.getEmailAddress(), this.getEmailAddress())
                    && Objects.equals(value.getMobileNumber(), this.getMobileNumber())
                    && Objects.equals(value.getNewPassword(), this.getNewPassword())
                    && Objects.equals(value.getRetailerCode(), this.getRetailerCode())
                    && Objects.equals(value.getOtp(), this.getOtp());
        }

        return result;
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
