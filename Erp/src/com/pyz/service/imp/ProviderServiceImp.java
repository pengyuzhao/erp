package com.pyz.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pyz.basic.BasicServiceImp;
import com.pyz.basic.BasicServiceInter;
import com.pyz.domain.Provider;
import com.pyz.service.inter.ProviderServiceInter;
@Service
public class ProviderServiceImp  extends BasicServiceImp implements ProviderServiceInter{

	
	public List getProvider(int page,int row) {
		// TODO Auto-generated method stub
		String hql = "from Provider";
		List<Provider> list = this.executeQueryByPage(hql, null, page, row);
		List l= new ArrayList();
		for(Provider p:list){
			Provider p1 = new Provider();
			p1.setId(p.getId());
			p1.setAddress(p.getAddress());
			p1.setName(p.getName());
			p1.setPhone(p.getPhone());
			l.add(p1);
		 }
		
		return l;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Provider";
		return Integer.parseInt(this.uniqueQuery(hql, null).toString());
	}

	@Override
	public void delProviderId(String ids) {
		// TODO Auto-generated method stub
		if(ids.contains(",")){
			String[] pids = ids.split(",");
			for(String id:pids){
				
				this.delById(Provider.class, id);
			}
		}else{
			this.delById(Provider.class, ids);
		}
		
	}

	@Override
	public List getProvider() {
		// TODO Auto-generated method stub
		String hql = "from Provider";
		List<Provider> list = this.executeQuery(hql, null);
		List<Provider> pList = new ArrayList<Provider>();
		for(Provider p: list){
			Provider p1 = new Provider();
			p1.setId(p.getId());
			p1.setName(p.getName());
			pList.add(p1);
		}
		 return pList;
	}

	
}
