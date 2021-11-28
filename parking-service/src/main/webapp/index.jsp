<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<div class="header">
			<div class="logo">车位销售系统</div>
			<div class="user">
				<i class="fa fa-caret-down point"></i>
				<i class="fa fa-user"></i>
				<c:if test="${type == 2}">
					${user.userName}
				</c:if>
				<c:if test="${type == 1}">
					${user.tName}
				</c:if>
				<c:if test="${type == 0}">
					${user.stuName}
				</c:if>
				<ul>
					<li><a  target="mainFrame" href="pwd.jsp">修改密码</a></li>
					<li><a  target="mainFrame" href="info.jsp">个人信息</a></li>
					<li><a  href="javascript:void(0)" class="logout">退出登录</a></li>
				</ul>
			</div>
		</div>
		<div class="left">
			<div class="title">
				<i class="fa fa-home"></i>
				系统功能
			</div>
			<div class="menux">
				<c:if test="${type == 2}">
				<p>
					<i class="fa fa-info-circle"></i>
					<i class="fa fa-angle-right point"></i>
					管理员权限
				</p>
				<ul>
					<li>
						<%--client里的list.jsp--%>
						<a  href="javascript:void(0);" url="${basePath}client?method=list"  title="车主管理">
							<i class="fa fa-caret-right"></i>
							车主管理
						</a>
					</li>
					<li>
						<%--user里的list.jsp--%>
						<a  href="javascript:void(0);" url="${basePath}teacher?method=list"  title="经销商管理">
							<i class="fa fa-caret-right"></i>
							经销商管理
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
				</c:if>
				<c:if test="${type ==1}">
				<p>
					<i class="fa fa-info-circle"></i>
					<i class="fa fa-angle-right point"></i>
					经销商权限
				</p>
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
				</c:if>
				<c:if test="${type ==0}">
				<p>
					<i class="fa fa-info-circle"></i>
					<i class="fa fa-angle-right point"></i>
					车主权限
				</p>
				<ul>
					<li>
						<%--dealing里的select.jsp--%>
						<a  href="javascript:void(0);" url="${basePath}sc?method=select"  title="报名摇号">
							<i class="fa fa-caret-right"></i>
							报名
						<%--包括了查看车位状态--%>
						</a>
					</li>

					<li>
						<%--client里的dealing.jsp--%>
						<a  href="javascript:void(0);" url="${basePath}scquery?method=query_teacher"  title="签约合同">
							<i class="fa fa-caret-right"></i>
							签约合同
						</a>
					</li>

				</ul>
				</c:if>
			</div>
		</div>
		<div class="main">
			<div class="location">
				<i class="fa fa-home"></i>
				<span class="menu_title">用户管理</span>
			</div>
			<iframe src="welcome.jsp"  width="100%" height="90%" name="mainFrame"  id="mainFrame" frameborder="0px"></iframe>
		</div>
	</body>
</html>
