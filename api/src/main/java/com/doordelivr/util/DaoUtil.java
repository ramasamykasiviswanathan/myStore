package com.doordelivr.util;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Component;

import com.doordelivr.dto.model.UserIdentity;
import com.doordelivr.mssql.dao.xml.model.login.InputParam;
import com.doordelivr.mssql.dao.xml.model.login.Parameters;
import com.fasterxml.jackson.core.JsonProcessingException;

@Component
public class DaoUtil
{
    @Autowired
    private MappingJackson2XmlHttpMessageConverter xmlConverter;
    
    private DaoUtil()
    {
    }

    public String populateLoginEnitity(final UserIdentity identity, final String appId) throws JsonProcessingException
    {
        InputParam inputParam = populateInputParam(identity, appId);
        inputParam.setSpType("Validate_User");
        return xmlConverter.getObjectMapper().writeValueAsString(inputParam);
    }

    public String populateForgotPasswordEnitity(final UserIdentity identity, final String appId)
            throws JsonProcessingException
    {
        InputParam inputParam = populateInputParam(identity, appId);
        inputParam.setSpType("Forgot_Password");
        return xmlConverter.getObjectMapper().writeValueAsString(inputParam);
    }

    public String populateChangePasswordEnitity(final UserIdentity identity, final String appId, final String userID)
            throws JsonProcessingException
    {
        InputParam inputParam = populateInputParam(identity, appId, userID);
        inputParam.setSpType("Change_Password");
        return xmlConverter.getObjectMapper().writeValueAsString(inputParam);
    }
    
    public String populateSignupUserEnitity(final UserIdentity identity, final String appId)
            throws JsonProcessingException
    {
        InputParam inputParam = populateInputParam(identity, appId);
        inputParam.setSpType("Signup_User");
        return xmlConverter.getObjectMapper().writeValueAsString(inputParam);
    }
    
    public String populateShowShopsEnitity(final String appId, final String userID)
            throws JsonProcessingException
    {
        InputParam inputParam = populateInputParam(appId, userID);
        inputParam.setSpType("Show_Shops");
        return xmlConverter.getObjectMapper().writeValueAsString(inputParam);
    }
    
    public String populateAddRetailerEnitity(final UserIdentity identity, final String appId, final String userID)
            throws JsonProcessingException
    {
        InputParam inputParam = populateInputParam(identity, appId, userID);
        inputParam.setSpType("Add_Retailer");
        return xmlConverter.getObjectMapper().writeValueAsString(inputParam);
    }

    public InputParam populateInputParam(final UserIdentity identity, final String appId, final String userID)
    {
        return this.initialiseInputParam(identity, appId, userID);
    }
    
    public InputParam populateInputParam(final String appId, final String userID)
    {
        return this.initialiseInputParam(null, appId, userID);
    }

    public InputParam populateInputParam(final UserIdentity identity, final String appId)
    {
        return this.initialiseInputParam(identity, appId, null);
    }

    private InputParam initialiseInputParam(final UserIdentity identity, final String appId, final String userID)
    {
        InputParam inputParam = new InputParam();
        inputParam.setAppID(appId);
        inputParam.setUserID(userID);

        Parameters parameters = null;
        if (Objects.nonNull(identity))
        {
            parameters = new Parameters();
            parameters.setEmailAddress(identity.getEmailAddress());
            parameters.setMobileNumber(identity.getMobileNumber());
            parameters.setNewPassword(identity.getNewPassword());
            parameters.setPassword(identity.getPassword());
            parameters.setOtp(identity.getOtp());
            parameters.setRetailerCode(identity.getRetailerCode());
        }
        inputParam.setParameters(parameters);
        return inputParam;
    }
}
