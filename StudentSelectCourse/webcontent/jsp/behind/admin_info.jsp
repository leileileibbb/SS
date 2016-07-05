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

	</head>
	<center>
	<body>
		<center><font size="5" style="color:#23ad07;  font-family: 微软雅黑  ">管理员信息列表</font></center><br/><br/>
		<c:set var="admin" value="${sessionScope.admin_info }"/>
		<table class="ta">	
				<tr bgColor="#66f94c"><td>用户名</td><td>${admin.username }</td></tr>
				<tr bgColor="#d6fdd0"><td>姓名</td><td>${admin.name }</td></tr>
		</table>
		
	</body>
	</center>
</html>