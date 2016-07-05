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

	</script>
	</head>
	<center>
	<body>
		<center><font size="5" style="color:#23ad07;  font-family: 微软雅黑  ">课程管理</font></center><br/><br/>
		<!--<c:set var="stu" value="${sessionScope.stu_info }"/>-->
		<form action="CourseAction!updateCour" target="mainFrame" onsubmit="javascript:window.close()">
		<table class="ta" width="200px">	
		
		<tr bgColor="#6fdd0">
			<td>课程名</td>
			<td><input type="text" name="cour.name" value="${request.cour_info.name}"/></td>
		</tr>
		<tr bgColor="#d6fdd0">
			<td>课程学期</td>
			<td><input type="text" name="cour.lessonTime" value="${request.cour_info.lessonTime}"/></td>
		</tr>
		<tr bgColor="#6fdd0">
			<td>课时</td>
			<td><input  type="text" name="cour.lessonHour" value="${request.cour_info.lessonHour}"/>
				<input  type="hidden" name="cour.id" value="${request.cour_info.id}"/>
			</td>
		</tr>
		<tr bgColor="#d6fdd0">
			<td>学分</td>
			<td><input type="text" name="cour.lessonPoints" value="${request.cour_info.lessonPoints}"/>
			</td>
		</tr>
		
		<tr bgColor="#6fdd0">
			<td colspan="2"><input type="submit"  value="提交"  onclick="javascript:window.close()" class="buStyle"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset"  value="重置" class="buStyle"/></td>
		</tr>
		</table>
		</form>
	</body>
	</center>
</html>