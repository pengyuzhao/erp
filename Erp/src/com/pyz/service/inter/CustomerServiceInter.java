package com.pyz.service.inter;

import java.util.List;

import com.pyz.basic.BasicServiceInter;

public interface CustomerServiceInter extends BasicServiceInter {

	//得到所要的客户信息
	public List getCustomer(int page,int rows);
	//得到总行数
	public int getTotal();
	//删除
	public void delCustomer(String ids);
	public List getCustomer();
}
