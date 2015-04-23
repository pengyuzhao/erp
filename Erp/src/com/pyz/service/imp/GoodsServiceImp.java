package com.pyz.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.pyz.basic.BasicServiceImp;
import com.pyz.domain.Depot;
import com.pyz.domain.Goods;
import com.pyz.service.inter.GoodsServiceInter;

@Service
public class GoodsServiceImp extends BasicServiceImp implements GoodsServiceInter {

	//得到商品
	public List getGoods(int providerId) {
		// TODO Auto-generated method stub
		String hql = "from Goods where provider.id=?";
		Object[] parameters = {providerId+""};
		List<Goods> list = this.executeQuery(hql, parameters);
		List<Goods> gList = new ArrayList<Goods>();
		for(Goods g: list){
			Goods g1 = new Goods();
			g1.setId(g.getId());
			g1.setName(g.getName());
			g1.setPrice(g.getPrice());
			gList.add(g1);
		}
		return gList;
	}

	//根据商品id得到其他信息

	public List getGoodsInfo(int goodsId) {
		// TODO Auto-generated method stub
		String hql ="from Goods where id = ?";
		Object[] parameters = {goodsId+""};
		Goods g = (Goods) this.uniqueQuery(hql, parameters);
		Map map = new HashMap();
		map.put("type",g.getType().getName());
		map.put("price",g.getPrice());
		List list =JSONArray.fromObject(map);
		return list;
	}

	@Override
	public List getGoods(int page, int row ,String depotId) {
		// TODO Auto-generated method stub
		String hql =" from Goods g where g.depot.id = ?";
		Object[] parameters = {depotId};
		List<Goods> list =this.executeQueryByPage(hql, parameters, page, row);
		List l = new ArrayList();
		
		for(Goods g:list){
			JSONObject obj = new JSONObject();
			obj.put("id", g.getId());
			obj.put("price", g.getPrice());
			obj.put("name", g.getName());
			obj.put("num", g.getNum());
			obj.put("type", g.getType().getName());
			obj.put("depot", g.getDepot().getName());
			l.add(obj);
		}
		return l;
	}

	@Override
	public int getTotal(String depotId) {
		// TODO Auto-generated method stub
		String hql =" select count(*) from Goods g where g.depot.id = ?";
		Object[] parameters = {depotId};
		return Integer.parseInt(this.uniqueQuery(hql, parameters).toString());
	}

	@Override
	public void delGoods(String ids) {
		// TODO Auto-generated method stub
		if(ids.contains(",")){
			for(String id:ids.split(",")){
				this.delById(Goods.class, id);
			}
		}else{
			
			this.delById(Goods.class, ids);
		}
		
	}

	@Override
	public List getGoods(int page, int row,String name ,String type) {
		// TODO Auto-generated method stub
		String hql ="from Goods g where g.num>? and";
		ArrayList parameters= new ArrayList();
		parameters.add(0);
		if(name!=null&&!name.equals("")){
			hql = hql+" g.name like ? and";
			parameters.add("%"+name+"%");
		}
		if(type!=null&&!type.equals("")){
			hql = hql+" g.type.name like ?";
			parameters.add("%"+type+"%");
		}
		if(hql.endsWith("and")){
			hql = hql.substring(0, hql.length()-3);
		}

		List<Goods> list =this.executeQueryByPage(hql, parameters.toArray(), page, row);
		List l = new ArrayList();
		for(Goods g:list){
			JSONObject obj = new JSONObject();
			obj.put("id", g.getId());
			obj.put("price", g.getPrice());
			obj.put("name", g.getName());
			obj.put("num", g.getNum());
			obj.put("type",g.getType().getName());
			l.add(obj);
		}

		return l;
	}

	@Override
	public int getTotal(String name ,String type) {
		// TODO Auto-generated method stub
		String hql =" select count(*) from Goods g where g.num >? and";
		ArrayList parameters= new ArrayList();
		parameters.add(0);
		if(name!=null&&!name.equals("")){
			hql = hql+" g.name like ? and";
			parameters.add("%"+name+"%");
		}
		if(type!=null&&!type.equals("")){
			hql = hql+" g.type.name like ?";
			parameters.add("%"+type+"%");
		}
		if(hql.endsWith("and")){
			hql = hql.substring(0, hql.length()-3);
		}
		return Integer.parseInt(this.uniqueQuery(hql, parameters.toArray()).toString());
	}



}
