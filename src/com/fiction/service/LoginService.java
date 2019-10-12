package com.fiction.service;

import java.util.List;

import com.fiction.dao.LoginDao;
import com.fiction.entity.AdminEntity;




public class LoginService {
	public boolean login(String adminName,String adminPwd){
		LoginDao ld = new LoginDao();
		AdminEntity admin = ld.login(adminName, adminPwd);
		boolean flag = true;
		if(admin.getAdminname()==null){
			flag=false;
		}
		return flag;
	}
	public List<AdminEntity> AllAdmin(String adminName){
		LoginDao ld = new LoginDao();
		return ld.AllAdmin(adminName);
	}
}
