package com.fiction.test;

import java.util.List;

import com.fiction.dao.RankingListDao;
import com.fiction.entity.RankingList;

public class Testrankinglist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RankingListDao rl = new RankingListDao(); 
		/*List<rankingList> list = rl.getAllyear(1);
		for(rankingList rL:list){
			System.out.println(rL.getHeat());
		}*/
		int row = rl.add();
		System.out.println(row);
	}

}
