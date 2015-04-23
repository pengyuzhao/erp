package com.pyz.domain;

import java.util.HashSet;
import java.util.Set;

public class Goods {

	private String id; 
	private String name; 
	private Double price;
	private Type type;
	private int num;
	private Depot depot;
	private Provider provider;
	private Set<OrderItem> orderItems = new HashSet<OrderItem>(0);
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Depot getDepot() {
		return depot;
	}
	public void setDepot(Depot depot) {
		this.depot = depot;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Set<SellForm> getSellForms() {
		return sellForms;
	}
	public void setSellForms(Set<SellForm> sellForms) {
		this.sellForms = sellForms;
	}	
	
}
