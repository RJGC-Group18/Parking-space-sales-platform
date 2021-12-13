<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
	<s:div cssClass="add">
	   ${msg}
					<c:if test="${type == 2}">
						<s:form name="changePassword" action="adminChangePassword" method="post">
					<table class="tableadd" style="width: 50%;">
					<tr>
						<td>新密码</td>
						<td style="color: red;"><s:password theme="simple" cssClass="pwd" name="user.password"/></td>
					</tr>
					<tr>
						<td>确认密码</td>
						<td>
							<s:password theme="simple" cssClass="pwd" name="enterPassword"/>
						</td>
					</tr>
					<tr>
						<td colspan="4" align="left">
							<s:submit theme="simple" cssClass="remove" value="提交"/>
						</td>
					</tr>
				</table>
					</s:form>
					</c:if>
					<c:if test="${type == 1}">
						<s:form name="changePassword" action="userChangePassword" method="post">
					<table class="tableadd" style="width: 50%;">
					<tr>
						<td>新密码</td>
						<td style="color: red;"><s:password theme="simple" cssClass="pwd" name="user.password"/></td>
					</tr>
					<tr>
						<td>确认密码</td>
						<td>
							<s:password theme="simple" cssClass="pwd" name="enterPassword"/>
						</td>
					</tr>
					<tr>
						<td colspan="4" align="left">
							<s:submit theme="simple" cssClass="remove" value="提交"/>
						</td>
					</tr>
				</table>
					</s:form>
					</c:if>
					<c:if test="${type == 0}">
					<s:form name="changePassword" action="clientChangePassword" method="post">
					<table class="tableadd" style="width: 50%;">
					<tr>
						<td>新密码</td>
						<td style="color: red;"><s:password theme="simple" cssClass="pwd" name="client.password"/></td>
					</tr>
					<tr>
						<td>确认密码</td>
						<td>
							<s:password theme="simple" cssClass="pwd" name="enterPassword"/>
						</td>
					</tr>
					<tr>
						<td colspan="4" align="left">
							<s:submit theme="simple" cssClass="remove" value="提交"/>
						</td>
					</tr>
				</table>
					</s:form>
					</c:if>
		</s:div>
</body>
</html>