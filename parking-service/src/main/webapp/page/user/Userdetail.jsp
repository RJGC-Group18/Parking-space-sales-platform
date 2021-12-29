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
		<table class="tablelist" style="width: 50%;margin-left:50px">	
				<tr>
					<td width="120px">ID</td>
					<td>${geUser.uid}</td>
				</tr>	
				<tr>
					<td width="120px">姓名</td>
					<td>${geUser.userInformation.name}</td>
				</tr>
				<tr>
					<td width="120px">地址</td>
					<td>${geUser.userInformation.address}</td>
				</tr>
				<tr>
					<td width="120px">联系人姓名</td>
					<td>${geUser.userInformation.contactsName}</td>
				</tr>
				<tr>
					<td width="120px">联系电话</td>
					<td>${geUser.userInformation.contactsPhone}</td>
				</tr>
				<tr>
					<td width="120px">介绍</td>
					<td>${geUser.userInformation.intro}</td>
				</tr>
		</table>
		<a href="lookAllUser.action">返回上一页</a>
	</body>
</html>
