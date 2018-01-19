package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.common.DBCon;
import com.iot.test.dao.UserDAO;
import com.iot.test.utils.DBUtil;
import com.iot.test.vo.UserInfo;

public class UserDAOImpl implements UserDAO{

	@Override
	public List<UserInfo> selectUserList(UserInfo ui) {
		List<UserInfo> userList = new ArrayList<UserInfo>(); 
		String sql = "select * from user_info where 1=1";
		if(ui!=null) {
			sql += " and uiname like ?";
		}
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
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
				userList.add(ui2);
			}
	
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}finally {
			DBUtil.close(con);
			DBUtil.close(ps);
			DBUtil.close(rs);
		}
		return userList;
	}

	@Override
	public UserInfo selectUser(UserInfo ui) {
		
		return null;
	}

	@Override
	public int InsertUser(UserInfo ui) {
		
		return 0;
	}

	@Override
	public int UpdateUser(UserInfo ui) {
		
		return 0;
	}

	@Override
	public int DeleteUser(UserInfo ui) {
		
		return 0;
	}

	@Override
	public List<UserInfo> serch(UserInfo ui) {
		// TODO Auto-generated method stub
		return null;
	}

}
