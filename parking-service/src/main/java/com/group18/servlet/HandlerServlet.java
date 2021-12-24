package com.group18.servlet;


import com.group18.po.Chat;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by 3127 on 2017/4/23.
 */
@WebServlet("/HandlerServlet")
public class HandlerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String userName = "root";//这里是你最开始刚下载mysql是输入的账号
        String password = "123456";//这里是你最开始mysql设置的密码，
        String url = "jdbc:mysql://localhost:3306/parkingsafesdb?useSSL=false&serverTimezone=Asia/Shanghai";
        //获取ajax传递的参数，和获取表单数据的方式一样
        String name=request.getParameter("name");
        try {
            //这里不用更改，如果你要连的不是mysql的话再换这个括号内的代码
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动加载成功！");
            Connection conn = DriverManager.getConnection(url, userName, password);
            System.out.println("数据库连接成功！");
            String sql="select * from chat where sender = ? or receiver = ?";
            PreparedStatement pst = conn.prepareStatement(sql);//用来执行SQL语句查询，对sql语句进行预编译处理
            pst.setString(1,name);
            pst.setString(2,name);
            ResultSet rs = pst.executeQuery();



            while(rs.next()){
                Chat chat1=new Chat(rs.getString("sender"),rs.getString("receiver"),rs.getString("message"),rs.getTimestamp("time"));

                response.getWriter().write(new Gson().toJson(chat1, Chat.class));
                System.out.println(new Gson().toJson(chat1, Chat.class).toString());


            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("驱动失败！");
            System.out.println("数据库连接失败！");
        }






    }
}