package com.doordelivr.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.doordelivr.dto.model.UserIdentity;
import com.doordelivr.mssql.dao.crudrepository.LoginRepository;
import com.doordelivr.util.DaoUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController()
public class LoginController
{

    @Autowired
    private DaoUtil daoutil;
    
    @Autowired
    private LoginRepository loginRepository;

    ObjectMapper objectMapper = new ObjectMapper();
    
    @PostMapping(path = "/Login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> login(@RequestBody String identity, @RequestHeader(value = "AppId") String appId)
    {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
        
        try
        {
            String value = loginRepository.validateUser(daoutil.populateLoginEnitity(objectMapper.readValue(identity, UserIdentity.class), appId));
            System.out.println("Returned Value is: "+ value);
        }
        catch (Exception e)
        {
            String message = e.getMessage();
            if(Objects.nonNull(e.getCause()) && e instanceof InvalidDataAccessResourceUsageException && Objects.nonNull(e.getCause().getCause()))
            {
                message = e.getCause().getCause().getMessage();
            }
            responseEntity = new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    
    @PostMapping(path = "/ForgotPassword", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> forgotPassword(@RequestBody String identity, @RequestHeader(value = "AppId") String appId)
    {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
        
        try
        {
            String value = loginRepository.validateUser(daoutil.populateForgotPasswordEnitity(objectMapper.readValue(identity, UserIdentity.class), appId));
            System.out.println("Returned Value is: "+ value);
        }
        catch (Exception e)
        {
            String message = e.getMessage();
            if(Objects.nonNull(e.getCause()) && e instanceof InvalidDataAccessResourceUsageException && Objects.nonNull(e.getCause().getCause()))
            {
                message = e.getCause().getCause().getMessage();
            }
            responseEntity = new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    
    @PostMapping(path = "/ChangePassword", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> changePassword(@RequestBody String identity, @RequestHeader(value = "AppId") String appId, @RequestHeader(value = "UserId") String userId)
    {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
        
        try
        {
            String value = loginRepository.validateUser(daoutil.populateChangePasswordEnitity(objectMapper.readValue(identity, UserIdentity.class), appId, userId));
            System.out.println("Returned Value is: "+ value);
        }
        catch (Exception e)
        {
            String message = e.getMessage();
            if(Objects.nonNull(e.getCause()) && e instanceof InvalidDataAccessResourceUsageException && Objects.nonNull(e.getCause().getCause()))
            {
                message = e.getCause().getCause().getMessage();
            }
            responseEntity = new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    
    @PostMapping(path = "/SignupUser", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> signupUser(@RequestBody String identity, @RequestHeader(value = "AppId") String appId)
    {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
        
        try
        {
            String value = loginRepository.validateUser(daoutil.populateSignupUserEnitity(objectMapper.readValue(identity, UserIdentity.class), appId));
            System.out.println("Returned Value is: "+ value);
        }
        catch (Exception e)
        {
            String message = e.getMessage();
            if(Objects.nonNull(e.getCause()) && e instanceof InvalidDataAccessResourceUsageException && Objects.nonNull(e.getCause().getCause()))
            {
                message = e.getCause().getCause().getMessage();
            }
            responseEntity = new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    
    @PostMapping(path = "/ShowShops", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> showShops(@RequestBody String identity, @RequestHeader(value = "AppId") String appId, @RequestHeader(value = "UserId") String userId)
    {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
        
        try
        {
            String value = loginRepository.validateUser(daoutil.populateChangePasswordEnitity(objectMapper.readValue(identity, UserIdentity.class), appId, userId));
            System.out.println("Returned Value is: "+ value);
        }
        catch (Exception e)
        {
            String message = e.getMessage();
            if(Objects.nonNull(e.getCause()) && e instanceof InvalidDataAccessResourceUsageException && Objects.nonNull(e.getCause().getCause()))
            {
                message = e.getCause().getCause().getMessage();
            }
            responseEntity = new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    
    @PostMapping(path = "/AddRetailer", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> addRetailer(@RequestBody String identity, @RequestHeader(value = "AppId") String appId, @RequestHeader(value = "UserId") String userId)
    {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
        
        try
        {
            String value = loginRepository.validateUser(daoutil.populateAddRetailerEnitity(objectMapper.readValue(identity, UserIdentity.class), appId, userId));
            System.out.println("Returned Value is: "+ value);
        }
        catch (Exception e)
        {
            String message = e.getMessage();
            if(Objects.nonNull(e.getCause()) && e instanceof InvalidDataAccessResourceUsageException && Objects.nonNull(e.getCause().getCause()))
            {
                message = e.getCause().getCause().getMessage();
            }
            responseEntity = new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
    
}
