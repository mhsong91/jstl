package com.iot.test.dao;

import java.util.List;

import com.iot.test.vo.ClassInfo;
import com.iot.test.vo.UserInfo;

public interface ClassDAO {

	
	public List<ClassInfo> selectClassList(ClassInfo ci);
	public ClassInfo selectClass(ClassInfo ci);
	public int InsertClass(ClassInfo ci);
	public int UpdateClass(ClassInfo ci);
	public int DeleteClass(ClassInfo ci);
}
