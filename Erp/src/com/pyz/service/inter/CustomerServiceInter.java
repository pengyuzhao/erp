package com.pyz.service.inter;

import java.util.List;

import com.pyz.basic.BasicServiceInter;

public interface CustomerServiceInter extends BasicServiceInter {

	//�õ���Ҫ�Ŀͻ���Ϣ
	public List getCustomer(int page,int rows);
	//�õ�������
	public int getTotal();
	//ɾ��
	public void delCustomer(String ids);
	public List getCustomer();
}
