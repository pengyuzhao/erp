package com.pyz.service.inter;

import com.pyz.basic.BasicServiceInter;
import com.pyz.domain.Admin;

public interface AdminServiceInter extends BasicServiceInter {

	 //����û����Ƿ���ȷ
	public Admin checkUser(Admin admin);
}
