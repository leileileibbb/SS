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
		<!-- 综合查询操作层 -->
		<div id="selectDiv">
			<s:form action="CourseListAction.action" theme="simple" target="mainFrame" >
				<fieldset style="width:80%" >
					<legend>查询条件</legend>
					<s:hidden name="flag" value="1"></s:hidden>
				课程名:<s:textfield name="course.name" cssClass="textStyle"/>
				课程号:<s:textfield name="course.id" cssClass="textStyle"/>
				开课学期:<s:textfield name="course.lessonTime" cssClass="textStyle"/>
				课时:&nbsp;从<s:textfield name="startHour"  cssClass="textStyle"/>至<s:textfield name="endHour" cssClass="textStyle" />课时<br/>
				课程学分:<s:textfield name="course.lessonPoints" cssClass="textStyle"/>
				<s:submit value="查  询" cssClass="buStyle"/>
				</fieldset>
			</s:form>
		</div>
		<table class="ta">	
			<tr>
				<th >操作</th>
				<th>课程号</th>
				<th>课程名</th>
				<th>开课学期</th>
				<th>课时</th>
				<th>学分</th>
			</tr>
			<c:forEach items="${sessionScope.list }" var="cour" varStatus="status">
				<tr bgColor="${status.index%2==0?'#e5fee2':'#d6fdd0' }">
					<td><a href="StudentAction!addCourse?course.id=${cour.id}" target="_parent"><img src="${path }/images/select.png" alt="选课"/></a></td>
					<td>${cour.id}</td>
					<td>${cour.name }</td>
					<td>${cour.lessonTime }</td>
					<td>${cour.lessonHour}</td>
					<td>${cour.lessonPoints }</td>
				</tr>
			</c:forEach>		
		</table>
		<br/>
		<center>
		<div id="pageDir">
			 	<c:set var="pageCount" value="${(coucount-1)/10+1 }"/>
				<fmt:formatNumber var="lastIndex" value="${pageCount}" pattern="#"/>
			<ul>
				<li style="margin-left:25%;">
					第${sessionScope.thisindex }/${lastIndex }页
				</li>
				<li style="margin-left:40px;">
						<a href="CourseListAction.action?index=1&&flag=1" target="mainFrame">首页</a>
						
						<!-- 
							<c:set var="pageCount" value="${fn:length(userList)%10==0?fn:length(userList)/10:fn:length(userList)/10+1 }"/>
						-->
						
						 	<c:forEach var="i"  begin="1" step="1" end="${lastIndex}">
								<a href="CourseListAction.action?index=${i }&&flag=1 " target="mainFrame"><c:out value="${i }"/></a>
							</c:forEach>
						<a href="CourseListAction.action?index=${lastIndex}&&flag=1" target="mainFrame">尾页</a>
				</li>
				 <li style="margin-left:40px;">
						<s:form action="CourseListAction.action" theme="simple" target="mainFrame">
							第<s:textfield  name="index" cssStyle="width:25px;height:20px;"/>页
							<input type="hidden" name="flag" value="1"/>
							<s:submit value="Go" id="go"/>
						</s:form>
				</li>
			</ul>
		</div>
		</center>
	</body>
	</center>
</html>