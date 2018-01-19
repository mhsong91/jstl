package com.iot.test.service.impl;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.google.gson.Gson;
import com.iot.test.dao.UserDAO;
import com.iot.test.dao.impl.UserDAOImpl;
import com.iot.test.service.UserService;
import com.iot.test.vo.UserInfo;

public class UserServiceImpl implements UserService{
	UserDAO udao=new UserDAOImpl();
	Gson gs=new Gson();
	
	@Override
	public void getUserList(HttpServletRequest req) {
		UserInfo ui=null;
		String json=req.getParameter("param");
		
		if(json!=null) {
//			ui=gs.fromJson(json,UserInfo.class);
			ui = new UserInfo();
			ui.setUiName(json);
		}
		req.setAttribute("userList",udao.selectUserList(ui));
		}

	@Override
	public void getUser(HttpServletRequest req) {
		
	}

	@Override
	public void InsertUser(HttpServletRequest req) {
		UserInfo ui= new UserInfo();
		String name=req.getParameter("name");
		System.out.println(name);
		System.out.println(req.getParameter("age"));
		int age=Integer.parseInt(req.getParameter("age"));
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		String address=req.getParameter("address");
		int cino=Integer.parseInt(req.getParameter("cino"));
		ui.setUiName(name);
		ui.setUiAge(age);
		ui.setUiId(id);
		ui.setUiPwd(pwd);
		ui.setAddress(address);
		ui.setCiNo(cino);
			
		req.setAttribute("insert",udao.InsertUser(ui));
		
		
	}

	@Override
	public void UpdateUser(HttpServletRequest req) {
		UserInfo ui= new UserInfo();
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String address=req.getParameter("address");
		String update=req.getParameter("update");
		ui.setUiName(name);
		ui.setUiAge(age);
		ui.setAddress(address);
		ui.setUiId(update);
		System.out.println(update);
		req.setAttribute("update",udao.UpdateUser(ui));
	}

	@Override
	public void DeleteUser(HttpServletRequest req) {
		UserInfo ui= new UserInfo();
		String delete=req.getParameter("delete");
		ui.setUiId(delete);
		System.out.println(delete);
		req.setAttribute("delete",udao.DeleteUser(ui));
	}


	

}
