package com.pyz.service.inter;

import com.pyz.basic.BasicServiceInter;
import com.pyz.domain.Admin;

public interface AdminServiceInter extends BasicServiceInter {

	 //检查用户名是否正确
	public Admin checkUser(Admin admin);
}
