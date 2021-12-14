<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>列表</title>
		<link  rel="stylesheet"  href="${basePath}static/css/styles.css" />
	 <style  type="text/css"><!--<%@ include file="/static/css/styles.css"%>--></style>
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
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
	
		<table class="tablelist">
		
			<thead>
				<tr>
					<th>支付编号</th>
					<th>车主ID</th>
					<th>车位ID</th>
					<th>经销商ID</th>
					<th>支付时间</th>
					<th>已支付</th>
					<th>未支付</th>
					<th>截止日期</th>
					<th width="120px">操作</th>
				</tr>
			</thead>
			
			<c:forEach items="${pageInfo.list}" var="payment">
			<tr>
				<td>${payment.no}</td>
				<td>${payment.cid}</td>
				<td>${payment.pid}</td>
				<td>${payment.uid}</td>
				<td>${payment.time}</td>
				<td>${payment.paid}</td>
				<td>${payment.unpaid}</td>
				<td>${payment.deadline}</td>
				<td>
					<button class="edit" type="button" onclick="window.location.href='${basePath}course?method=edit&id=${course.cId}'">
						<i class="fa fa-edit"></i>
						确认
					</button>
					<button class="remove" type="button" keyword="${No}">
						<i class="fa fa-remove"></i>
						删除
					</button>
				</td>
			</tr>
			</c:forEach>
		</table>
<%-- 		<%@include file="../inc/page.jsp"%> --%>
	</body>
</html>
