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
					<th>销售方ID</th>
					<th>销售方名字</th>
					<th width="120px">操作</th>
				</tr>
			</thead>
			<c:forEach items="${userList}" var="list">
			<tr>
				<td>${list.uid}</td>
				<td>${list.username}</td>
				<td>
					<button class="edit" type="button" 
					onclick="window.location.href='lookUser.action?uid=${list.uid}'">
						<i class="fa fa-edit"></i>
						查看详情
					</button>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>
