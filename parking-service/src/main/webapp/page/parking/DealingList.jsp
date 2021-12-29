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
					<th>交易编号</th>
					<th>车主ID</th>
					<th>车位ID</th>
					<th>经销商ID</th>
					<th>订单时间</th>
					<th>支付状况</th>
					<th width="120px">操作</th>
				</tr>
			</thead>
			
			<c:forEach items="${dealingList}" var="dealing">
			<tr>
				<td>${dealing.no}</td>
				<td>${dealing.client.cid}</td>
				<td>${dealing.parking.pid}</td>
				<td>${dealing.user.uid}</td>
				<td>${dealing.time}</td>
				<td>
					<c:if test="${dealing.pay == true}">
					支付完毕
					</c:if>
					<c:if test="${dealing.pay == false}">
					未支付完成
					</c:if>
				</td>
				<td>
					<button class="edit" type="button" onclick="window.location.href='lookDealing.action?no=${dealing.no}'">
						<i class="fa fa-edit"></i>
						查看交易详情
					</button>
					<c:if test="${dealing.pay != true}">
					<button class="remove" type="button" onclick="window.location.href='deleteDealing.action?no=${dealing.no}'" keyword="${No}">
						<i class="fa fa-remove"></i>
						取消交易
					</button>
					</c:if>
				</td>
			</tr>
			</c:forEach>
		</table>
<%-- 		<%@include file="../inc/page.jsp"%> --%>
	</body>
</html>
