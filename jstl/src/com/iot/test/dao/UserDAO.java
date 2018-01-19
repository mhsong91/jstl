package com.iot.test.dao;

import java.util.List;

import com.iot.test.vo.UserInfo;

public interface UserDAO {

	public List<UserInfo> selectUserList(UserInfo ui);
	public List<UserInfo> serch(UserInfo ui);
	public UserInfo selectUser(UserInfo ui);
	public int InsertUser(UserInfo ui);
	public int UpdateUser(UserInfo ui);
	public int DeleteUser(UserInfo ui);
}
