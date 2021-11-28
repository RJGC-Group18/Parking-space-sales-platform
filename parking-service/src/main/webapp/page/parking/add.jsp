<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>车位发布</title>
		<link  rel="stylesheet"  href="${basePath}static/css/styles.css" />
		<link rel="stylesheet"  href="${basePath}static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
		<script  src="${basePath}static/js/jquery.min.js" type="text/javascript"></script>
		<script  src="${basePath}static/js/jquery-validation-1.14.0/jquery.validate.js" type="text/javascript"></script>
		<script  src="${basePath}static/js/jquery-validation-1.14.0/localization/messages_zh.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function(){
				$("#addForm").validate({
					rules:{
						cName:"required",
						tId:"required"
					}
				});
			});
		</script>
	</head>
	<body>
		<div class="add">
			<form id="addForm" action="${basePath}course?method=add" method="post">
				<table class="tableadd" style="width: 50%;">
					<tr>
						<td>地下几层</td>
						<td style="color: red;"><input type="text" name="sublevel"></td>
					</tr>
					<tr>
						<td>区域</td>
						<td style="color: red;"><input type="text" name="area"></td>
					</tr>
					<tr>
						<td>价格</td>
						<td style="color: red;"><input type="text" name="price"></td>
					</tr>
					<tr>
						<td>类型</td>
						<td style="color: red;"><input type="text" name="type"></td>
					</tr>
					<tr>
						<td>地址</td>
						<td style="color: red;"><input type="text" name="address"></td>
					</tr>
					
					<tr>
						<td colspan="4" align="left">
							<button class="edit" type="button" onclick="window.history.back(-1);">
								<i class="fa fa-arrow-left"></i>
								返回
							</button>
							<button class="remove" type="submit">
								<i class="fa fa-save"></i>
								提交
							</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
