package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.iot.test.dao.ClassDAO;
import com.iot.test.dao.impl.ClassDAOImpl;
import com.iot.test.service.ClassService;
import com.iot.test.vo.ClassInfo;
import com.iot.test.vo.UserInfo;

public class ClassServiceImpl implements ClassService{

	ClassDAO cdao=new ClassDAOImpl();
	Gson gs=new Gson();
	@Override
	public void getClassList(HttpServletRequest req) {
		ClassInfo ci=null;
		String json=req.getParameter("param");
		if(json!=null) {
//			ci=gs.fromJson(json,ClassInfo.class);
			ci = new ClassInfo();
			ci.setCiName(json);
		}
		req.setAttribute("classList",cdao.selectClassList(ci));
		}
		
	

	@Override
	public void getClass(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InsertClass(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateClass(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteClass(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}

}
