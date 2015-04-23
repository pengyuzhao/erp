package com.pyz.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pyz.basic.BasicServiceImp;
import com.pyz.domain.OrderItem;
import com.pyz.service.inter.OrderItemServiceInter;

@Service
public class OrderItemServiceImp extends BasicServiceImp implements OrderItemServiceInter{


	public List getOrderItem(int orderFormId) {
		// TODO Auto-generated method stub
		String hql ="from OrderItem o where o.orderform.id = ?" ;
		Object[] parameters ={orderFormId+""};
		List<OrderItem> list = this.executeQuery(hql, parameters);
		Map map = new HashMap();
		List l = new ArrayList();
		for(OrderItem orderItem:list){
			map.put("id",orderItem.getId());
			map.put("type",orderItem.getGoods().getType().getName());
			map.put("goodsName",orderItem.getGoods().getName());
			map.put("sum", orderItem.getSum());
			map.put("remarks",orderItem.getRemarks());
			map.put("num",orderItem.getNum());
			l.add(map);
		}
		return l;
	}

	@Override
	public void delOrderItem(String ids) {
		// TODO Auto-generated method stub
		if (ids.contains(",")) {
			
			for(String id :ids.split(",")){
				this.delById(OrderItem.class,id);
			}
		}else{
			this.delById(OrderItem.class, ids);
		}
		
	}

	
}
