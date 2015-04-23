package com.pyz.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pyz.basic.BasicServiceImp;
import com.pyz.domain.Depot;
import com.pyz.domain.Provider;

import com.pyz.service.inter.DepotServiceInter;

@Service
public class DepotServiceImp extends BasicServiceImp implements DepotServiceInter {

	@Override
	public List getDepot() {
		// TODO Auto-generated method stub
		String hql = "from Depot";
		List<Depot> list = this.executeQuery(hql, null);
		List<Depot> dList = new ArrayList<Depot>();
		for(Depot d: list){
			Depot d1 = new Depot();
			d1.setId(d.getId());
			d1.setName(d.getName());
			dList.add(d1);
		}

		return dList;
	}

	@Override
	public List getDepot(int page, int row) {
		// TODO Auto-generated method stub
		String hql = "from Depot";
		List<Depot> list = this.executeQueryByPage(hql, null, page, row);
		List<Depot> l = new ArrayList<Depot>();
		for(Depot d:list){
			Depot d1 = new Depot();
			d1.setAddress(d.getAddress());
			d1.setId(d.getId());
			d1.setManager(d.getManager());
			d1.setName(d.getName());
			l.add(d1);
		}
		return l;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Depot" ;
		return Integer.parseInt(this.uniqueQuery(hql, null).toString());
	}

	@Override
	public void delDepots(String ids) {
		// TODO Auto-generated method stub
		if(ids.contains(",")){
			for(String id :ids.split(",")){
				this.delById(Depot.class, id);
			}
		}else{
			this.delById(Depot.class, ids);
		}
	}

}
