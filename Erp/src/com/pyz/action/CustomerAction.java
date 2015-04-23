package com.pyz.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.pyz.domain.Customer;
import com.pyz.service.inter.CustomerServiceInter;

@Controller
public class CustomerAction {

	private JSONObject result;
	@Resource
	private CustomerServiceInter customerServiceImp;
	private int page;
	private int rows;
	private String ids;
	private Customer cus;
	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
	
	
	public CustomerServiceInter getCustomerServiceImp() {
		return customerServiceImp;
	}

	public void setCustomerServiceImp(CustomerServiceInter customerServiceImp) {
		this.customerServiceImp = customerServiceImp;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}

	//得到客服信息
	public String getCustomer(){
		
		if(rows==0){
			rows=15;
		}
		if(page==0){
			page=1;
		}
		List list = customerServiceImp.getCustomer(page, rows);
		int total = customerServiceImp.getTotal();
		Map map = new HashMap();
		map.put("rows", list);
		map.put("total",total);
		result= JSONObject.fromObject(map);
		return "success";	
	}
	//删除
	public String delCustomer(){
		
		customerServiceImp.delCustomer(ids);
		return null;
	}
	//添加
	public String addCustomer() throws IOException{
		customerServiceImp.add(cus);
		ServletActionContext.getResponse().getWriter().print(1);
		return null;
	}
	
	//修改
	public String updateCustomer() throws IOException{
		customerServiceImp.update(cus);
		ServletActionContext.getResponse().getWriter().print(1);
		return null;
	}
	
}
