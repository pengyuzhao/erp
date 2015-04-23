package com.pyz.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.pyz.domain.Type;
import com.pyz.service.inter.TypeServiceInter;

import net.sf.json.JSONObject;
@Controller
public class TypeAction {

	private JSONObject result ;
	private int page; 
	private int row;
	private String ids ;
	private Type t ;
	@Resource
	private TypeServiceInter typeServiceImp;
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
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public TypeServiceInter getTypeServiceImp() {
		return typeServiceImp;
	}

	public void setTypeServiceImp(TypeServiceInter typeServiceImp) {
		this.typeServiceImp = typeServiceImp;
	}

	
	public Type getT() {
		return t;
	}

	public void setT(Type t) {
		this.t = t;
	}

	public String getType(){
		if(page==0){
			page = 1;
		}if(row ==0){
			row =15;
		}
		List list = typeServiceImp.getTypes();
		Map map = new HashMap();
		map.put("rows", list);
		map.put("total" ,typeServiceImp.getTotal());
		result = JSONObject.fromObject(map);
		
		return "success";
	}
	
	public String delType(){
		
		typeServiceImp.delTypes(ids);
		return "success";
	}
	
	public String addType(){
		
		typeServiceImp.add(t);
		return "success";
	}
	

	public String updateType(){
		
		Type type = (Type) typeServiceImp.findById(Type.class,t.getId());
		type.setName(t.getName());
		typeServiceImp.update(type);
		return "success";
	}
}
