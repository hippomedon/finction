package com.fiction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fiction.entity.UserEntity;
import com.fiction.util.JdbcUtil;

public class UserDao {
	JdbcUtil jdbc = new JdbcUtil();
	public List<UserEntity> getAlluser(int page){
		List<UserEntity> list = new ArrayList<UserEntity>();
		Connection conn = jdbc.getConnection();
		String sql = "select * from user limit ?,10";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*10);
			rs = ps.executeQuery();
			while(rs.next()){
				UserEntity ue = new UserEntity();
				ue.setUserid(rs.getInt("user_id"));
				ue.setUsername(rs.getString("user_name"));
				ue.setUsergender(rs.getString("user_gender"));
				ue.setUseremail(rs.getString("user_email"));
				ue.setUsertime(rs.getString("user_time"));
				ue.setUseridentity(rs.getString("user_identity"));
				list.add(ue);
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
	//查询管理员信息条数（多少条数据）
	public int getcount(){
		Connection conn = jdbc.getConnection();
		String sql="select count(*) from user";
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps=conn.prepareStatement(sql);
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
	//根据id删除管理员
		public void deleteuser(int user_id){
			Connection conn = jdbc.getConnection();
			String sql = "delete from user where user_id= ?";
			PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, user_id);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//根据管理员名字进行模糊查询
		public List<UserEntity> getLikeuser(String name,int page){
			List<UserEntity> list = new ArrayList<>();
			Connection conn = jdbc.getConnection();
			String sql = "select * from user where user_name like ? limit ?,10;";
			PreparedStatement ps = null;
			ResultSet rs =null;
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1,"%"+name+"%");
				ps.setInt(2, (page-1)*10);
				rs = ps.executeQuery();
				while(rs.next()){
					UserEntity ue = new UserEntity();
					ue.setUserid(rs.getInt("user_id"));
					ue.setUsername(rs.getString("user_name"));
					ue.setUsergender(rs.getString("user_gender"));
					ue.setUseremail(rs.getString("user_email"));
					ue.setUsertime(rs.getString("user_time"));
					ue.setUseridentity(rs.getString("user_identity"));
					list.add(ue);
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
		//查询模糊查询管理员条数
		public int getLikeCount(String name) {
			Connection conn = jdbc.getConnection();
			String sql = "select count(*) from user where user_name like ?";
			PreparedStatement ps = null;
			ResultSet rs = null;
			int count =0;
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, "%"+name+"%");
				rs=ps.executeQuery();
				while(rs.next()){
					count = rs.getInt("count(*)");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return count;
		}
}
