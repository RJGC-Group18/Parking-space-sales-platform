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
					<td width="120px">交易ID</td>
					<td>${payment.id.no}</td>
				</tr>	
				<tr>
					<td width="120px">交易生成时间</td>
					<td>${payment.dealing.time }</td>
				</tr>	
				<tr>
					<td width="120px">买方ID</td>
					<td>${payment.client.cid}</td>
				</tr>	
				<tr>
					<td width="120px">买方联系人</td>
					<td>${payment.client.clientInformation.name}</td>
				</tr>	
				<tr>
					<td width="120px">买方联系电话</td>
					<td>${payment.client.clientInformation.phone}</td>
				</tr>	
				<tr>
					<td width="120px">车位ID</td>
					<td>${payment.parking.pid}</td>
				</tr>	
				<tr>
					<td width="120px">经销商ID</td>
					<td>${payment.user.uid}</td>
				</tr>
				<tr>
					<td width="120px">经销商公司名</td>
					<td>${payment.user.userInformation.name}</td>
				</tr>	
				<tr>
					<td width="120px">经销商联系人</td>
					<td>${payment.user.userInformation.contactsName}</td>
				</tr>	
				<tr>
					<td width="120px">经销商联系电话</td>
					<td>${payment.user.userInformation.contactsPhone}</td>
				</tr>	
			<c:if test="${payment.time != null}">
				<tr>
					<td width="120px">上次支付时间</td>
					<td>${payment.time}</td>
				</tr>	
			</c:if>
				<tr>
					<td width="120px">已支付金额</td>
					<td>${payment.paid}</td>
				</tr>
				<tr>
					<td width="120px">未支付金额</td>
					<td>${payment.unpaid}</td>
				</tr>
				<tr>
					<td width="120px">支付截止日期</td>
					<td>${payment.deadline}</td>
				</tr>
				
				<c:if test="${(payment.pay == null || payment.pay == false) && type == 0}">
					<tr><td><button class="edit" type="button" onclick="window.location.href='lookPayment.action'">
							<i class="fa fa-edit"></i>
							支付
					</button>
				</td>
				</tr></c:if>
		</table>
		<c:if test="${type == 0}"><a href="clientLookDealingList.action">返回上一页</a></c:if>
		<c:if test="${type == 1||type == 2}"><a href="userLookDealingList.action">返回上一页</a></c:if>
<%-- 		<%@include file="../inc/page.jsp"%> --%>
	</body>
</html>
