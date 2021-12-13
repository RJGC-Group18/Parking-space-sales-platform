<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>车位列表</title>
		<link  rel="stylesheet"  href="${basePath}static/css/styles.css" />
	 	<style  type="text/css"><!--<%@ include file="/static/css/styles.css"%>--></style>
    	<link href="http://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    	<script type="text/javascript" src="<s:url value="static/js/jquery.min.js"/>"></script>
		<script type="text/javascript">
			$(function(){
				$('.remove').click(function(){
					if(confirm("确定要删除吗？")){
						window.location.href="${basePath}teacher?method=delete&id="+$(this).attr("keyword");
					}
				})
			})
		</script>
	</head>
	<body>
	
		<!-- 查询输入框 -->
		<form action="findAllByPriceOrAddress.action" method="post">
			<div class="condition">
				价格：<input type="text" name="price">
				地址：<input type="text" name="address">
				<button>
					<i class="fa fa-search"></i>
					查询
				</button>
			</div>
		</form>
		
		<!--查询输入-->
		
		<form action="${basePath}teacher?method=list" id="tableList" method="post">
		<input type="hidden" name="pageNo" value="${pageInfo.pageNo}">
		<input type="hidden" name="price" value="${priceUnit}">
		<input type="hidden" name="address" value="${address}">
		
		<table class="tablelist">
			<thead>
				<tr>
					<th>价格</th>
					<th>地址</th>
					<th width="120px">操作</th>
				</tr>
			</thead>
			
			
			<c:forEach items="${parkingList}" var="parking">
			<tr>
				<td>${parking.priceUnit}</td>
				<td>${parking.address}</td>
				<td>
					<button class="edit" type="button" onclick="window.location.href='${basePath}teacher?method=edit&id=${user.uId}'">
						<i class="fa fa-edit"></i>
						修改
					</button>
					<button class="remove" type="button" keyword="${user.uId}">
						<i class="fa fa-remove"></i>
						删除
					</button>
					<button class="edit" type="button" onclick="window.location.href='lookParking.action?pid=${parking.pid}'">
						<i class="fa fa-edit"></i>
						查看详细信息
					</button>
				</td>
			</tr>
			</c:forEach>
		</table>
		
		<%@include file="../inc/page.jsp"%>
		</form>
	</body>
</html>
