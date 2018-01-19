package conf;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class Exam {
	
	public void init() {
		InputStream in= this.getClass().getResourceAsStream("/conf/dbconf.properties");
		Properties prop=new Properties();
		try {
			prop.load(in);
			Iterator<Object> it=prop.keySet().iterator();
//			while(it.hasNext()) {
//				String key=(String) it.next();
//				System.out.println(key+"="+prop.getProperty(key));
				Class.forName(prop.getProperty("Driver"));
				String url=prop.getProperty("url");
				String id=prop.getProperty("id");
				String pwd=prop.getProperty("pwd");
				Connection con=DriverManager.getConnection(url,id,pwd);
				String sql="select*from customer";
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next()) {
					System.out.println(rs.getString("customerName"));
				}
				System.out.println("연결성공");
//			}
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("난메인 영역이다");
		Exam e= new Exam();
		Set<String> s= new HashSet<String>();
		s.add("abc");
		s.add("abc");
		s.add("abc");
		System.out.println(s);
		e.init();
		
	}
}
