<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%--通过type的类型来设置登陆后的权限，即看到的内容--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>车位销售系统首页</title>
    <link  rel="stylesheet"  href="${basePath}static/css/styles.css" />
    <link rel="stylesheet"  href="${basePath}static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
    <script  src="${basePath}static/js/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript">//引入jquery
    $(function(){
        $('.menux p').click(function(){
            $(this).siblings('ul').slideUp(200);
            $(this).next('ul').slideToggle(200);
        });

        $('.menux p:first').trigger("click");

        $('.menux ul a').click(function(){
            $('iframe').attr("src",$(this).attr("url"));
            $('.menu_title').html($(this).attr("title"));
        });

        $('.logout').click(function(){
            if(confirm("确定要退出吗？")){
                window.location.href = "logout";
            }
        });

    })
    </script>
</head>
<body>
<% session.setAttribute("type", 1); %><!-- 设置用户类型为1 -->
<s:div cssClass="header">
    <s:div cssClass="logo">车位销售系统</s:div>
    <s:div cssClass="user">
        <i class="fa fa-caret-down point"></i>
        <i class="fa fa-user"></i>
            ${user.username}

        <ul>
            <li><a  target="mainFrame" href="pwd.jsp">修改密码</a></li>
            <li><a  target="mainFrame" href="info.jsp">个人信息</a></li>
            <li><a  href="userLoginOut.action" class="logout">退出登录</a></li>
        </ul>
    </s:div>
</s:div>
<s:div cssClass="left">
    <s:div class="title">
        <i class="fa fa-home"></i>
        系统功能
    </s:div>
    <s:div cssClass="menux">

          <!--   <p>
                <i class="fa fa-info-circle"></i>
                <i class="fa fa-angle-right point"></i>
                经销商权限
            </p> -->
            <ul>
                <li>
                        <%--parking里的add.jsp--%>
                    <a  href="javascript:void(0);" url="${basePath}course?method=list"  title="车位发布">
                        <i class="fa fa-caret-right"></i>
                        车位发布
                    </a>
                </li>
                <li>
                        <%--parking里的dealing.jsp--%>
                    <a  href="javascript:void(0);" url="${basePath}scquery?method=query_teacher"  title="签约合同">
                        <i class="fa fa-caret-right"></i>
                        签约合同
                    </a>
                </li>
            </ul>
</s:div>
</s:div>
<s:div cssClass="" class="main">
    <s:div cssClass="location">
        <i class="fa fa-home"></i>
        <span class="menu_title">用户管理</span>
    </s:div>
    <iframe src="welcome.jsp"  width="100%" height="90%" name="mainFrame"  id="mainFrame" frameborder="0px"></iframe>
</s:div>
</body>
</html>
