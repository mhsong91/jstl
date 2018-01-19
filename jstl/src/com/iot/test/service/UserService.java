package com.iot.test.service;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

	public void getUserList(HttpServletRequest req);
	public void getUser(HttpServletRequest req);
	public void InsertUser(HttpServletRequest req);
	public void UpdateUser(HttpServletRequest req);
	public void DeleteUser(HttpServletRequest req);
	
}
