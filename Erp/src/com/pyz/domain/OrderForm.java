package com.pyz.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderForm {

	private String id ; 
	private String handler;
	private Date orderDate;
	private String state;
	private Set<OrderItem> orderItems = new HashSet<OrderItem>(0);
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHandler() {
		return handler;
	}
	public void setHandler(String handler) {
		this.handler = handler;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	} 
	
}
