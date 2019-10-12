package com.fiction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fiction.entity.SelectFiction;
import com.fiction.entity.ViewChapters;
import com.fiction.entity.Writer;
import com.fiction.util.JdbcUtil;

public class ViewChaptersDao {

	//连接数据库
		public Connection getConntion(){
			return new JdbcUtil().getConnection();
		}
		public List<ViewChapters> getAllView(String table){
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<ViewChapters> list = new ArrayList<ViewChapters>();
			try {
				ps = getConntion().prepareStatement("select * from "+table);
				rs = ps.executeQuery();
				while(rs.next()){
					ViewChapters vc = new ViewChapters();
					vc.setText_Id(rs.getInt("text_id"));
					vc.setText_Title(rs.getString("text_title"));
					vc.setText_Content(rs.getString("text_content"));
					vc.setText_Name(rs.getString("text_name"));
					list.add(vc);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					rs.close();
					ps.close();
					getConntion().close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return list;
		}
}
