package com.fiction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fiction.entity.AdminEntity;
import com.fiction.util.JdbcUtil;


public class LoginDao {
	JdbcUtil ju=new JdbcUtil();
	public AdminEntity login(String adminName,String adminPwd){
		Connection conn = ju.getConnection();
		String sql = "select * from admin where admin_name=? and admin_pwd=?";
		AdminEntity admin = new AdminEntity();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminName);
			pstmt.setString(2, adminPwd);
			rs = pstmt.executeQuery();
			while(rs.next()){
				admin.setAdminid(rs.getInt("admin_id"));
				admin.setAdminname(rs.getString("admin_name"));
				admin.setAdminpwd(rs.getString("admin_pwd"));
				admin.setAdminemail(rs.getString("admin_email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return admin;
	}
	public List<AdminEntity> AllAdmin(String adminName){
		Connection conn = ju.getConnection();
		String sql = "select * from admin where admin_name=?";
		AdminEntity admin = new AdminEntity();
		List<AdminEntity> list = new ArrayList<AdminEntity>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminName);
			rs = pstmt.executeQuery();
			while(rs.next()){
				admin.setAdminid(rs.getInt("admin_id"));
				admin.setAdminname(rs.getString("admin_name"));
				admin.setAdminphone(rs.getString("admin_phone"));
				admin.setAdminemail(rs.getString("admin_email"));
				list.add(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
