package com.pyz.service.inter;

import java.util.List;

import com.pyz.basic.BasicServiceInter;

public interface OrderFormServiceInter extends BasicServiceInter  {

	//�õ�Ʊ��
	public List getOrderFormId();
	//�õ�����
	public List getOrderForm();
	//�õ���ҳ��
	public int getOrderFormTotal();
	public void delOrderForm(String ids);
}
