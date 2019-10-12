package com.fiction.service;

import java.util.List;

import com.fiction.dao.UserDao;
import com.fiction.entity.UserEntity;

public class UserService {
	UserDao ud = new UserDao();
	public List<UserEntity> getAlluser(int page){
		return ud.getAlluser(page);
	}
	public int getcount(){
		return ud.getcount();
	}
	public List<UserEntity> getLikeuser(int page,String name){
		return ud.getLikeuser(name,page);
	}
	public int getLikecount(String name){
		return ud.getLikeCount(name);
	}
	public void deleteuser(int user_id){
		ud.deleteuser(user_id);
	}
	public void datalluser(String[] ids){
		if(ids!=null){
			for(String i:ids){
				int id =Integer.parseInt(i);
				ud.deleteuser(id);
			}
		}
	}
}
