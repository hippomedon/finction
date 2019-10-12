package com.fiction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import com.fiction.entity.AdminEntity;
import com.fiction.util.JdbcUtil;
public class AdminDao {
	JdbcUtil jdbc = new JdbcUtil();
	
	//查询所有管理员
	public List<AdminEntity> getAlladmin(int page){
		List<AdminEntity> list = new ArrayList<AdminEntity>();
		Connection conn = jdbc.getConnection();
		String sql = "select * from admin limit ?,10";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, page);
			rs = ps.executeQuery();
			while(rs.next()){
				AdminEntity ae = new AdminEntity();
				ae.setAdminid(rs.getInt("admin_id"));
				ae.setAdminname(rs.getString("admin_name"));
				ae.setAdminpwd(rs.getString("admin_pwd"));
				ae.setAdmingender(rs.getString("admin_gender"));
				ae.setAdminemail(rs.getString("admin_email"));
				ae.setAdminphone(rs.getString("admin_phone"));
				ae.setAdmintime(rs.getString("admin_time"));
				list.add(ae);
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
		String sql="select count(*) from admin";
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
	public void deleteadmin(int admin_id){
		Connection conn = jdbc.getConnection();
		String sql = "delete from admin where admin_id= ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, admin_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//根据管理员名字进行模糊查询
	public List<AdminEntity> getLikeadmin(String name,int page){
		List<AdminEntity> list = new ArrayList<>();
		Connection conn = jdbc.getConnection();
		String sql = "select * from admin where admin_name like ? limit ?,10;";
		PreparedStatement ps = null;
		ResultSet rs =null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+name+"%");
			ps.setInt(2, page);
			rs = ps.executeQuery();
			while(rs.next()){
				AdminEntity admin = new AdminEntity();
				admin.setAdminid(rs.getInt("admin_id"));
				admin.setAdminname(rs.getString("admin_name"));
				admin.setAdminpwd(rs.getString("admin_pwd"));
				admin.setAdmingender(rs.getString("admin_gender"));
				admin.setAdminemail(rs.getString("admin_email"));
				admin.setAdminphone(rs.getString("admin_phone"));
				admin.setAdmintime(rs.getString("admin_time"));
				list.add(admin);
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
		String sql = "select count(*) from admin where admin_name like ?";
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
	//新增管理员
	public int addadmin(String name,String pwd,String email,String gender,String phone,String time){
		JdbcUtil ju = new JdbcUtil();
		Connection conn = ju.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;
		String sql = "insert into admin(admin_name,admin_pwd,"
				+ "admin_gender,admin_email,admin_phone,admin_time) values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			pstmt.setString(3, gender);
			pstmt.setString(4, email);
			pstmt.setString(5, phone);
			pstmt.setString(6, time);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return row;
	}
	//编辑管理员信息
	public int editadmin(int id,String name,String pwd,String email,String gender,String phone,String time){
		JdbcUtil ju = new JdbcUtil();
		Connection conn = ju.getConnection();
		PreparedStatement pstmt = null;
		int row = 0;
		String sql = "update admin set admin_name=?,admin_pwd=?,"
				+ "admin_gender=?,admin_email=?,admin_phone=?,admin_time=? where admin_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			pstmt.setString(4, email);
			pstmt.setString(3, gender);
			pstmt.setString(5, phone);
			pstmt.setString(6, time);
			pstmt.setInt(7, id);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return row;
	}
	
}
