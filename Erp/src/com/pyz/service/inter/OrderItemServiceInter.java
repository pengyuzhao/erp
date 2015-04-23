package com.pyz.service.inter;

import java.util.List;

import com.pyz.basic.BasicServiceInter;

public interface OrderItemServiceInter extends BasicServiceInter  {

	//加载子订单
	public List getOrderItem(int orderFormId);
	//删除子订单
	public void delOrderItem(String ids);
}
