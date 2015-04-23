package com.pyz.domain;

public class OrderItem {

	private String id ; 
	private Goods goods;
	private OrderForm orderform; 
	private int num; 
	private String remarks; 
	private Double sum;
	private Depot depot;
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
	public OrderForm getOrderform() {
		return orderform;
	}
	public void setOrderform(OrderForm orderform) {
		this.orderform = orderform;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public Depot getDepot() {
		return depot;
	}
	public void setDepot(Depot depot) {
		this.depot = depot;
	}
	
}
