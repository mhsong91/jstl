package com.iot.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot.test.service.ClassService;
import com.iot.test.service.impl.ClassServiceImpl;

public class ClassServlet extends HttpServlet{
	

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
		System.out.println("hjhjh");
		String uri = req.getRequestURI();//    /jstl/view/list
		System.out.println("uri");
		String root = req.getContextPath();//   /jstl
		System.out.println("uri");
		uri = uri.replace(root, "");//  /view/list
		if (uri.indexOf("class/list") != -1) {
			ClassService cs=new ClassServiceImpl();
			cs.getClassList(req);
		}
		if (uri.indexOf("class/search") != -1) {
			ClassService cs=new ClassServiceImpl();
			cs.getClassList(req);
			uri="/view/class/list";
			
		}
		uri = "/WEB-INF" + uri + ".jsp";
		RequestDispatcher rd = req.getRequestDispatcher(uri);
	
		rd.forward(req, res);
	}
	

}
