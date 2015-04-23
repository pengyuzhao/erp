package com.pyz.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import net.sf.json.JSONObject;

import com.pyz.domain.Customer;
import com.pyz.domain.Goods;
import com.pyz.domain.SellForm;
import com.pyz.service.inter.GoodsServiceInter;

@Controller
public class SellAction {

	private int page; 
	private int row;
	private String goodsId;
	private String customerId;
	private JSONObject result ;
	private SellForm sellForm ;
	private String name ;
	private String type ;
	@Resource
	private GoodsServiceInter goodsServiceImp;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public JSONObject getResult() {
		return result;
	}
	
	
	public SellForm getSellForm() {
		return sellForm;
	}

	public void setSellForm(SellForm sellForm) {
		this.sellForm = sellForm;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public GoodsServiceInter getGoodsServiceImp() {
		return goodsServiceImp;
	}

	public void setGoodsServiceImp(GoodsServiceInter goodsServiceImp) {
		this.goodsServiceImp = goodsServiceImp;
	}
	
	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGoods(){
		
		if(page==0){
			page =1 ;
		}if(row==0){
			row=15;
		}
		List list = goodsServiceImp.getGoods(page, row, name, type);
		Map map = new HashMap();
		map.put("rows",list);
		map.put("total",goodsServiceImp.getTotal(name,type));
		result = JSONObject.fromObject(map);
		this.setName("");
		this.setType("");
		return "success";
	}
	
	public String addSellForm(){
		
		Customer c=(Customer) goodsServiceImp.findById(Customer.class,customerId);
		Goods g = (Goods) goodsServiceImp.findById(Goods.class, goodsId);
		sellForm.setFormData(new Date());
		sellForm.setCustomer(c);
		sellForm.setGoods(g);
		g.setNum(g.getNum()-sellForm.getNum());
		goodsServiceImp.update(g);
		goodsServiceImp.add(sellForm);
		return "success";
	}
	
}
