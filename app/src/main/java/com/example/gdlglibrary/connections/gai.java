package com.example.gdlglibrary.connections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class gai {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int code = 123456789;
    public static void main(String[] args) {
        gai g= new gai();
        int num = g.getCode();
        DBUtil db=new DBUtil();//实例化一个对象
        try {
            Connection conn=db.getConnection();//连接数据库
            System.out.println("连接数据库成功！");
            //试一试，修改数据
            String sql="update allbook set 列名=18 where codenum='"+num+"'";
            //操作数据 -- 修改
            Statement stmt=conn.createStatement();//创建数据操作对象
            ResultSet rst=stmt.executeQuery(sql);//stmt执行查询语句,并把返回的结果放到了rst中
            //遍历结果集、
            while(rst.next()){
                int id = rst.getInt(1);
                String ename=rst.getString("bookname");
                int where = rst.getInt("insite");
                String bookNo = rst.getString("booknum");
                int init = rst.getInt(5);
                Date date=rst.getDate("backtime");
//			    	Time time=rst.getTime(5);
                SimpleDateFormat f=new SimpleDateFormat("yyyy年MM月dd日");
                String newDate=f.format(date);

                System.out.println(id+"  :  "+ename+"  :  "+where+"  :  "+bookNo+"  :  "+init+"  :  "+newDate);
                //释放所有资源
                db.closeAll(rst, stmt, conn);
            }
        } catch (SQLException e) {
            System.out.println("连接数据库不成功");
            e.printStackTrace();
        }
    }
    public void setnames(int num,String bookname){
        DBUtil db=new DBUtil();//实例化一个对象
        try {
            Connection conn=db.getConnection();//连接数据库
            System.out.println("连接数据库成功！");
            //试一试，修改数据
            String sql="update allbook set bookname='"+bookname+"' where codenum='"+num+"'";
            //操作数据 -- 修改
            Statement stmt=conn.createStatement();//创建数据操作对象
            ResultSet rst=stmt.executeQuery(sql);//stmt执行查询语句,并把返回的结果放到了rst中
            //由于是修改，不需要进行查看结果
//            //遍历结果集、
//            while(rst.next()){
//                int id = rst.getInt(1);
//                String ename=rst.getString("bookname");
//                int where = rst.getInt("insite");
//                String bookNo = rst.getString("booknum");
//                int init = rst.getInt(5);
//                Date date=rst.getDate("backtime");
////			    	Time time=rst.getTime(5);
//                SimpleDateFormat f=new SimpleDateFormat("yyyy年MM月dd日");
//                String newDate=f.format(date);
//                System.out.println(id+"  :  "+ename+"  :  "+where+"  :  "+bookNo+"  :  "+init+"  :  "+newDate);
//                //释放所有资源
//                db.closeAll(rst, stmt, conn);
//            }
        } catch (SQLException e) {
            System.out.println("连接数据库不成功");
            e.printStackTrace();
        }
    }
}
