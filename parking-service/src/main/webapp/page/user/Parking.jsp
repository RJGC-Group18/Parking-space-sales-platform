<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html style="height: 100%">
<head>
<meta charset="utf-8">
	<style  type="text/css"><!--<%@ include file="/static/css/styles.css"%>--></style>
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script type="text/javascript" src="<s:url value="static/js/jquery.min.js"/>"></script>
		<script  src="${basePath}static/js/jquery-validation-1.14.0/jquery.validate.js" type="text/javascript"></script>
		<script  src="${basePath}static/js/jquery-validation-1.14.0/localization/messages_zh.js" type="text/javascript"></script>
</head>
<body style="height: 100%; margin: 0">
<s:div cssClass="add">
	<table Class="tablelist" style="width: 50%;margin-left:50px">
		<c:if test="${type == 0}">
			<tr>
				<td width="120px">楼层</td>
				<td>${parking.sublevel}</td>
			</tr>
			<tr>
				<td width="120px">面积</td>
				<td>${parking.area}</td>
			</tr>
			<tr>
				<td width="120px">价格</td>
				<td>${parking.priceUnit}</td>
			</tr>
			<tr>
				<td width="120px">地址</td>
				<td>${parking.address}</td>
			</tr>
			<tr>
				<td width="120px">销售公司名</td>
				<td>${parking.user.userInformation.name}</td>
			</tr>
			<tr>
				<td width="120px">销售公司联系人</td>
				<td>${parking.user.userInformation.contactsName}</td>
			</tr>
			<tr>
				<td width="120px">销售公司联系电话</td>
				<td>${parking.user.userInformation.contactsPhone}</td>
			</tr>
			<tr>
				<td><a href="reservation.action?pid=${parking.pid}"></a></td>
			</tr>
		</c:if>
		<c:if test="${type == 1}">
		<tr>
				<td width="120px">楼层</td>
				<td>${parking.sublevel}</td>
			</tr>
			<tr>
				<td width="120px">面积</td>
				<td>${parking.area}</td>
			</tr>
			<tr>
				<td width="120px">价格</td>
				<td>${parking.priceUnit}</td>
			</tr>
			<tr>
				<td width="120px">地址</td>
				<td>${parking.address}</td>
			</tr>
			
		</c:if>
		<c:if test="${type == 2}">
		<tr>
				<td width="120px">楼层</td>
				<td>${parking.sublevel}</td>
			</tr>
			<tr>
				<td width="120px">面积</td>
				<td>${parking.area}</td>
			</tr>
			<tr>
				<td width="120px">价格</td>
				<td>${parking.priceUnit}</td>
			</tr>
			<tr>
				<td width="120px">地址</td>
				<td>${parking.address}</td>
			</tr>
		</c:if>
	</table>
</s:div>
	<s:div cssClass="tips">
				${msg}
			</s:div>
</body>
</html>