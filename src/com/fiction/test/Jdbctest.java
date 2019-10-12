package com.fiction.test;

import java.sql.Connection;

import com.fiction.dao.WholeFictionDao;
import com.fiction.util.*;

public class Jdbctest {
	public static void main(String[] args) {
		/*JdbcUtil jd = new JdbcUtil();
		System.out.println(jd.getConnection());*/
		WholeFictionDao wd = new WholeFictionDao();
		
		System.out.println(wd.getAllFictionPage(1));
	}
}
