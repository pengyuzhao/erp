package com.pyz.service.imp;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.pyz.basic.BasicServiceImp;
import com.pyz.domain.Customer;
import com.pyz.domain.Provider;
import com.pyz.service.inter.CustomerServiceInter;


@Service
public class CustomerServiceImp extends BasicServiceImp implements CustomerServiceInter {

	//得到客户信息
	public List getCustomer(int page,int rows) {
		// TODO Auto-generated method stub
		String hql = "from Customer";
		List<Customer> list =  this.executeQueryByPage(hql, null, page, rows);
		List l = new ArrayList();
		for(Customer c :list){
			JSONObject obj = new JSONObject();
			obj.put("id",c.getId());
			obj.put("name",c.getName());
			obj.put("phone",c.getPhone());
			obj.put("address",c.getAddress());
			l.add(obj);
		}
		return l;
	}

//得到总行数
	public int getTotal() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Customer";
		
		return Integer.parseInt(this.uniqueQuery(hql, null).toString());
	}

	@Override
	public void delCustomer(String ids) {
		// TODO Auto-generated method stub
		if(ids.contains(",")){
			String[] cids = ids.split(",");
			for(String id:cids){
				
				this.delById(Customer.class, id);
			}
		}else{
			this.delById(Customer.class, ids);
		}
		
	}
	
	public List getCustomer() {
		// TODO Auto-generated method stub
		String hql = "from Customer";
		List<Customer> list = this.executeQuery(hql, null);
		List<Customer> cList = new ArrayList<Customer>();
		for(Customer c: list){
			Customer c1 = new Customer();
			c1.setId(c.getId());
			c1.setName(c.getName());
			cList.add(c1);
		}
		 return cList;
	}

}
