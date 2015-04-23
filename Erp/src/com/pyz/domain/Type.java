package com.pyz.domain;

import java.util.HashSet;
import java.util.Set;

public class Type {

	private String id ; 
	private String name ; 
	private Set<Goods> goods =new HashSet<Goods>(0);
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
	public Set<Goods> getGoods() {
		return goods;
	}
	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}
	
}
