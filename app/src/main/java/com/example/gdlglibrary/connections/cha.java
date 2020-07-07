package com.example.gdlglibrary.connections;

import android.content.Intent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import static android.app.Activity.RESULT_OK;


public class cha {

	private int code,where,init;
	private String bookname,bookNo,Date;

	public static void main(String[] args) {
		cha ca= new cha();
		int num = ca.getCode();
		DBUtil db=new DBUtil();//实例化一个对象
		try {
			Connection conn=db.getConnection();//连接数据库
			System.out.println("连接数据库成功！");
			//试一试，查询数据
			String sql="SELECT * FROM allbook";
			//操作数据 -- 查询
			Statement stmt=conn.createStatement();//创建数据操作对象
			ResultSet rst=stmt.executeQuery(sql);//stmt执行查询语句,并把返回的结果放到了rst中
			//遍历结果集
			while(rst.next()){
				int id = rst.getInt(1);
				String bookname=rst.getString("bookname");
				int where = rst.getInt("insite");
				String bookNo = rst.getString("booknum");
				int init = rst.getInt(5);
				Date date=rst.getDate("backtime");
				if (date!=null) {
					SimpleDateFormat f=new SimpleDateFormat("yyyy年MM月dd日");
					String newDate=f.format(date);

					ca.setBookname(bookname);
					ca.setWhere(where);
					ca.setBookNo(bookNo);
					ca.setInit(init);
					ca.setDate(newDate);

					System.out.println(id+"  :  "+bookname+"  :  "+where+"  :  "+bookNo+"  :  "+init+"  :  "+newDate);
				}else {
					System.out.println(id+"  :  "+bookname+"  :  "+where+"  :  "+bookNo+"  :  "+init+"  :  null");
				}
//					System.out.println(id+"  :  "+ename+"  :  "+where+"  :  "+bookNo+"  :  "+insite+"  :  null");
			}
			//释放所有资源
			db.closeAll(rst, stmt, conn);
		} catch (SQLException e) {
			System.out.println("连接数据库不成功");
			e.printStackTrace();
		}
	}
	public void cha(int code) {
		cha ca= new cha();
		int num = ca.getCode();
		DBUtil db=new DBUtil();//实例化一个对象
		try {
			Connection conn=db.getConnection();//连接数据库
			System.out.println("连接数据库成功！");
			//试一试，查询数据
			String sql="SELECT * FROM allbook where codenum ='"+code+"'";
			//操作数据 -- 查询
			Statement stmt=conn.createStatement();//创建数据操作对象
			ResultSet rst=stmt.executeQuery(sql);//stmt执行查询语句,并把返回的结果放到了rst中
			//遍历结果集
			while(rst.next()){
				int id = rst.getInt(1);
				String bookname=rst.getString("bookname");
				int where = rst.getInt("insite");
				String bookNo = rst.getString("booknum");
				int init = rst.getInt(5);
				Date date=rst.getDate("backtime");
				if (date!=null) {
					SimpleDateFormat f=new SimpleDateFormat("yyyy年MM月dd日");
					String newDate=f.format(date);

					ca.setBookname(bookname);
					ca.setWhere(where);
					ca.setBookNo(bookNo);
					ca.setInit(init);
					ca.setDate(newDate);

					System.out.println(id+"  :  "+bookname+"  :  "+where+"  :  "+bookNo+"  :  "+init+"  :  "+newDate);
				}else {
					System.out.println(id+"  :  "+bookname+"  :  "+where+"  :  "+bookNo+"  :  "+init+"  :  null");
				}
//					System.out.println(id+"  :  "+ename+"  :  "+where+"  :  "+bookNo+"  :  "+insite+"  :  null");
			}
			//释放所有资源
			db.closeAll(rst, stmt, conn);
		} catch (SQLException e) {
			System.out.println("连接数据库不成功");
			e.printStackTrace();
		}
	}
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getWhere() {
		return where;
	}

	public void setWhere(int where) {
		this.where = where;
	}

	public int getInit() {
		return init;
	}

	public void setInit(int init) {
		this.init = init;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}
}

