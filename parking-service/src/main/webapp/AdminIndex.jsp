<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%--通过type的类型来设置登陆后的权限，即看到的内容--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>车位销售系统后台管理</title>
    <style  type="text/css"><!--<%@ include file="static/css/styles.css"%>--></style>
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script type="text/javascript" src="<s:url value="static/js/jquery.min.js"/>"></script>
    <script type="text/javascript" >
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
<% session.setAttribute("type", 2); %><!-- 设置用户类型为2 -->
<s:div cssClass="header">
    <s:div cssClass="logo">车位销售系统后台管理</s:div>
    <s:div cssClass="user">
        <i Class="fa fa-caret-down point"></i>
        <i Class="fa fa-user"></i>

            ${user.username}

        <ul>
            <li><a  target="mainFrame" href="pwd.jsp">修改密码</a></li>
            <li><a  target="mainFrame" href="info.jsp">个人信息</a></li>
            <li><a  href="adminLoginOut.action" class="logout">退出登录</a></li>
        </ul>
    </s:div>
</s:div>
<s:div cssClass="left">
    <s:div cssClass="title">
        <i class="fa fa-home"></i>
        系统功能
    </s:div>
    <s:div cssClass="menux">

            <p>
                <i class="fa fa-info-circle"></i>
                <i class="fa fa-angle-right point"></i>
                管理员权限
            </p>
            <ul>
                <%-- <li>
                    <a  href="javascript:void(0);" url="${basePath}client?method=list"  title="车主管理">
                        <i class="fa fa-caret-right"></i>
                        车主管理
                    </a>
                </li>
                <li>
                    <a  href="javascript:void(0);" url="${basePath}teacher?method=list"  title="经销商管理">
                        <i class="fa fa-caret-right"></i>
                        经销商管理
                    </a>
                </li> --%>
			<li>
                    <a  href="javascript:void(0);" url="userLookParkingList.action"  title="车位列表">
                        <i class="fa fa-caret-right"></i>
                        车位管理
                    </a>
             </li>
             <li>
                    <a  href="javascript:void(0);" url="userLookReservationList.action"  title="预约信息列表">
                        <i class="fa fa-caret-right"></i>
                        预约信息管理
                    </a>
                </li>
                <li>
                    <a  href="javascript:void(0);" url="userLookDealingList.action"  title="签约合同">
                        <i class="fa fa-caret-right"></i>
                        交易信息管理
                    </a>
                </li>
                <li>
                    <a  href="javascript:void(0);" url="selectReservation.action"  title="摇号">
                        <i class="fa fa-caret-right"></i>
                       摇号
                    </a>
                </li>
                <li>
                    <a  href="javascript:void(0);" url="lookAllUser.action"  title="销售方信息">
                        <i class="fa fa-caret-right"></i>
                        销售方信息
                    </a>
                </li>
                <li>
                    <a  href="javascript:void(0);" url="lookAllClient.action"  title="购买方信息">
                        <i class="fa fa-caret-right"></i>
                        购买方信息
                    </a>
                </li>
                    <%--<li>--%>
                    <%--	<a  href="javascript:void(0);" url="${basePath}scquery?method=query_range"  title="分数区间统计">--%>
                    <%--		<i class="fa fa-caret-right"></i>--%>
                    <%--		分数区间统计--%>
                    <%--	</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                    <%--	<a  href="javascript:void(0);" url="${basePath}scquery?method=query_jgl"  title=及格率和总人数>--%>
                    <%--		<i class="fa fa-caret-right"></i>--%>
                    <%--		及格率和总人数--%>
                    <%--	</a>--%>
                    <%--</li>--%>
                    <%--<li>--%>
                    <%--	<a  href="javascript:void(0);" url="${basePath}main?method="  title=echart图>--%>
                    <%--		<i class="fa fa-caret-right"></i>--%>
                    <%--		echart图--%>
                    <%--	</a>--%>
                    <%--</li>--%>
            </ul>
    </s:div>
</s:div>
<s:div cssClass="main">
    <s:div cssClass="location">
        <i class="fa fa-home"></i>
        <span class="menu_title">用户管理</span>
    </s:div>
    <iframe src="welcome.jsp"  width="100%" height="90%" name="mainFrame"  id="mainFrame" frameborder="0px"></iframe>
</s:div>
</body>
</html>
