package com.fiction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fiction.entity.SelectFiction;
import com.fiction.util.JdbcUtil;

public class SelectFictionDao {
	//连接数据库
	public Connection getConntion(){
		return new JdbcUtil().getConnection();
	}
	//分页查相应的数据
	public List<SelectFiction> getAllSelectPage(int page){
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<SelectFiction> list = new ArrayList<SelectFiction>();
		try {
			ps = getConntion().prepareStatement("select * from selectqq limit ?,10");
			ps.setInt(1, (page-1)*10);
			rs = ps.executeQuery();
			while(rs.next()){
				SelectFiction sf = new SelectFiction();
				sf.setSelectqq_Id(rs.getInt("selectqq_id"));
				sf.setSelectqq_Name(rs.getString("selectqq_name"));
				sf.setSelectqq_Writer(rs.getString("selectqq_writer"));
				sf.setSelectqq_Zuixin(rs.getString("selectqq_zuixin"));
				sf.setSelectqq_Time(rs.getString("selectqq_time"));
				sf.setSelectqq_Jianjie(rs.getString("selectqq_jianjie"));
				sf.setSelectqq_Image(rs.getString("selectqq_image"));
				list.add(sf);
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
			ps = getConntion().prepareStatement("select count(*) from selectqq");
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
		public void addSelect(SelectFiction sf){
			PreparedStatement ps = null;
			try {
				ps = getConntion().prepareStatement("insert into selectqq"
						+ "(selectqq_name,selectqq_writer,selectqq_zuixin,selectqq_time,selectqq_jianjie,selectqq_image) values(?,?,?,?,?,?)");
				ps.setString(1, sf.getSelectqq_Name());
				ps.setString(2, sf.getSelectqq_Writer());
				ps.setString(3, sf.getSelectqq_Zuixin());
				ps.setString(4, sf.getSelectqq_Time());
				ps.setString(5, sf.getSelectqq_Jianjie());
				ps.setString(6, sf.getSelectqq_Image());
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
		public SelectFiction getSelectById(int id){
			SelectFiction wf = new SelectFiction();
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = getConntion().prepareStatement("select selectqq_id,selectqq_name,selectqq_writer,selectqq_zuixin,selectqq_time,selectqq_jianjie from selectqq where selectqq_id like ?");
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while(rs.next()){
					wf.setSelectqq_Id(rs.getInt("selectqq_id"));
					wf.setSelectqq_Name(rs.getString("selectqq_name"));
					wf.setSelectqq_Writer(rs.getString("selectqq_writer"));
					wf.setSelectqq_Zuixin(rs.getString("selectqq_zuixin"));
					wf.setSelectqq_Time(rs.getString("selectqq_time"));
					wf.setSelectqq_Jianjie(rs.getString("selectqq_jianjie"));
					/*wf.setSelectqq_Image(rs.getString("selectqq_image"));*/
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
		public void updateSelect(SelectFiction sf){
			PreparedStatement ps = null;
			try {
				ps = getConntion().prepareStatement("update selectqq set selectqq_name=?,selectqq_writer=?,selectqq_zuixin=?,selectqq_time=?,selectqq_jianjie=? where "
						+ "selectqq_id=?");
				ps.setString(1, sf.getSelectqq_Name());
				ps.setString(2, sf.getSelectqq_Writer());
				ps.setString(3, sf.getSelectqq_Zuixin());
				ps.setString(4, sf.getSelectqq_Time());
				ps.setString(5, sf.getSelectqq_Jianjie());
				ps.setInt(6, sf.getSelectqq_Id());
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
		public void deleteSelectById(int id){
			PreparedStatement ps = null;
			try {
				ps = getConntion().prepareStatement("delete from selectqq where selectqq_id=?");
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
		public List<SelectFiction> getSelectByName(String selectqq_name,int page){
				PreparedStatement ps = null;
				ResultSet rs = null;
				List<SelectFiction> list = new ArrayList<SelectFiction>();
				try {
					ps = getConntion().prepareStatement("select * from selectqq where selectqq_name like ? limit ?,10");
					ps.setString(1, "%"+selectqq_name+"%");
					ps.setInt(2, (page-1)*10);
					rs = ps.executeQuery();
					while(rs.next()){
						SelectFiction sf = new SelectFiction();
						sf.setSelectqq_Id(rs.getInt("selectqq_id"));
						sf.setSelectqq_Name(rs.getString("selectqq_name"));
						sf.setSelectqq_Writer(rs.getString("selectqq_writer"));
						sf.setSelectqq_Zuixin(rs.getString("selectqq_zuixin"));
						sf.setSelectqq_Time(rs.getString("selectqq_time"));
						sf.setSelectqq_Jianjie(rs.getString("selectqq_jianjie"));
						sf.setSelectqq_Image(rs.getString("selectqq_image"));
						list.add(sf);
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
				public int getByNameCount(String selectqq_name){
					PreparedStatement ps = null;
					ResultSet rs = null;
					int count = 0;
					try {
						ps = getConntion().prepareStatement("select count(*) from selectqq where selectqq_name like ?");
						ps.setString(1, "%"+selectqq_name+"%");
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
	//根据姓名进行查询所有
	public List<SelectFiction> ZhanByNameTwo(String selectqq_name){
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<SelectFiction> list = new ArrayList<SelectFiction>();
			try {
				ps = getConntion().prepareStatement("select * from selectqq where selectqq_name like ?");
				ps.setString(1, selectqq_name);
				rs = ps.executeQuery();
				while(rs.next()){
					SelectFiction sf = new SelectFiction();
					sf.setSelectqq_Id(rs.getInt("selectqq_id"));
					sf.setSelectqq_Name(rs.getString("selectqq_name"));
					sf.setSelectqq_Writer(rs.getString("selectqq_writer"));
					sf.setSelectqq_Zuixin(rs.getString("selectqq_zuixin"));
					sf.setSelectqq_Time(rs.getString("selectqq_time"));
					sf.setSelectqq_Jianjie(rs.getString("selectqq_jianjie"));
					sf.setSelectqq_Image(rs.getString("selectqq_image"));
					list.add(sf);
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
}