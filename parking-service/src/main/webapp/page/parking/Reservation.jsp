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
			<tr>
				<td width="120px">预约时间</td>
				<td>${reservation.time}</td>
			</tr>
			<tr>
				<td width="120px">车位ID</td>
				<td>${reservation.parking.pid}</td>
			</tr>
			<tr>
				<td width="120px">楼层</td>
				<td>${reservation.parking.sublevel}</td>
			</tr>
			<tr>
				<td width="120px">面积</td>
				<td>${reservation.parking.area}</td>
			</tr>
			<tr>
				<td width="120px">价格</td>
				<td>${reservation.parking.priceUnit}</td>
			</tr>
			<tr>
				<td width="120px">地址</td>
				<td>${reservation.parking.address}</td>
			</tr>
			<tr>
				<td width="120px">销售公司名</td>
				<td>${reservation.parking.user.userInformation.name}</td>
			</tr>
			<tr>
				<td width="120px">销售公司联系人</td>
				<td>${reservation.parking.user.userInformation.contactsName}</td>
			</tr>
			<tr>
				<td width="120px">销售公司联系电话</td>
				<td>${reservation.parking.user.userInformation.contactsPhone}</td>
			</tr>
			<tr>
				<td width="120px">预约用户ID</td>
				<td>${reservation.client.cid}</td>
			</tr>
			<tr>
				<td width="120px">预约用户名</td>
				<td>${reservation.client.username}</td>
			</tr>
			<tr>
				<td width="120px">预约用户真实姓名</td>
				<td>${reservation.client.clientInformation.name}</td>
			</tr>
			<tr>
				<td width="120px">预约用户联系电话</td>
				<td>${reservation.client.clientInformation.phone}</td>
			</tr>
			<tr>
				<td width="120px">预约用户联系邮箱</td>
				<td>${reservation.client.clientInformation.email}</td>
			</tr>
			<c:if test="${type == 0}">
				<tr>
					<a href="clientLookParkingList.action">返回上一页</a>
				</tr>
			</c:if>
			<c:if test="${type == 1}">
				<tr>
					<a href="userLookReservationList.action">返回上一页</a>
				</tr>			
			</c:if>
			<c:if test="${type == 2}">
				<tr>
					<a href="userLookReservationList.action">返回上一页</a>
				</tr>
		</c:if>
	</table>
</s:div>
	<s:div cssClass="tips">
				${msg}
			</s:div>
</body>
</html>