package com.xas.common.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "useraddress")
public class Address implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4130175183431985755L;

	@Id
	//@GenericGenerator(name="kaugen" , strategy="increment")
	//@GeneratedValue(generator="kaugen")
	@Column(name="addressId",nullable=false)
	private Integer addressId;
	
	@Column(name="userId",nullable=false)
	private Integer userId;
	
	
	@Column(name="city",nullable=true)
	private String city;
	
	
	@Column(name="country",nullable=true)
	private String country;
	
	
	@Column(name="district",nullable=true)
	private String district;
	
	@Column(name="full_address",nullable=true)
	private String full_address;
	
	
	@Column(name="address_desc",nullable=true)
	private String address_desc;


	public Integer getAddressId() {
		return addressId;
	}


	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getFull_address() {
		return full_address;
	}


	public void setFull_address(String full_address) {
		this.full_address = full_address;
	}


	public String getAddress_desc() {
		return address_desc;
	}


	public void setAddress_desc(String address_desc) {
		this.address_desc = address_desc;
	}
	
	
	
	
	
	
}
