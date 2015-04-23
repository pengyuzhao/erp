package com.pyz.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import net.sf.json.JSONArray;

import com.pyz.domain.Nav;
import com.pyz.service.inter.NavServiceInter;
@Controller
public class IndexAction {

	private int id ;
	// ���ؽ�����ͻ���
    private List result = new ArrayList();
	@Resource
	private NavServiceInter navServiceImp;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public List getResult() {
		return result;
	}

	public void setResult(List result) {
		this.result = result;
	}

	public NavServiceInter getNavServiceImp() {
		return navServiceImp;
	}

	public void setNavServiceImp(NavServiceInter navServiceImp) {
		this.navServiceImp = navServiceImp;
	}

	//���ز˵�
	public String getNav(){
		
		
		List<Nav> list = navServiceImp.getNav(id);
		result = list;
		this.id=0;
		return "success";
	}
	//��ת
	public String goProvider(){
		return "provider";
	}
	public String goCustomer(){
		return "customer";
	}
	public String goProcurement(){
		return "procurement";
	}
	public String goDepot(){
		return "depot";
	}
	public String goSell(){
		return "sell";
	}
	public String goType(){
		return "type";
	}
}
