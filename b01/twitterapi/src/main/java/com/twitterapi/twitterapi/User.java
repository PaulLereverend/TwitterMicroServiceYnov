package com.twitterapi.twitterapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // This tells Hibernate to make a table out of this class
@JsonIgnoreProperties(value={ "password"}, allowSetters= true)
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;
  private String username;
  private String password;
  private String apikey;
  private String apikeysecret;
  private String accesstoken;
  private String accesstokensecret;
  

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return username;
  }

  public void setName(String name) {
    this.username = name;
  }
  public String getPassword() {
    return password;
  }


  public void setPassword(String password) {
    this.password = password;
  }
  public String getapikey() {
	return apikey;
 }

  public void setapikey(String apikey) {
	this.apikey = apikey;
  }
  public String getapikeysecret() {
		return apikeysecret;
	 }

  public void setapikeysecret(String apikeysecret) {
		this.apikeysecret = apikeysecret;
	  }
  public String getaccesstoken() {
	return accesstoken;
  }
  public void setaccesstoken(String accesstoken) {
    this.accesstoken = accesstoken;
 }
  public String getaccesstokensecret() {
	return accesstokensecret;
  }
  public void setaccesstokensecret(String accesstokensecret) {
    this.accesstokensecret = accesstokensecret;
 }
  

}

