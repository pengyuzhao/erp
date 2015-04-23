package com.pyz.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.pyz.domain.Depot;
import com.pyz.domain.Goods;
import com.pyz.domain.Type;
import com.pyz.service.inter.GoodsServiceInter;
import com.pyz.service.inter.TypeServiceInter;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@Controller
public class DepotGoodsAction {

	private JSONObject result;
	private int row;
	private int page;
	private String depotId;
	private Goods dg;
	private String typeId ;
	private String goodsId;
	private String ids;
	@Resource
	private GoodsServiceInter goodsServiceImp;
	
	public JSONObject getResult() {
		return result;
	}
	public void setResult(JSONObject result) {
		this.result = result;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getDepotId() {
		return depotId;
	}
	public void setDepotId(String depotId) {
		this.depotId = depotId;
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
	public Goods getDg() {
		return dg;
	}
	public void setDg(Goods dg) {
		this.dg = dg;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	//展示商品
	public String getDepotGoods(){
		
		if(depotId!=null){
			if(page == 0){
				
				page = 1 ;
			}if(row == 0){
				
				row=15;
			}
			List list = goodsServiceImp.getGoods(page ,row,depotId);
			Map map = new HashMap();
			map.put("rows",list);
			map.put("total",goodsServiceImp.getTotal(depotId));
			result = JSONObject.fromObject(map);	
		}
		return "success";
	}
	
	
	//添加商品
	public String addDepotGoods(){
		
		Depot d =(Depot) goodsServiceImp.findById(Depot.class, depotId);
		Type t = (Type) goodsServiceImp.findById(Type.class, typeId);
		dg.setDepot(d);
		dg.setType(t);
		goodsServiceImp.add(dg);
		return "success";
	}
	
	//改变仓库
	public String updateDepot(){
		
		Goods goods = (Goods) goodsServiceImp.findById(Goods.class,goodsId);
		goods.setDepot((Depot)goodsServiceImp.findById(Depot.class, depotId));
		goodsServiceImp.update(goods);
		return "success";
	}
	
	//删除商品
	public String delGoods(){
		goodsServiceImp.delGoods(ids);
		return "success";
	}
	//保存商品
		public String updateDepotGoods(){
		
			goodsServiceImp.update(dg);
			return "success";
		}
	
	
	
}
