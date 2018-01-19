package com.iot.test.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sun.reflect.generics.tree.VoidDescriptor;

public class MybatisSessionFactory {

	private static SqlSessionFactory ssf;
	
	static {
		String resource ="conf/mybatis-conf.xml";
		InputStream inputStream= null;
		try {
			inputStream=Resources.getResourceAsStream(resource);
			ssf=new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			
		}
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		return ssf;
	}
	
	
}
