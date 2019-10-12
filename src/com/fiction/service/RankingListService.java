package com.fiction.service;

import java.util.List;

import com.fiction.dao.RankingListDao;
import com.fiction.entity.RankingList;

public class RankingListService {
	RankingListDao rld = new RankingListDao();
	public List<RankingList> getAllweek(int page){
		page=(page-1)*10;
		return rld.getAllweek(page);
	}
	public int getweekCount() {
		return rld.getweekCount();
	}
	public List<RankingList> getAllmonth(int page){
		page=(page-1)*10;
		return rld.getAllMonth(page);
	}
	public int getmonthCount() {
		return rld.getMonthCount();
	}
	public List<RankingList> getAllYeat(int page){
		page=(page-1)*10;
		return rld.getAllyear(page);
	}
	public int getYeatCount() {
		return rld.getyearCount();
	}
}
