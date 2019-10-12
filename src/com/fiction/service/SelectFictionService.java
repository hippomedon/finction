package com.fiction.service;

import java.util.List;

import com.fiction.dao.SelectFictionDao;
import com.fiction.entity.SelectFiction;

public class SelectFictionService {
	
		SelectFictionDao sfd = new SelectFictionDao();
	//分页查分页查相应的数据
		public List<SelectFiction> getAllSelectPage(int page){
			return sfd.getAllSelectPage(page);
		}
	//获取 数据数
		public int getAllCount(){
			return sfd.getAllCount();
		}
	//添加小说
		public void addSelect(SelectFiction sf){
			sfd.addSelect(sf);
		}
	//根据id查所有
		public SelectFiction getSelectById(int id){
			return sfd.getSelectById(id);
		}
	//修改小说
		public void updateSelect(SelectFiction sf){
			sfd.updateSelect(sf);
		}
	//根据删除小说
		public void deleteSelectById(int id){
			sfd.deleteSelectById(id);
		}
	//批量删除
	public void deleteAllSelect(String[] ids){
		if(ids!=null){
			for(String i:ids){
				int id = Integer.parseInt(i);
				sfd.deleteSelectById(id);
			}
		}
	}
	//根据姓名进行模糊查询
		public List<SelectFiction> getSelectByName(String selectqq_name,int page){
			return sfd.getSelectByName(selectqq_name, page);
		}
	//获取用户表数据数模糊查询
	public int getByNameCount(String selectqq_name){
		return sfd.getByNameCount(selectqq_name);
	}
	//根据姓名进行查询所有
	public List<SelectFiction> ZhanByNameTwo(String selectqq_name){
			return sfd.ZhanByNameTwo(selectqq_name);
	}
	
}
