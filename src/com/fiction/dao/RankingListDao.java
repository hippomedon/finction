package com.fiction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fiction.entity.RankingList;
import com.fiction.util.JdbcUtil;

public class RankingListDao {
	JdbcUtil jdbc = new JdbcUtil();
	public List<RankingList> getAllweek(int page){
		List<RankingList> list = new ArrayList<RankingList>();
		Connection conn = jdbc.getConnection();
		String sql = "select * from week order by week_heat desc limit ?,10";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, page);
			rs = ps.executeQuery();
			while(rs.next()){
				RankingList rl = new RankingList();
				rl.setBookname(rs.getString("week_name"));
				rl.setName(rs.getString("week_author"));
				rl.setHeat(rs.getInt("week_heat"));
				rl.setState(rs.getString("week_state"));
				rl.setTime(rs.getString("week_time"));
				list.add(rl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public int getweekCount() {
		Connection conn = jdbc.getConnection();
		String sql= "select count(*) from week";
		PreparedStatement ps = null;
		int count = 0;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	public List<RankingList> getAllMonth(int page){
		List<RankingList> list = new ArrayList<RankingList>();
		Connection conn = jdbc.getConnection();
		String sql = "select * from month order by month_heat desc limit ?,10";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, page);
			rs = ps.executeQuery();
			while(rs.next()){
				RankingList rl = new RankingList();
				rl.setBookname(rs.getString("month_name"));
				rl.setName(rs.getString("month_author"));
				rl.setHeat(rs.getInt("month_heat"));
				rl.setState(rs.getString("month_state"));
				rl.setTime(rs.getString("month_time"));
				list.add(rl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public int getMonthCount() {
		Connection conn = jdbc.getConnection();
		String sql= "select count(*) from month";
		PreparedStatement ps = null;
		int count = 0;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	public List<RankingList> getAllyear(int page){
		List<RankingList> list = new ArrayList<RankingList>();
		Connection conn = jdbc.getConnection();
		String sql = "select * from year order by year_heat desc limit ?,10";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, page);
			rs = ps.executeQuery();
			while(rs.next()){
				RankingList rl = new RankingList();
				rl.setBookname(rs.getString("year_name"));
				rl.setName(rs.getString("year_author"));
				rl.setHeat(rs.getInt("year_heat"));
				rl.setState(rs.getString("year_state"));
				rl.setTime(rs.getString("year_time"));
				list.add(rl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public int getyearCount() {
		Connection conn = jdbc.getConnection();
		String sql= "select count(*) from year";
		PreparedStatement ps = null;
		int count = 0;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	public  int add() {
		Connection conn = jdbc.getConnection();
		String sql = "insert into year(year_name,year_author,year_heat,year_state,year_time) values(?,?,?,?,?)";
		int row=0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "网游之纵横天下");
			ps.setString(2, "失落叶");
			ps.setInt(3, 466541);
			ps.setString(4, "完结");
			ps.setString(5, "2015-5-17");
			row = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
}
