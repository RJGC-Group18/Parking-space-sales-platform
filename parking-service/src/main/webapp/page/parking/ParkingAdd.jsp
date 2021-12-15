<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
<!DOCTYPE html>
<html style="height: 100%">
<sx:head />
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
					<s:form name="ParkingAdd" action="userAddParking" method="post">
					<table class="tableadd" style="width: 50%;">
				
					<tr>
						<td>楼层</td>
						<td>
						<s:textfield theme="simple" cssClass="name" name="parking.sublevel" value=""/>
						</td>
					</tr>
					
					<tr>
						<td>面积</td>
						<td>
						<s:textfield theme="simple" cssClass="name" name="parking.area"	value="" />
						</td>
					</tr>
					
					
					<tr>
						<td>价格</td>
						<td>
						<s:textfield theme="simple" cssClass="name" name="parking.priceUnit" value=""/>
						</td>
					</tr>
					
					<tr>
						<td>地址</td>
						<td>
						<s:textfield theme="simple" cssClass="name" name="parking.address" value=""/>
						</td>
					</tr>
					
					<tr>
						<td colspan="4" align="left">
							<s:submit theme="simple" cssClass="Reg" value="添加"/>
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