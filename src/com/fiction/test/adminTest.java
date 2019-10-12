package com.fiction.test;

import java.util.List;

import com.fiction.dao.AdminDao;
import com.fiction.dao.UserDao;
import com.fiction.entity.AdminEntity;
import com.fiction.entity.UserEntity;

public abstract class adminTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDao ad = new UserDao();
		//System.out.println(ad.editadmin(15,"wan", "333123", "3241@qq.com", "Ů", "1231234223", "2013-3-3"));
		List<UserEntity> list =ad.getLikeuser("a", 1);
		for(UserEntity user:list){
			System.out.println(user.getUserid());
		}
	
	}

}
