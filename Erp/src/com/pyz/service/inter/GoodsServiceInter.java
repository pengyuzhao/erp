package com.pyz.service.inter;

import java.util.List;

import com.pyz.basic.BasicServiceInter;

public interface GoodsServiceInter extends BasicServiceInter{

	//�õ���Ʒ
	public List getGoods(int providerId);
	//�õ���Ʒ��Ϣ ����id
	public List getGoodsInfo(int goodsId);
	
	public List getGoods(int page, int row,String depotId);
	public List getGoods(int page, int row,String name ,String type);
	public int  getTotal(String depotId);
	public int  getTotal(String name,String type);

	//ɾ��
	public void delGoods(String ids);
	
}
