package com.pyz.service.inter;

import java.util.List;

import com.pyz.basic.BasicServiceInter;

public interface OrderItemServiceInter extends BasicServiceInter  {

	//�����Ӷ���
	public List getOrderItem(int orderFormId);
	//ɾ���Ӷ���
	public void delOrderItem(String ids);
}
