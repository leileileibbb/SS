<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<html>
	<head><title></title>
	<c:set var="path" value="${pageContext.request.contextPath }"/>
	<link rel="stylesheet" href="${path }/css/general.css"/>
	<link rel="stylesheet" href="${path }/css/jquery-ui-1.8.20.custom.css"/>
	<script type="text/javascript" src="${path }/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="${path }/js/jquery-ui-1.8.20.custom.min.js"></script>
	
	<script type="text/javascript">
	$(function() {
		$( "#datepicker" ).datepicker({ dateFormat: 'yy-m-d' });
	});
	</script>
	</head>
	<center>
	<body>
		<center><font size="5" style="color:#23ad07;  font-family: 微软雅黑  ">修改管理员</font></center><br/><br/>
		<!--<c:set var="stu" value="${sessionScope.stu_info }"/>-->
		<form action="AdminAction!updateAdmin" target="_parent">
		<table class="ta" width="200px">	
		<tr bgColor="#6fdd0">
			<td>用户名</td>
			<td><input type="text" name="admin.username" value="${session.admin_info.username }"/></td>
		</tr>
		<tr bgColor="#d6fdd0">
			<td>密码</td>
			<td><input type="password" name="admin.password" value="${session.admin_info.password }"/></td>
		</tr>
		<tr bgColor="#6fdd0">
			<td>姓名</td>
			<td><input type="text" name="admin.name" value="${session.admin_info.name }"/>
				<input type="hidden" name="admin.id" value="${session.admin_info.id}"/>
			</td>
		</tr>
		<tr bgColor="#d6fdd0">
			<td colspan="2"><input type="submit"  value="提交" class="buStyle"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset"  value="重置" class="buStyle"/></td>
		</tr>
		</table>
		</form>
	</body>
	</center>
</html>