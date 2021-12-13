<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html style="height: 100%">
<head>
<meta charset="utf-8">
<style type="text/css"><!--<%@ include file="static/css/styles.css"%>--></style>
<link  rel="stylesheet"  href="${basePath}static/css/styles.css" />
		<link rel="stylesheet"  href="${basePath}static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
		<script  src="${basePath}static/js/jquery.min.js" type="text/javascript"></script>
		<script  src="${basePath}static/js/jquery-validation-1.14.0/jquery.validate.js" type="text/javascript"></script>
		<script  src="${basePath}static/js/jquery-validation-1.14.0/localization/messages_zh.js" type="text/javascript"></script>
</head>
<body style="height: 100%; margin: 0">
	<s:div cssClass="add">
					<s:form name="CRegister" action="userRegister" method="post"><!-- enctype="multipart/form" -->
					<table class="tableadd" style="width: 50%;">
				
					<tr>
						<td>用户名</td>
						<td>
						<s:textfield theme="simple" cssClass="name" name="user.username" />
						</td>
					</tr>
					
					<tr>
						<td>密码</td>
						<td>
							<s:password theme="simple" cssClass="pwd" name="user.password"/>
						</td>
					</tr>
					<tr>
					<tr>
						<td>确认密码</td>
						<td>
							<s:password theme="simple" cssClass="pwd" name="enterPassword"/>
						</td>
					</tr>		
								
					
					<tr>
						<td>公司名</td>
						<td>
						<s:textfield theme="simple" cssClass="name" name="user.userInformation.name" />
						</td>
					</tr>
					
					<tr>
						<td>地址</td>
						<td>
						<s:textfield theme="simple" cssClass="name" name="user.userInformation.address" />
						</td>
					</tr>
					
					<tr>
						<td>代表人名字</td>
						<td>
						<s:textfield theme="simple" cssClass="name" name="user.userInformation.contactsName" />
						</td>
					</tr>
					
					<tr>
						<td>代表人手机</td>
						<td>
						<s:textfield theme="simple" cssClass="name" name="user.userInformation.contactsPhone" />
						</td>
					</tr>
					
					<tr>
						<td>公司简介</td>
						<td>
						<s:textfield theme="simple" cssClass="name" name="user.userInformation.intro" size="90" maxlength="90"/>
						</td>
					</tr>
		
					<%--  <tr>
                    	 <td>资质照片</td>
                    	 <td>
                         <s:file name="upFile"></s:file>
                    	 </td>
               	 	 </tr> --%>

					<tr>
						<td colspan="4" align="left">
							<s:submit theme="simple" cssClass="Reg" value="注册"/>
						</td>
					</tr>
					<tr>
						<td colspan="4" align="left">
							${msg}
						</td>
					</tr>
				</table>
					</s:form>
		</s:div>
		<s:div>
				
	</s:div>
</body>
</html>