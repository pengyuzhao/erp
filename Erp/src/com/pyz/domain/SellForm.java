package com.pyz.domain;

import java.util.Date;

public class SellForm {

	private String id ;
	private Goods goods;
	private Customer customer;
	private Double sum;
	private int num;
	private Date formData;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getFormData() {
		return formData;
	}
	public void setFormData(Date formData) {
		this.formData = formData;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
