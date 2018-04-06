package com.doordelivr.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Component;

import com.doordelivr.dto.model.ErrorModel;
import com.doordelivr.dto.model.LoginResponseModel;
import com.doordelivr.dto.model.ShopInformationModel;

@Component
public class DtoUtil
{

    private DtoUtil()
    {

    }

    public LoginResponseModel populateLoginResponse(final String response)
    {
        LoginResponseModel loginResponseModel = new LoginResponseModel();
        if (StringUtils.isNotBlank(response))
        {
            Iterator<String> valueIterator = Arrays.stream(response.split(",")).map(StringUtils::trimToNull)
                    .collect(LinkedList<String>::new, LinkedList::add, LinkedList::addAll).iterator();
            loginResponseModel.setAppId(getValueFromIterator(valueIterator));
            loginResponseModel.setUserId(getValueFromIterator(valueIterator));
            loginResponseModel.setUserName(getValueFromIterator(valueIterator));
            loginResponseModel.setMobileNumber(getValueFromIterator(valueIterator));
            loginResponseModel.setEmail(getValueFromIterator(valueIterator));
        }
        return loginResponseModel;
    }

    public <T> T getValueFromIterator(final Iterator<T> iterator)
    {
        return iterator.hasNext() ? iterator.next() : null;
    }

    public ErrorModel populateErrorModel(Exception e)
    {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setMessage(e.getMessage());
        if (Objects.nonNull(e.getCause()) && e instanceof InvalidDataAccessResourceUsageException
                && Objects.nonNull(e.getCause().getCause()))
        {
            errorModel.setMessage(e.getCause().getCause().getMessage());
        }
        return errorModel;
    }
    
    public ShopInformationModel populateShopInformationModel(final String shopInfo)
    {
        ShopInformationModel informationModel = null;
        if(StringUtils.isNoneBlank(shopInfo))
        {
            Iterator<String> valueIterator = Arrays.stream(shopInfo.split(",")).map(StringUtils::trimToNull)
                    .collect(LinkedList<String>::new, LinkedList::add, LinkedList::addAll).iterator();
            informationModel = new ShopInformationModel();
            informationModel.setRetailerId(getValueFromIterator(valueIterator));
            informationModel.setRetailerName(getValueFromIterator(valueIterator));
            informationModel.setRetailerBusiness(getValueFromIterator(valueIterator));
            informationModel.setStoreIdentifier(getValueFromIterator(valueIterator));
            informationModel.setTermsAndCond(getValueFromIterator(valueIterator));
        }
        return informationModel;
    }
}
