package com.iot.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot.test.service.CustomerService;
import com.iot.test.service.MenuService;
import com.iot.test.service.UserService;
import com.iot.test.service.impl.CustomerServiceImpl;
import com.iot.test.service.impl.MenuServiceImpl;
import com.iot.test.service.impl.UserServiceImpl;

public class JspServlet extends HttpServlet {
	private MenuService ms=new MenuServiceImpl();
	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doProcess(req, res);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		String uri = req.getRequestURI();//    /jstl/view/user/list
		
		String root = req.getContextPath();//   /jstl
	
		uri = uri.replace(root, "");//  /view/user/list
		ms.setMenuList(req);
		if (uri.indexOf("user/list") != -1) {
			UserService us=new UserServiceImpl();
			us.getUserList(req);
		}else if (uri.indexOf("user/search") != -1) {
			
			UserService us=new UserServiceImpl();
			us.getUserList(req);
			uri = "/view/user/list";
		}
		else if (uri.indexOf("customer/list") != -1) {
			CustomerService cs= new CustomerServiceImpl();
			cs.setCustomerList(req);
		}else if (uri.indexOf("user/insertuser") != -1) {
			if(req.getParameter("age")!=null) {
			UserService us = new UserServiceImpl();
			us.InsertUser(req);
			uri = "/view/user/insertuser";
			}
			uri = "/view/user/insertuser";
		}
		
		uri = "/WEB-INF" + uri + ".jsp";
		
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}

}
