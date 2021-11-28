<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>列表</title>
		<link  rel="stylesheet"  href="${basePath}static/css/styles.css" />
		<link rel="stylesheet"  href="${basePath}static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
		<script  src="${basePath}static/js/jquery.min.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function(){
				$('.remove').click(function(){
					if(confirm("确定要删除吗？")){
						window.location.href="${basePath}course?method=delete&id="+$(this).attr("keyword");
					}
				})
			})
		</script>
	</head>
	<body>
		<form action="${basePath}course?method=list" method="post">
			<div class="condition">
				合同编号：<input type="text" name="No" value="${No}">
				车主ID：<input type="text" name="cId" value="${client.cId}">
				车主姓名：<input type="text" name="cName" value="${client.cName}">
				车主手机号：<input type="text" name="cPhone" value="${client.cPhone}">
				车位ID：<input type="text" name="pId" value="${parking.pId}">
				经销商ID：<input type="text" name="Id" value="${user.Id}">
				订单时间：<input type="date" name="date" value="${date}">
				<button>
					<i class="fa fa-search"></i>
					查询
				</button>
				<%--<button type="button"  onclick="window.location.href='course?method=v_add'">--%>
				<%--	<i class="fa fa-plus"></i>--%>
				<%--	新增--%>
				<%--</button>--%>
			</div>
		</form>
		<form action="${basePath}course?method=list" id="tableList" method="post">
		<input type="hidden" name="No" value="${No}">
		<input type="hidden" name="cId" value="${client.cId}">
		<input type="hidden" name="cName" value="${client.cName}">
		<input type="hidden" name="cPhone" value="${client.cPhone}">
		<input type="hidden" name="pId" value="${parking.pId}">
		<input type="hidden" name="Id" value="${user.Id}">
		<input type="date" name="date" value="${date}">
		<table class="tablelist">
			<thead>
				<tr>
					<th>合同编号</th>
					<th>车主ID</th>
					<th>车主姓名</th>
					<th>车主手机号</th>
					<th>车位ID</th>
					<th>经销商ID</th>
					<th>订单时间</th>
					<th>车位ID</th>
					<th width="120px">操作</th>
				</tr>
			</thead>
			<c:forEach items="${pageInfo.list}" var="course">
			<tr>
				<td>${No}</td>
				<td>${client.cId}</td>
				<td>${client.cName}</td>
				<td>${client.cPhone}</td>
				<td>${parking.pId}</td>
				<td>${user.Id}</td>
				<td>${date}</td>
				<td>
					<button class="edit" type="button" onclick="window.location.href='${basePath}course?method=edit&id=${course.cId}'">
						<i class="fa fa-edit"></i>
						确认
					</button>
					<%--<button class="remove" type="button" keyword="${No}">--%>
					<%--	<i class="fa fa-remove"></i>--%>
					<%--	删除--%>
					<%--</button>--%>
				</td>
			</tr>
			</c:forEach>
		</table>
		<%@include file="../inc/page.jsp"%>
		</form>
	</body>
</html>
