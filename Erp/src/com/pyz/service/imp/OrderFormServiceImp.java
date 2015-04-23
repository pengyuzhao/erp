package com.pyz.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Service;

import com.pyz.basic.BasicServiceImp;
import com.pyz.domain.OrderForm;
import com.pyz.service.inter.OrderFormServiceInter;

@Service
public class OrderFormServiceImp extends BasicServiceImp implements OrderFormServiceInter{

	
	public List getOrderFormId() {
		// TODO Auto-generated method stub
		String hql ="select max(id) from OrderForm";
		List list = this.executeQuery(hql, null);
		return list;

		
	}

	@Override
	public List getOrderForm() {
		// TODO Auto-generated method stub

		String hql ="from OrderForm";
		List<OrderForm> list = this.executeQuery(hql, null);
		List<OrderForm> orderFormList = new ArrayList();
		for(OrderForm o : list){
			OrderForm o1 = new OrderForm();
			o1.setHandler(o.getHandler());
			o1.setId(o.getId());
			o1.setState(o.getState());
			o1.setOrderDate(o.getOrderDate());
			orderFormList.add(o1);
			}
	
		return orderFormList;
	}


	public int getOrderFormTotal() {
		// TODO Auto-generated method stub
		String hql ="select count(*) from OrderForm";
		
		return Integer.parseInt(this.uniqueQuery(hql, null).toString());
	}

	@Override
	public void delOrderForm(String ids) {
		// TODO Auto-generated method stub
		
		if(ids.contains(",")){
			for(String id :ids.split(",")){
				this.delById(OrderForm.class, id);
			}
		}else{
			this.delById(OrderForm.class, ids);
		}
		
	}

	
}
