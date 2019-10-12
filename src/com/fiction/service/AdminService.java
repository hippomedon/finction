package com.fiction.service;

import java.util.List;

import com.fiction.dao.AdminDao;
import com.fiction.entity.AdminEntity;

public class AdminService {
	AdminDao ad = new AdminDao();
	public List<AdminEntity> getAlladmin(int page){
		return ad.getAlladmin((page-1)*10);
	}
	public int getcount(){
		return ad.getcount();
	}
	public void deleteadmin(int admin_id){
		ad.deleteadmin(admin_id);
	}
	public List<AdminEntity> getLikeadmin(int page,String name){
		return ad.getLikeadmin(name, (page-1)*10);
	}
	public int getlikecount(String name){
		return ad.getLikeCount(name);
	}
	public void datall(String[] ids){
		if(ids!=null){
		for(String i:ids){
			int id =Integer.parseInt(i);
			ad.deleteadmin(id);
		}
		}
	}
	public void addadmin(String name,String pwd,String email,String gender,String phone,String time){
		ad.addadmin(name, pwd, email, gender, phone, time);
	}
	public void editadmin(int id,String name,String pwd,String email,String gender,String phone,String time){
		ad.editadmin(id,name, pwd, email, gender, phone, time);
	}
	
}
