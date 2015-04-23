package com.pyz.domain;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	
	private String id ;
	private String name;
	private String address;
	private String phone;
	private Set<SellForm> sellForms = new HashSet<SellForm>(0);
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Set<SellForm> getSellForms() {
		return sellForms;
	}
	public void setSellForms(Set<SellForm> sellForms) {
		this.sellForms = sellForms;
	}
	
}
