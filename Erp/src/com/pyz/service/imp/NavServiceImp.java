package com.pyz.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pyz.basic.BasicServiceImp;
import com.pyz.service.inter.NavServiceInter;

@Service
public class NavServiceImp extends BasicServiceImp implements NavServiceInter {

	//²éÑ¯Ä¿Â¼
	public List getNav(int id) {
			// TODO Auto-generated method stub
			String hql = "from Nav where tid=?";
			Object[] parameters ={id+""};
			return this.executeQuery(hql, parameters);

	}

	
}
