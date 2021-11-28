<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>车主列表</title>
		<link  rel="stylesheet"  href="${basePath}static/css/styles.css" />
		<link rel="stylesheet"  href="${basePath}static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
		<script  src="${basePath}static/js/jquery.min.js" type="text/javascript"></script>

		<script type="text/javascript">
			$(function(){
				$('.remove').click(function(){
					if(confirm("确定要删除吗？")){
						window.location.href="${basePath}student?method=delete&id="+$(this).attr("keyword");
						//返回keyword的值，即按钮的值
					}
				})
			})
		</script>
	</head>
	<body>
		<%--查询和新增--%>
		<form action="${basePath}student?method=list" method="post">
			<div class="condition">
				ID：<input type="text" name="stuId" value="${Client.stuId}">
				姓名：<input type="text" name="stuName" value="${Client.stuName}">
				手机号：<input type="text" name="stuNo" value="${Client.stuNo}">
				<button>
					<i class="fa fa-search"></i>
					查询
				</button>
				<%--跳转到增加车主页面--%>
				<button type="button" onclick="window.location.href='page/student/add.jsp'">//
					<i class="fa fa-plus"></i>
					新增
				</button>
			</div>
		</form>
		<%--列表信息显示--%>
		<form action="${basePath}student?method=list" id="tableList" method="post">
		<input type="hidden" name="pageNo" value="${pageInfo.pageNo}">
		<input type="hidden" name="cId" value="${Client.cId}">
		<input type="hidden" name="cName" value="${Client.cName}">
		<input type="hidden" name="cPhone" value="${Client.phone}">

		<%--设计表头--%>
		<table class="tablelist">
			<thead>
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>手机号</th>
					<th width="120px">操作</th>
				</tr>
			</thead>
			<%--将车主信息存入表格--%>
			<c:forEach items="${pageInfo.list}" var="student">
			<tr>
				<td>${Client.cId}</td>
				<td>${Client.cName}</td>
				<td>${Client.cphone}</td>
				<td>
					<button class="edit" type="button" onclick="window.location.href='${basePath}student?method=edit&id=${Client.cId}'">
						<i class="fa fa-edit"></i>
						修改
					</button>
					<button class="remove" type="button" keyword="${Client.cId}">
						<i class="fa fa-remove"></i>
						删除
					</button>
				</td>
			</tr>
			</c:forEach>
		</table>
			<%--2个JSP文件被SERVLET同时编译到一个.java文件。可以使用另一个页面定义的变量，方法等--%>
		<%@include file="../inc/page.jsp"%>
		</form>
	</body>
</html>
