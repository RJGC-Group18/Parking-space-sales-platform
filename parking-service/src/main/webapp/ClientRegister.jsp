<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
<!DOCTYPE html>
<html style="height: 100%">
<sx:head />
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
					<s:form name="CRegister" action="clientRegister" method="post">
					<table class="tableadd" style="width: 50%;">
				
					<tr>
						<td>用户名</td>
						<td>
						<s:textfield theme="simple" cssClass="name" name="client.username" />
						</td>
					</tr>
					
					<tr>
						<td>真实姓名</td>
						<td>
						<s:textfield theme="simple" cssClass="name" name="client.clientInformation.name" />
						</td>
					</tr>
					
					<tr>
						<td>密码</td>
						<td>
							<s:password theme="simple" cssClass="pwd" name="client.password"/>
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
						<td>性别</td>
						<td>
							<s:radio theme="simple" cssClass="pwd" name="client.clientInformation.sex" list="%{#{'true':'男','false':'女'}}" value="true"/>
						</td>
					</tr>			
					
					<tr>
						<td>年龄</td>
						<td>
						<s:textfield theme="simple" cssClass="name" name="client.clientInformation.age" />
						</td>
					</tr>
					
					<tr>
						<td>出生日期</td>
						<td>
						<%-- <s:textfield name="client.clientInformation.brithday" >   
						<s:param name="value"></s:param>   
						</s:textfield>  --%>
						 <sx:datetimepicker name="birthday" label="请求时间" displayFormat="yyyy-MM-dd" /> 
						</td>
					</tr>
					
					<tr>
						<td>电子邮箱</td>
						<td>
						<s:textfield theme="simple" cssClass="name" name="client.clientInformation.email" />
						</td>
					</tr>
					
					<tr>
						<td>电话</td>
						<td>
						<s:textfield theme="simple" cssClass="name" name="client.clientInformation.phone" />
						</td>
					</tr>
		
					<%--  <tr>
                    	 <td>资质照片</td>
                    	 <td id="clientQualification.image">
                         <s:file name="file"></s:file>
                         <input type="button" value="浏览" οnclick="addMore()">
                    	 </td>
               	 	 </tr>
 --%>
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