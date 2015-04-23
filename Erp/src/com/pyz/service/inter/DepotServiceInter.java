package com.pyz.service.inter;

import java.util.List;

import com.pyz.basic.BasicServiceInter;

public interface DepotServiceInter extends BasicServiceInter{

	public List getDepot(); //得到仓库

	public List getDepot(int page, int row);
	
	public int getTotal(); //得到总的数量
	
	public void delDepots(String ids); //删除
	
}
