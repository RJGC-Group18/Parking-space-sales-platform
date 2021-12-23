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
					<th>交易ID</th>
					<th>交易生成时间</th>
					<th>买方ID</th>
					<th>买方联系人</th>
					<th>买方联系电话</th>
					<th>车位ID</th>
					<th>经销商ID</th>
					<th>经销商公司名</th>
					<th>经销商联系人</th>
					<th>经销商联系电话</th>
					
					<c:if test="${payment.time != null}">
					<th>上次支付时间</th>
					</c:if>
					
					<th>已支付金额</th>
					<th>未支付金额</th>
					<th>支付截止日期</th>
					<th width="120px">操作</th>
				</tr>
			</thead>
			
			<tr>
				<td>${payment.id.no}</td>
				<td>${payment.dealing.time }</td>
				<td>${payment.client.cid}</td>
				<td>${payment.client.clientInformation.name}</td>
				<td>${payment.client.clientInformation.phone}</td>
				<td>${payment.parking.pid}</td>
				<td>${payment.user.uid}</td>
				<td>${payment.user.userInformation.name}</td>
				<td>${payment.user.userInformation.contactsName}</td>
				<td>${payment.user.userInformation.contactsPhone}</td>
				
				<c:if test="${payment.time != null}">
					<td>${payment.time}</td>
				</c:if>

				<td>${payment.paid}</td>
				<td>${payment.unpaid}</td>
				<td>${payment.deadline}</td>
				<td>
				<c:if test="${(payment.pay == null || payment.pay == false) && type == 0}">
					<button class="edit" type="button" onclick="window.location.href=''">
							<i class="fa fa-edit"></i>
							支付
					</button>
				</c:if>
				</td>
			</tr>
		</table>
		<c:if test="${type == 0}"><a href="clientLookDealingList.action">返回上一页</a></c:if>
		<c:if test="${type == 1||type == 2}"><a href="clientLookDealingList.action">返回上一页</a></c:if>
<%-- 		<%@include file="../inc/page.jsp"%> --%>
	</body>
</html>
