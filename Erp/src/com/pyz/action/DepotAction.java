package com.pyz.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.pyz.domain.Depot;
import com.pyz.service.inter.DepotServiceInter;

import net.sf.json.JSONObject;
@Controller
public class DepotAction {

	private JSONObject result ;
	private int page ;
	private int row;
	private String ids;
	@Resource 
	private DepotServiceInter depotServiceImp;
	private Depot depot ;
	
	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	} 
	
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
	
	public DepotServiceInter getDepotServiceImp() {
		return depotServiceImp;
	}

	public void setDepotServiceImp(DepotServiceInter depotServiceImp) {
		this.depotServiceImp = depotServiceImp;
	}
	
	public Depot getDepot() {
		return depot;
	}

	public void setDepot(Depot depot) {
		this.depot = depot;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	//µÃµ½²Ö¿â
	public String getDepots(){
		
		if(page==0){
			
			page = 1;
		}
		if(row==0){
			
			row = 15;
		}
		List list = depotServiceImp.getDepot(page,row);
		Map map = new HashMap ();
		map.put("rows",list);
		map.put("total",depotServiceImp.getTotal());
		result = JSONObject.fromObject(map);
		return "success";
	}
	//Ìí¼Ó²Ö¿â
	public String addDepot(){
		depotServiceImp.add(depot);	
		return "success";
	}
	//ÐÞ¸Ä
	public String updateDepot(){
		depotServiceImp.update(depot);	
		return "success";
	}
	//É¾³ý
	public String delDepots(){
		
		depotServiceImp.delDepots(ids);
		return "success";
		
	}
	
}
