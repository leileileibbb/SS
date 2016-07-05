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
		$( "#datepicker1" ).datepicker({ dateFormat: 'yy-m-d' });
		$( "#datepicker2" ).datepicker({ dateFormat: 'yy-m-d' });
	});
	</script>
	</head>
	<center>
	<body>
	<center><font size="5" style="color:#23ad07;  font-family: 微软雅黑  ">已选课程列表</font></center><br/><br/>
		
		<table class="ta">	
			<tr>
				<th >操作</th>
				<th>课程号</th>
				<th>课程名</th>
				<th>开课学期</th>
				<th>课时</th>
				<th>学分</th>
			</tr>
			<c:forEach items="${sessionScope.set }" var="cour" varStatus="status">
				<tr bgColor="${status.index%2==0?'#e5fee2':'#d6fdd0' }">
					<td><a target="_parent" href="StudentAction!deleCourse?course.id=${cour.id }"><img src="${path }/images/delete.png" alt="退选" ></a></td>
					<td>${cour.id}</td>
					<td>${cour.name }</td>
					<td>${cour.lessonTime }</td>
					<td>${cour.lessonHour}</td>
					<td>${cour.lessonPoints }</td>
				</tr>
			</c:forEach>		
		</table>
		<br/>
		
	</body>
	</center>
</html>