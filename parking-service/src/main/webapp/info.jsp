<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html style="height: 100%">
<head>
<meta charset="utf-8">
<style  type="text/css"><!--<%@ include file="static/css/styles.css"%>--></style>
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script type="text/javascript" src="<s:url value="static/js/jquery.min.js"/>"></script>
		<script  src="${basePath}static/js/jquery-validation-1.14.0/jquery.validate.js" type="text/javascript"></script>
		<script  src="${basePath}static/js/jquery-validation-1.14.0/localization/messages_zh.js" type="text/javascript"></script>
</head>
<body style="height: 100%; margin: 0">
<div class="add">
	<table class="tablelist" style="width: 50%;margin-left:50px">
		<c:if test="${type == 0}">
			<tr>
				<td width="120px">ID</td>
				<td>${client.cid}</td>
			</tr>
			<tr>
				<td width="120px">用户名</td>
				<td>${client.username}</td>
			</tr>
			<tr>
				<td width="120px">姓名</td>
				<td>${client.clientInformation.name}</td>
			</tr>
			<tr>
				<td width="120px">姓别</td>
				<c:if test="${client.clientInformation.sex == true}"><td>男</td></c:if>
				<c:if test="${client.clientInformation.sex == false}"><td>女</td></c:if>
			</tr>
			<tr>
				<td width="120px">年龄</td>
				<td>${client.clientInformation.age}</td>
			</tr>
			<tr>
				<td width="120px">生日</td>
				<td>${client.clientInformation.birthday}</td>
			</tr>
			<tr>
				<td width="120px">电子邮箱</td>
				<td>${client.clientInformation.email}</td>
			</tr>
			<tr>
				<td width="120px">电话</td>
				<td>${client.clientInformation.phone}</td>
			</tr>
		</c:if>
		<c:if test="${type == 1}">
			<tr>
				<td width="120px">ID</td>
				<td>${user.uid}</td>
			</tr>
			<tr>
				<td width="120px">用户名</td>
				<td>${user.username}</td>
			</tr>
			<tr>
				<td width="120px">公司名</td>
				<td>${user.userInformation.name}</td>
			</tr>
			<tr>
				<td width="120px">地址</td>
				<td>${user.userInformation.address}</td>
			</tr>
			<tr>
				<td width="120px">联系人</td>
				<td>${user.userInformation.contactsName}</td>
			</tr>
			<tr>
				<td width="120px">联系电话</td>
				<td>${user.userInformation.contactsPhone}</td>
			</tr>
			<tr>
				<td width="120px">公司简介</td>
				<td>${user.userInformation.intro}</td>
			</tr>
			
		</c:if>
		<c:if test="${type == 2}">
			<tr>
				<td width="120px">ID</td>
				<td>${user.uid}</td>
			</tr>
			<tr>
				<td width="120px">用户名</td>
				<td>${user.username}</td>
			</tr>
		</c:if>
		
	</table>
	</div>
</body>
</html>