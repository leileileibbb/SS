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
	
	
		function showDialogForEdit(id){
			window.showModalDialog('StudentAction!updateStuDialog?stu.id='+id,'','dialogWidth=450px;dialogHeight=350px;');
	}
	
	</script>
	</head>
	<center>
	<body>
		<!-- 综合查询操作层 -->
		<div id="selectDiv">
			<s:form action="StudentListAction.action" theme="simple" target="mainFrame" >
				<fieldset style="width:80%">
					<legend>查询条件</legend>
				姓名:<s:textfield name="stu.name" cssClass="textStyle"/>
				学号:<s:textfield name="stu.idCard" cssClass="textStyle"/>
				专业:<s:textfield name="stu.major" cssClass="textStyle"/>
				出生日期:&nbsp;从<s:textfield name="startTime" id="datepicker1" cssClass="textStyle"/>至<s:textfield name="endTime" cssClass="textStyle" id="datepicker2"/>
				<s:submit value="查  询" cssClass="buStyle"/>
				</fieldset>
			</s:form>
		</div>
		<table class="ta">	
			<tr>
				<th colspan="2">操作</th>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>生日</th>
				<th>专业</th>
			</tr>
			<c:forEach items="${sessionScope.list }" var="stu" varStatus="status">
				<tr bgColor="${status.index%2==0?'#e5fee2':'#d6fdd0' }">
					<td><img src="${path }/images/edit2.png" alt="编辑" onclick="showDialogForEdit(${stu.id})"/></td>
					<td><a style="border-width:0px" href="StudentAction!deleteStu?stu.id=${stu.id }"><img src="${path }/images/delete.png" alt="删除"/></a></td>
					<td>${stu.idCard }</td>
					<td>${stu.name }</td>
					<td>${stu.sex }</td>
					<td>${stu.birthday}</td>
					<td>${stu.major }</td>
				</tr>
			</c:forEach>		
		</table>
		<br/>
		<center>
		<div id="pageDir">
			 	<c:set var="pageCount" value="${(count-1)/10+1 }"/>
				<fmt:formatNumber var="lastIndex" value="${pageCount}" pattern="#"/>
			<ul>
				<li style="margin-left:25%;">
					第${sessionScope.thisindex }/${lastIndex }页
				</li>
				<li style="margin-left:40px;">
						<a href="StudentListAction.action?index=1" target="mainFrame">首页</a>
						
						<!-- 
							<c:set var="pageCount" value="${fn:length(userList)%10==0?fn:length(userList)/10:fn:length(userList)/10+1 }"/>
						-->
						
						 	<c:forEach var="i"  begin="1" step="1" end="${lastIndex }">
								<a href="StudentListAction.action?index=${i } " target="mainFrame"><c:out value="${i }"/></a>
							</c:forEach>
						<a href="StudentListAction.action?index=${lastIndex}" target="mainFrame">尾页</a>
				</li>
				 <li style="margin-left:40px;">
						<s:form action="StudentListAction.action" theme="simple" target="mainFrame">
							第<s:textfield  name="index" cssStyle="width:25px;height:20px;"/>页
							<s:submit value="Go" id="go"/>
						</s:form>
				</li>
			</ul>
		</div>
		</center>
	</body>
	</center>
</html>