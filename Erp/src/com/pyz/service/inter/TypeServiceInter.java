package com.pyz.service.inter;

import java.util.List;

import com.pyz.basic.BasicServiceInter;

public interface TypeServiceInter  extends BasicServiceInter{

	//�õ����е�����
	public List getTypes();
	public int getTotal();
	public void delTypes(String ids);
}
