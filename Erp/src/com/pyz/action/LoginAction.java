package com.pyz.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.pyz.domain.Admin;
import com.pyz.service.inter.AdminServiceInter;

@Controller
public class LoginAction{

	private Admin admin;
	@Resource
	private AdminServiceInter adminServiceImp;
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public void setAdminServiceImp(AdminServiceInter adminServiceImp) {
		this.adminServiceImp = adminServiceImp;
	}
	
	public String login(){
		
		try {
			
			admin = adminServiceImp.checkUser(admin); //用户名校验
			HttpServletResponse response= ServletActionContext.getResponse();
			ActionContext.getContext().getSession().put("admin",admin);
			if(admin!=null){
				response.getWriter().print(1);
			}else{
				response.getWriter().print(0);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null ;
	}
	
	public String goToIndex(){
		return "index";
	}
	
	public String loginOut(){
		
		return "login" ;
	}
}
