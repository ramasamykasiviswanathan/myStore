package com.doordelivr.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.doordelivr.dto.model.AddRetailerResponseModel;
import com.doordelivr.dto.model.ChangePasswordResponseModel;
import com.doordelivr.dto.model.ForgotPasswordResponseModel;
import com.doordelivr.dto.model.LoginResponseModel;
import com.doordelivr.dto.model.ShopInformationModel;
import com.doordelivr.dto.model.ShowShopsResponseModel;
import com.doordelivr.dto.model.SignupUserResponseModel;
import com.doordelivr.dto.model.UserIdentity;
import com.doordelivr.mssql.dao.crudrepository.LoginRepository;
import com.doordelivr.util.DaoUtil;
import com.doordelivr.util.DtoUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController()
public class LoginController
{

    @Autowired
    private DaoUtil daoutil;

    @Autowired
    private DtoUtil dtoUtil;

    @Autowired
    private LoginRepository loginRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(path = "/Login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> login(@RequestBody String identity, @RequestHeader(value = "AppId") String appId)
            throws JsonProcessingException
    {
        ResponseEntity<String> responseEntity = null;
        try
        {
            String value = loginRepository
                    .user(daoutil.populateLoginEnitity(objectMapper.readValue(identity, UserIdentity.class), appId));
            System.out.println("Returned Value is: " + value);
            responseEntity = new ResponseEntity<String>(
                    objectMapper.writeValueAsString(dtoUtil.populateLoginResponse(value)), HttpStatus.ACCEPTED);
        } catch (Exception e)
        {
            LoginResponseModel loginResponseModel = new LoginResponseModel();
            loginResponseModel.setErrorModel(dtoUtil.populateErrorModel(e));
            responseEntity = new ResponseEntity<String>(objectMapper.writeValueAsString(loginResponseModel),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping(path = "/ForgotPassword", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> forgotPassword(@RequestBody String identity,
            @RequestHeader(value = "AppId") String appId) throws JsonProcessingException
    {
        ResponseEntity<String> responseEntity = null;
        ForgotPasswordResponseModel forgotPasswordResponseModel = new ForgotPasswordResponseModel();
        try
        {
            forgotPasswordResponseModel.setMessage(loginRepository.user(daoutil
                    .populateForgotPasswordEnitity(objectMapper.readValue(identity, UserIdentity.class), appId)));
            responseEntity = new ResponseEntity<>(objectMapper.writeValueAsString(forgotPasswordResponseModel),
                    HttpStatus.ACCEPTED);
        } catch (Exception e)
        {
            forgotPasswordResponseModel.setErrorModel(dtoUtil.populateErrorModel(e));
            responseEntity = new ResponseEntity<String>(objectMapper.writeValueAsString(forgotPasswordResponseModel),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping(path = "/ChangePassword", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> changePassword(@RequestBody String identity,
            @RequestHeader(value = "AppId") String appId,
            @RequestHeader(value = "UserId", required = false) String userId) throws JsonProcessingException
    {
        ResponseEntity<String> responseEntity = null;

        ChangePasswordResponseModel changePasswordResponseModel = new ChangePasswordResponseModel();
        try
        {
            changePasswordResponseModel.setMessage(loginRepository.user(daoutil.populateChangePasswordEnitity(
                    objectMapper.readValue(identity, UserIdentity.class), appId, userId)));
            responseEntity = new ResponseEntity<>(objectMapper.writeValueAsString(changePasswordResponseModel),
                    HttpStatus.ACCEPTED);
        } catch (Exception e)
        {
            changePasswordResponseModel.setErrorModel(dtoUtil.populateErrorModel(e));
            responseEntity = new ResponseEntity<String>(objectMapper.writeValueAsString(changePasswordResponseModel),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping(path = "/SignupUser", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> signupUser(@RequestBody String identity, @RequestHeader(value = "AppId") String appId)
            throws JsonProcessingException
    {
        ResponseEntity<String> responseEntity = null;

        SignupUserResponseModel signupUserResponseModel = new SignupUserResponseModel();
        try
        {
            signupUserResponseModel.setMessage(loginRepository.user(
                    daoutil.populateSignupUserEnitity(objectMapper.readValue(identity, UserIdentity.class), appId)));
            responseEntity = new ResponseEntity<>(objectMapper.writeValueAsString(signupUserResponseModel),
                    HttpStatus.ACCEPTED);
        } catch (Exception e)
        {
            signupUserResponseModel.setErrorModel(dtoUtil.populateErrorModel(e));
            responseEntity = new ResponseEntity<String>(objectMapper.writeValueAsString(signupUserResponseModel),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping(path = "/ShowShops", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> showShops(@RequestHeader(value = "AppId") String appId,
            @RequestHeader(value = "UserId") String userId) throws JsonProcessingException
    {
        ResponseEntity<String> responseEntity = null;
        final ShowShopsResponseModel shopsResponseModel = new ShowShopsResponseModel();
        try
        {
            Object value = loginRepository.shops(daoutil.populateShowShopsEnitity(appId, userId));
            System.out.println("Returned value is:" + value);
            Arrays.stream((Object[]) value).map(String::valueOf).map(StringUtils::trimToNull)
                    .reduce((x, y) -> x + "," + y).map(dtoUtil::populateShopInformationModel).filter(Objects::nonNull)
                    .ifPresent(s ->
                    {
                        List<ShopInformationModel> shopInformations = Arrays.asList(s);
                        shopsResponseModel
                                .setShopInformationModels(shopInformations.isEmpty() ? null : shopInformations);
                    });

            /*
             * List<ShopInformationModel> shopInformations =
             * loginRepository.shops(daoutil.populateShowShopsEnitity(appId,
             * userId)).stream().map(String::valueOf).map(dtoUtil::
             * populateShopInformationModel)
             * .filter(Objects::nonNull).collect(Collectors.toList());
             */
            // shopsResponseModel.setShopInformationModels(shopInformationModels.isEmpty() ?
            // null : shopInformationModels);
            responseEntity = new ResponseEntity<>(objectMapper.writeValueAsString(shopsResponseModel),
                    HttpStatus.ACCEPTED);
        } catch (Exception e)
        {
            shopsResponseModel.setErrorModel(dtoUtil.populateErrorModel(e));
            responseEntity = new ResponseEntity<String>(objectMapper.writeValueAsString(shopsResponseModel),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping(path = "/AddRetailer", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> addRetailer(@RequestBody String identity,
            @RequestHeader(value = "AppId") String appId, @RequestHeader(value = "UserId") String userId)
            throws JsonProcessingException
    {
        ResponseEntity<String> responseEntity = null;
        AddRetailerResponseModel addRetailerResponseModel = new AddRetailerResponseModel();
        try
        {
            addRetailerResponseModel.setMessage(loginRepository.user(daoutil
                    .populateAddRetailerEnitity(objectMapper.readValue(identity, UserIdentity.class), appId, userId)));
            responseEntity = new ResponseEntity<>(objectMapper.writeValueAsString(addRetailerResponseModel),
                    HttpStatus.ACCEPTED);
        } catch (Exception e)
        {
            addRetailerResponseModel.setErrorModel(dtoUtil.populateErrorModel(e));
            responseEntity = new ResponseEntity<String>(objectMapper.writeValueAsString(addRetailerResponseModel),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

}
