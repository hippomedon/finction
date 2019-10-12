package com.fiction.service;

import java.util.List;

import com.fiction.dao.WholeFictionDao;
import com.fiction.entity.WholeFiction;

public class WholeFictionService {
	WholeFictionDao wfd = new WholeFictionDao();
	//分页查所有
		public List<WholeFiction> getAllFictionPage(int page){
			return wfd.getAllFictionPage(page);
		}
	//获取 数据数
		public int getAllCount(){
			return wfd.getAllCount();
		}
	//添加小说
		public void addFiction(WholeFiction wf){	
			wfd.addFiction(wf);
		}
	//根据id查所有
		public WholeFiction getFictionById(int id){
			return wfd.getFictionById(id);
		}
	//修改小说
		public void updateFiction(WholeFiction wf){
			wfd.updateFiction(wf);
		}
	//根据删除小说
		public void deleteFictionById(int id){
			wfd.deleteFictionById(id);
		}
	//批量删除
		public void deleteAllFiction(String[] ids){
			if(ids!=null){
				for(String i:ids){
					int id = Integer.parseInt(i);
					wfd.deleteFictionById(id);
				}
			}
		}
	//根据姓名进行模糊查询
		public List<WholeFiction> getFictionByName(String fiction_name,int page){
			return wfd.getFictionByName(fiction_name, page);
		}
	//获取用户表数据数模糊查询
		public int getByNameCount(String fiction_name){
			return wfd.getByNameCount(fiction_name);
		}
}
