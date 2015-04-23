package com.pyz.service.inter;

import java.util.List;

import com.pyz.basic.BasicServiceInter;

public interface GoodsServiceInter extends BasicServiceInter{

	//得到商品
	public List getGoods(int providerId);
	//得到商品信息 根据id
	public List getGoodsInfo(int goodsId);
	
	public List getGoods(int page, int row,String depotId);
	public List getGoods(int page, int row,String name ,String type);
	public int  getTotal(String depotId);
	public int  getTotal(String name,String type);

	//删除
	public void delGoods(String ids);
	
}
