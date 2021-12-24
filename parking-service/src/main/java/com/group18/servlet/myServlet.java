package com.group18.servlet;

import com.google.gson.Gson;

import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@WebServlet(name = "myServlet", value = "/myServlet")
public class myServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        String userName = "root";//这里是你最开始刚下载mysql是输入的账号
        String password = "123456";//这里是你最开始mysql设置的密码，
        String url = "jdbc:mysql://localhost:3306/pss?characterEncoding=utf-8&serverTimezone=GMT&useSSL=false";
        //获取ajax传递的参数，和获取表单数据的方式一样


        String name=request.getParameter("name");
        String sender=request.getParameter("sender");
        String message=request.getParameter("message");

        try {
            //这里不用更改，如果你要连的不是mysql的话再换这个括号内的代码
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动加载成功！");
            Connection conn = DriverManager.getConnection(url, userName, password);
            System.out.println("数据库连接成功！");
            String sql="insert into chat values (?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);//用来执行SQL语句查询，对sql语句进行预编译处理
            pst.setString(1,sender);
            pst.setString(2,name);
            pst.setString(3,message);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月和小时的格式为两个大写字母
            Date date = new Date();
            String time = df.format(date);
            pst.setString(4,time);
            pst.executeUpdate();
            System.out.println("插入成功");
            response.getWriter().write("1");


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("驱动失败！");
            System.out.println("数据库连接失败！");
        }






    }

}
