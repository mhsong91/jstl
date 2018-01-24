package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.iot.test.common.DBCon;
import com.iot.test.dao.UserDAO;
import com.iot.test.utils.DBUtil;
import com.iot.test.vo.UserInfo;

public class UserDAOImpl implements UserDAO{

	private static Logger log=Logger.getLogger(UserDAOImpl.class);
	
	@Override
	public List<UserInfo> selectUserList(UserInfo ui) {
		List<UserInfo> userList = new ArrayList<UserInfo>(); 
		String sql = "select * from user_info where 1=1";
		if(ui!=null) {
			sql += " and uiname like ?";
		}
		System.out.println(ui);
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			log.info("DAO 시작");
			con=DBCon.getCon();
			ps=con.prepareStatement(sql);
			if(ui!=null) {
				ps.setString(1, "%" + ui.getUiName() + "%");
			}
			
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				UserInfo ui2=new UserInfo();
				ui2.setUiNo(rs.getInt("UiNo"));
				ui2.setUiName(rs.getString("UiName"));
				ui2.setUiAge(rs.getInt("UiAge"));
				ui2.setUiId(rs.getString("UiId"));
				ui2.setUiPwd(rs.getString("UiPwd"));
				ui2.setCiNo(rs.getInt("CiNo"));
				userList.add(ui2);
			}
	
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}finally {
			DBUtil.close(con);
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
		log.info("DAO 종료");
		return userList;
	}

	@Override
	public UserInfo selectUser(UserInfo ui) {
		
		return null;
	}

	@Override
	public int InsertUser(UserInfo ui) {
		String sql="insert into user_info(uiName,uiAge,uiId,uiPwd,address,cino) values(?,?,?,?,?,?)";
		System.out.println(sql);
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try {
			con=DBCon.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1,ui.getUiName());
			ps.setInt(2,ui.getUiAge());
			ps.setString(3,ui.getUiId());
			ps.setString(4,ui.getUiPwd());
			ps.setString(5,ui.getAddress());
			ps.setInt(6,ui.getCiNo());
			result = ps.executeUpdate();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
			DBUtil.close(ps);
			}
		
		
		return result;
	}

	@Override
	public int UpdateUser(UserInfo ui) {
		String sql="update user_info set uiName=?,uiAge=?,address=? where uiId=?";
		System.out.println(ui);
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try {
			con=DBCon.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1,ui.getUiName());
			ps.setInt(2,ui.getUiAge());
			ps.setString(3,ui.getAddress());
			ps.setString(4,ui.getUiId());
			result = ps.executeUpdate();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
			DBUtil.close(ps);
			}
		return result;
	}

	@Override
	public int DeleteUser(UserInfo ui) {
		String sql="delete from user_info where uiId=?";
		System.out.println(ui);
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try {
			con=DBCon.getCon();
			ps=con.prepareStatement(sql);
			ps.setString(1,ui.getUiId());
			result = ps.executeUpdate();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
			DBUtil.close(ps);
			}
		return result;
	}

	@Override
	public List<UserInfo> serch(UserInfo ui) {
		// TODO Auto-generated method stub
		return null;
	}

}
