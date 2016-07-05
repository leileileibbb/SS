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
		function showDialogForEdit(id){
			window.showModalDialog('CourseAction!updateCourDialog?cour.id='+id,'','dialogWidth=450px;dialogHeight=350px;');
	}
	</script>
	</head>
	<center>
	<body>
		<center><font size="5" style="color:#23ad07;  font-family: 微软雅黑  ">个新信息列表</font></center><br/><br/>
		<c:set var="stu" value="${sessionScope.stu_info }"/>
		<table class="ta">	
				<tr bgColor="#66f94c"><td>学号</td><td>${stu.idCard }</td></tr>
				<tr bgColor="#d6fdd0"><td>姓名</td><td>${stu.name }</td></tr>
				<tr bgColor="#66f94c"><td>性别</td><td>${stu.sex }</td></tr>
				<tr bgColor="#d6fdd0"><td>生日</td><td>${stu.birthday}</td></tr>
				<tr bgColor="#66f94c"><td>专业</td><td>${stu.major }</td></tr>
		</table>
		
	</body>
	</center>
</html>