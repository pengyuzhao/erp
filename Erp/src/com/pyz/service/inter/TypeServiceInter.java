package com.pyz.service.inter;

import java.util.List;

import com.pyz.basic.BasicServiceInter;

public interface TypeServiceInter  extends BasicServiceInter{

	//得到所有的类型
	public List getTypes();
	public int getTotal();
	public void delTypes(String ids);
}
