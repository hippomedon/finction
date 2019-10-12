package com.fiction.service;

import java.util.List;

import com.fiction.dao.ViewChaptersDao;
import com.fiction.entity.ViewChapters;

public class ViewChaptersService {
	ViewChaptersDao vcd = new ViewChaptersDao();
	
	public List<ViewChapters> getAllView(String table){
		return vcd.getAllView(table);
	}
	

}
