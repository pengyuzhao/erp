package com.pyz.service.inter;

import java.util.List;

import com.pyz.basic.BasicServiceInter;

public interface ProviderServiceInter extends BasicServiceInter{

	public  List getProvider(int page,int row);
	public List getProvider();
	public int getTotal();
	public void delProviderId(String ids);
}
