package com.doordelivr.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.doordelivr.mysql.dao.crudrepository.CountryRepository;
import com.doordelivr.mysql.dao.model.Country;
import com.doordelivr.util.DaoUtil;
import com.doordelivr.util.DtoUtil;

@RestController()
public class LoginController {

  @Autowired
  private DaoUtil daoutil;

  @Autowired
  private DtoUtil dtoUtil;

  @Autowired
  private LoginRepository loginRepository;
  
  @Autowired
  private CountryRepository countryRepository;

  @PostMapping(path = "/Login")
  public ResponseEntity<LoginResponseModel> login(@RequestBody UserIdentity identity, @RequestHeader(value = "AppId") String appId) {
    ResponseEntity<LoginResponseModel> responseEntity = null;
    
    try {
      String value = loginRepository.user(daoutil.populateLoginEnitity(identity, appId));
      responseEntity = new ResponseEntity<>(dtoUtil.populateLoginResponse(value), HttpStatus.OK);
    } catch (Exception e) {
      LoginResponseModel loginResponseModel = new LoginResponseModel();
      loginResponseModel.setErrorModel(dtoUtil.populateErrorModel(e));
      responseEntity = new ResponseEntity<>(loginResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    return responseEntity;
  }

  @PostMapping(path = "/ForgotPassword")
  public ResponseEntity<ForgotPasswordResponseModel> forgotPassword(@RequestBody UserIdentity identity, @RequestHeader(value = "AppId") String appId) {
    ResponseEntity<ForgotPasswordResponseModel> responseEntity = null;
    ForgotPasswordResponseModel forgotPasswordResponseModel = new ForgotPasswordResponseModel();
    
    try {
      forgotPasswordResponseModel
          .setMessage(loginRepository.user(daoutil.populateForgotPasswordEnitity(identity, appId)));
      responseEntity = new ResponseEntity<>(forgotPasswordResponseModel, HttpStatus.OK);
    } catch (Exception e) {
      forgotPasswordResponseModel.setErrorModel(dtoUtil.populateErrorModel(e));
      responseEntity = new ResponseEntity<>(forgotPasswordResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    return responseEntity;
  }

  @PostMapping(path = "/ChangePassword")
  public ResponseEntity<ChangePasswordResponseModel> changePassword(@RequestBody UserIdentity identity, @RequestHeader(value = "AppId") 
         String appId, @RequestHeader(value = "UserId", required = false) String userId) {
    ResponseEntity<ChangePasswordResponseModel> responseEntity = null;
    ChangePasswordResponseModel changePasswordResponseModel = new ChangePasswordResponseModel();
    
    try {
      changePasswordResponseModel.setMessage(loginRepository.user(daoutil.populateChangePasswordEnitity(identity, appId, userId)));
      responseEntity = new ResponseEntity<>(changePasswordResponseModel, HttpStatus.OK);
    } catch (Exception e) {
      changePasswordResponseModel.setErrorModel(dtoUtil.populateErrorModel(e));
      responseEntity = new ResponseEntity<>(changePasswordResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    return responseEntity;
  }

  @PostMapping(path = "/SignupUser")
  public ResponseEntity<SignupUserResponseModel> signupUser(@RequestBody UserIdentity identity, @RequestHeader(value = "AppId") String appId) {
    ResponseEntity<SignupUserResponseModel> responseEntity = null;
    SignupUserResponseModel signupUserResponseModel = new SignupUserResponseModel();
    
    try {
      signupUserResponseModel.setMessage(loginRepository.user(daoutil.populateSignupUserEnitity(identity, appId)));
      responseEntity = new ResponseEntity<>(signupUserResponseModel, HttpStatus.OK);
    } catch (Exception e) {
      signupUserResponseModel.setErrorModel(dtoUtil.populateErrorModel(e));
      responseEntity = new ResponseEntity<>(signupUserResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return responseEntity;
  }

  @GetMapping(path = "/ShowShops")
  public ResponseEntity<ShowShopsResponseModel> showShops(@RequestHeader(value = "AppId") String appId, @RequestHeader(value = "UserId") String userId) {
    ResponseEntity<ShowShopsResponseModel> responseEntity = null;
    ShowShopsResponseModel shopsResponseModel = new ShowShopsResponseModel();
    
    try {
      Object value = loginRepository.shops(daoutil.populateShowShopsEnitity(appId, userId));
      
      Arrays.stream((Object[]) value).map(String::valueOf).map(StringUtils::trimToNull).reduce((x, y) -> x + "," + y)
          .map(dtoUtil::populateShopInformationModel).filter(Objects::nonNull).ifPresent(s -> {
            List<ShopInformationModel> shopInformations = Arrays.asList(s);
            shopsResponseModel.setShopInformationModels(shopInformations.isEmpty() ? null : shopInformations);
          });

      responseEntity = new ResponseEntity<>(shopsResponseModel, HttpStatus.OK);
    } catch (Exception e) {
      shopsResponseModel.setErrorModel(dtoUtil.populateErrorModel(e));
      responseEntity = new ResponseEntity<>(shopsResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    return responseEntity;
  }

  @PostMapping(path = "/AddRetailer")
  public ResponseEntity<AddRetailerResponseModel> addRetailer(@RequestBody UserIdentity identity, @RequestHeader(value = "AppId") String appId, @RequestHeader(value = "UserId") String userId) {
    ResponseEntity<AddRetailerResponseModel> responseEntity = null;
    AddRetailerResponseModel addRetailerResponseModel = new AddRetailerResponseModel();
    
    try {
      addRetailerResponseModel.setMessage(loginRepository.user(daoutil.populateAddRetailerEnitity(identity, appId, userId)));
      responseEntity = new ResponseEntity<>(addRetailerResponseModel, HttpStatus.OK);
    } catch (Exception e) {
      addRetailerResponseModel.setErrorModel(dtoUtil.populateErrorModel(e));
      responseEntity = new ResponseEntity<>(addRetailerResponseModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    return responseEntity;
  }
  
  @GetMapping(path = "/Country")
  public ResponseEntity<List<Country>> getCountry(@RequestHeader(value = "UserId", required = false) String userId, @RequestHeader(value = "AppId") String appId) {
    ResponseEntity<List<Country>> responseEntity = null;
    
    try {
      responseEntity = new ResponseEntity<>(countryRepository.findAllByOrderByNiceNameAsc(), HttpStatus.OK);
    } catch (Exception e) {
      responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    return responseEntity;
  }
}
