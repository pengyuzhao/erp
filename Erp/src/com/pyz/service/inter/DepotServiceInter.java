package com.pyz.service.inter;

import java.util.List;

import com.pyz.basic.BasicServiceInter;

public interface DepotServiceInter extends BasicServiceInter{

	public List getDepot(); //�õ��ֿ�

	public List getDepot(int page, int row);
	
	public int getTotal(); //�õ��ܵ�����
	
	public void delDepots(String ids); //ɾ��
	
}
