package com.pyz.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pyz.basic.BasicServiceImp;
import com.pyz.domain.Admin;
import com.pyz.service.inter.AdminServiceInter;

@Service
public class AdminServiceImp extends BasicServiceImp implements AdminServiceInter {

	@Override
	public Admin checkUser(Admin admin) {
		// TODO Auto-generated method stub
		String hql = "from Admin where userName = ? and password= ?";
		Object[] parameters = {admin.getUserName(),admin.getPassword()};
		List list = this.executeQuery(hql, parameters);
		if(list.size()==0){
			return null ;
		}else{
			return (Admin)list.get(0); 

		}
	}

}
