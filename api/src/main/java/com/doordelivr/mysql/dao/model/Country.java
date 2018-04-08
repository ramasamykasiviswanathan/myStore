package com.doordelivr.mysql.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name="country")
public class Country implements Serializable {

  private static final long serialVersionUID = 9090507626324795324L;
  
  private Long id;
  private String iso;
  private String name;
  private String niceName;
  private String iso3;
  private Integer numCode;
  private Long phoneCode;
  
  @Id
  @Column(nullable = false, unique = true)
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getIso() {
    return iso;
  }
  
  public void setIso(String iso) {
    this.iso = iso;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "nicename")
  public String getNiceName() {
    return niceName;
  }

  public void setNiceName(String niceName) {
    this.niceName = niceName;
  }
  
  public String getIso3() {
    return iso3;
  }
  
  public void setIso3(String iso3) {
    this.iso3 = iso3;
  }
  
  @Column(name = "numcode")
  public Integer getNumCode() {
    return numCode;
  }

  public void setNumCode(Integer numCode) {
    this.numCode = numCode;
  }

  @Column(name = "phonecode")
  public Long getPhoneCode() {
    return phoneCode;
  }

  public void setPhoneCode(Long phoneCode) {
    this.phoneCode = phoneCode;
  }

  @Override
  public String toString() {
      return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }
}
