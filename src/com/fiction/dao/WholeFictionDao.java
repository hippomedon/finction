package com.fiction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fiction.entity.WholeFiction;
import com.fiction.util.*;

public class WholeFictionDao {
	//连接数据库
	public Connection getConntion(){
		return new JdbcUtil().getConnection();
	}
	//分页查所有
	public List<WholeFiction> getAllFictionPage(int page){
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<WholeFiction> list = new ArrayList<WholeFiction>();
		try {
			ps = getConntion().prepareStatement("select * from fiction limit ?,10");
			ps.setInt(1, (page-1)*10);
			rs = ps.executeQuery();
			while(rs.next()){
				WholeFiction wf = new WholeFiction();
				wf.setFiction_Id(rs.getInt("fiction_id"));
				wf.setFiction_Name(rs.getString("fiction_name"));
				wf.setFiction_Writer(rs.getString("fiction_writer"));
				wf.setFiction_Hot(rs.getInt("fiction_hot"));
				wf.setFiction_Status(rs.getString("fiction_status"));
				wf.setFiction_Now(rs.getInt("fiction_now"));
				wf.setFiction_Time(rs.getString("fiction_time"));
				list.add(wf);
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
	//获取 数据数
	public int getAllCount(){
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			ps = getConntion().prepareStatement("select count(*) from fiction");
			rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				getConntion().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	//添加小说
	public void addFiction(WholeFiction wf){
		PreparedStatement ps = null;
		try {
			ps = getConntion().prepareStatement("insert into fiction"
					+ "(fiction_name,fiction_writer,fiction_hot,fiction_status,fiction_now,fiction_time) values(?,?,?,?,?,?)");
			ps.setString(1, wf.getFiction_Name());
			ps.setString(2, wf.getFiction_Writer());
			ps.setInt(3, wf.getFiction_Hot());
			ps.setString(4, wf.getFiction_Status());
			ps.setInt(5, wf.getFiction_Now());
			ps.setString(6, wf.getFiction_Time());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				getConntion().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//根据id查所有
	public WholeFiction getFictionById(int id){
		WholeFiction wf = new WholeFiction();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = getConntion().prepareStatement("select * from fiction where fiction_id like ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				wf.setFiction_Id(rs.getInt("fiction_id"));
				wf.setFiction_Name(rs.getString("fiction_name"));
				wf.setFiction_Writer(rs.getString("fiction_writer"));
				wf.setFiction_Hot(rs.getInt("fiction_hot"));
				wf.setFiction_Status(rs.getString("fiction_status"));
				wf.setFiction_Now(rs.getInt("fiction_now"));
				wf.setFiction_Time(rs.getString("fiction_time"));
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
		return wf;
	}
	//修改小说
	public void updateFiction(WholeFiction wf){
		PreparedStatement ps = null;
		try {
			ps = getConntion().prepareStatement("update fiction set fiction_name=?,fiction_writer=?,fiction_status=?,fiction_now=?,fiction_time=? where "
					+ "fiction_id=?");
			ps.setString(1, wf.getFiction_Name());
			ps.setString(2, wf.getFiction_Writer());
			ps.setString(3, wf.getFiction_Status());
			ps.setInt(4, wf.getFiction_Now());
			ps.setString(5, wf.getFiction_Time());
			ps.setInt(6, wf.getFiction_Id());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				getConntion().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//根据删除小说
	public void deleteFictionById(int id){
		PreparedStatement ps = null;
		try {
			ps = getConntion().prepareStatement("delete from fiction where fiction_id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				getConntion().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//根据姓名进行模糊查询
	public List<WholeFiction> getFictionByName(String fiction_name,int page){
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<WholeFiction> list = new ArrayList<WholeFiction>();
			try {
				ps = getConntion().prepareStatement("select * from fiction where fiction_name like ? limit ?,10");
				ps.setString(1, "%"+fiction_name+"%");
				ps.setInt(2, (page-1)*10);
				rs = ps.executeQuery();
				while(rs.next()){
					WholeFiction wf = new WholeFiction();
					wf.setFiction_Id(rs.getInt("fiction_id"));
					wf.setFiction_Name(rs.getString("fiction_name"));
					wf.setFiction_Writer(rs.getString("fiction_writer"));
					wf.setFiction_Hot(rs.getInt("fiction_hot"));
					wf.setFiction_Status(rs.getString("fiction_status"));
					wf.setFiction_Now(rs.getInt("fiction_now"));
					wf.setFiction_Time(rs.getString("fiction_time"));
					list.add(wf);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
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
		//获取用户表数据数模糊查询
		public int getByNameCount(String fiction_name){
			PreparedStatement ps = null;
			ResultSet rs = null;
			int count = 0;
			try {
				ps = getConntion().prepareStatement("select count(*) from fiction where fiction_name like ?");
				ps.setString(1, "%"+fiction_name+"%");
				rs = ps.executeQuery();
				while(rs.next()){
					count = rs.getInt("count(*)");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					ps.close();
					getConntion().close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return count;
		}
}

