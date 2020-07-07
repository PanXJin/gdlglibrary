package com.example.gdlglibrary.connections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class DBUtil {
	// URL
//	public final static String URL="jdbc:oracle:thin:LAPTOP-F1EPT0VH:1521:orcl";
	public final static String URL="jdbc:oracle:thin:120.239.124.7:1521:ORCL";

	//前提启动oracle
	public final static String USERNAME="system";//用户名
	public final static String PWD="Pan13229711549";//密码
	public final static String DRIVER="oracle.jdbc.driver.OracleDriver";
	//java程序中如何获取DRIVER
	//静态块
	static{
		try {//使用Class.forName可以达到加载特定驱动程序的目的，每种数据库管理系统（DBMS）
			//的驱动都不同，有数据库厂商提供
			Class.forName(DRIVER);
			//目前我们连接的是Oracle所以在此我们要写好OracleDriver
			//java.lang.ClassNotFoundException
			System.out.println("获取驱动成功！");
		} catch (ClassNotFoundException e) {
			System.out.println("没有获取到驱动！");
			e.printStackTrace();
		}		
	}
	//java将会利用获取到的驱动来连接数据库  java.sql 
	public Connection getConnection() throws SQLException{
		Connection conn=null;
		//先获得数据库的驱动
		conn=DriverManager.getConnection(URL, USERNAME, PWD);
		return conn;
	}
   //创建释放所有资源的方法
	public void closeAll(ResultSet rst,Statement stmt,Connection conn){
		if(rst!=null){
			try {
				rst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}