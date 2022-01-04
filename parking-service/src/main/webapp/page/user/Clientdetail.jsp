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
					<td>${geClient.clientInformation.cid}</td>
				</tr>	
				<tr>
					<td width="120px">姓名</td>
					<td>${geClient.clientInformation.name}</td>
				</tr>
				<tr>
					<td width="120px">性别</td>
					<c:if test="${geClient.clientInformation.sex == true}"><td>男</td></c:if>
					<c:if test="${geClient.clientInformation.sex == false}"><td>女</td></c:if>
				</tr>
				<tr>
					<td width="120px">年龄</td>
					<td>${geClient.clientInformation.age}</td>
				</tr>
				<tr>
					<td width="120px">生日</td>
					<td>${geClient.clientInformation.birthday}</td>
				</tr>
				<tr>
					<td width="120px">电子邮箱</td>
					<td>${geClient.clientInformation.email}</td>
				</tr>
				<tr>
					<td width="120px">手机号</td>
					<td>${geClient.clientInformation.phone}</td>
				</tr>
		</table>
		<a href="lookAllClient.action">返回上一页</a>
	</body>
</html>
