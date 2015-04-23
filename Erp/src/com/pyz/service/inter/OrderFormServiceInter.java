package com.pyz.service.inter;

import java.util.List;

import com.pyz.basic.BasicServiceInter;

public interface OrderFormServiceInter extends BasicServiceInter  {

	//得到票号
	public List getOrderFormId();
	//得到订单
	public List getOrderForm();
	//得到总页数
	public int getOrderFormTotal();
	public void delOrderForm(String ids);
}
