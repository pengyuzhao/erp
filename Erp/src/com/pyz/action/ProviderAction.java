package com.pyz.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.pyz.domain.Provider;
import com.pyz.service.inter.ProviderServiceInter;
@Controller
public class ProviderAction {

	private JSONObject result;//返回的json  
	@Resource
	private ProviderServiceInter providerServiceImp;
	private Provider pro;
	private String ids;
	private int rows;
	private int page;
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public ProviderServiceInter getProviderServiceImp() {
		return providerServiceImp;
	}

	public void setProviderServiceImp(ProviderServiceInter providerServiceImp) {
		this.providerServiceImp = providerServiceImp;
	}

	
	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}
	public Provider getPro() {
		return pro;
	}
	public void setPro(Provider pro) {
		this.pro = pro;
	}

	//得到数据
	public String getProvider(){
		
		if(page==0){
			page=1;
		}
		if(rows==0){
			rows=15;
		}
		List list = providerServiceImp.getProvider(page,rows);
		Map map = new HashMap();
		map.put("rows",list);
		map.put("total",providerServiceImp.getTotal());
		result=JSONObject.fromObject(map);
		return "success";	
	}
	//删除
	public String delProvider(){
		
			providerServiceImp.delProviderId(ids);
			return null;
	}
	//添加
	public String addProvider() throws IOException {
		
			providerServiceImp.add(pro);
			ServletActionContext.getResponse().getWriter().print(1);
			return null;
	}
	//修改
	public String updateProvider(){
		
		try {
			providerServiceImp.update(pro);
			ServletActionContext.getResponse().getWriter().print(1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
		
	}
}
