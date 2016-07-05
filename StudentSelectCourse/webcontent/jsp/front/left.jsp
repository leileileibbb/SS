<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'default.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/jquery-ui-1.8.12.css">
		<link rel="stylesheet" type="text/css" href="css/forDir.css" />
		
		<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
		<script type="text/javascript" src="js/jquery.ui.core.js"></script>
		<script type="text/javascript" src="js/jquery.ui.widget.js"></script>
		<script type="text/javascript" src="js/jquery.ui.accordion.js"></script>
		<!-- accordion调用 -->
		<style type="text/css">
<!--

/*滚动条样式*/
body{
	        scrollbar-arrow-color:red;          /*三角箭头的颜色*/ 
            scrollbar-3dlight-color:#ADD9E6;        /*立体滚动条亮边的颜色*/ 
            scrollbar-highlight-color:#89C4D5;      /*滚动条空白部分的颜色*/ 
            scrollbar-shadow-color:#89C4D5;        /*立体滚动条阴影的颜色*/ 
            scrollbar-darkshadow-color:#ADD9E6;    /*滚动条强阴影颜色*/ 
            scrollbar-track-color:#ADD9E6;          /*立体滚动条背景颜色*/ 
            scrollbar-base-color:#ADD9E6;          /*滚动条的基本颜色*/ 
}


-->
</style>
		<script>
	$(function() {
		$("#accordion").accordion( {
			autoHeight : false
		});

	});
</script>
  </head>
  
<c:set var="path"  value="${pageContext.request.contextPath}"/>
  <body bgcolor="red">
  <table  >
  
  <tr>
    <td  bordercolor="blue" width="100px" height="100px"> <img alt="头像" src="${path}/upload/${sessionScope.stu_info.photopath}" width="120px" height="150px"></td>
   
  </tr>
  <tr align="center">
     <td width="40" height="33px" > <font color="#3BAAE3">用户：${sessionScope.stu_info.name}</font></td>
  </tr>
  <tr align="center">
    <td width="40" height="33px"><a href="${path}/jsp/front/login.jsp" target="_top"><font color="#3BAAE3">注销</font></a></td>
  </tr>
  
  </table>
 
  <br/>
    <div id="accordion">
			<c:set var="stu" value="${sessionScope.stu_info }"/>
			<h3>
				<a href="#">个人信息管理</a>
			</h3>
			<div>
				<table class="ta">
					
					<tr>
						<td>
							<a href="jsp/front/stu_info.jsp?" target="mainFrame">个人信息</a>
						</td>
					</tr>
					<tr>
						<td>
							<a href="jsp/front/update_info.jsp" target="mainFrame">修改信息</a>
						</td>
					</tr>
				</table>
			</div>
			
			
			<h3>
				<a href="#">选课信息管理</a>
			</h3>
			<div>
				<table class="ta">
					
					<tr>
						<td>
							<a href="CourseAction!getCourse?stu.id=${session.stu_info.id}" target="mainFrame">已选列表</a>
						</td>
					</tr>
				</table>
			</div>
			
			<h3>
				<a href="#">选课信息</a>
			</h3>
			<div>
				<table class="ta">
					
					<tr>
						<td>
							<a href="CourseListAction.action?flag=1" target="mainFrame">课程列表</a>
						</td>
					</tr>
					
				</table>
			</div>
			
			
			<h3>
				<a href="#">待续</a>
			</h3>
			<div>
				<table class="ta">
					
					<tr>
						<td>
							<a>课程列表</a>
						</td>
					</tr>
				</table>
			</div>
			
			
			<h3>
				<a href="#">待续</a>
			</h3>
			<div>
				<table class="ta">
					
					<tr>
						<td>
							<a >课程列表</a>
						</td>
					</tr>
				</table>
			</div>
			
			<h3>
				<a href="#">待续</a>
			</h3>
			<div>
				<table class="ta">
					
					<tr>
						<td>
							<a >课程列表</a>
						</td>
					</tr>
				</table>
			</div>
			
			
			<h3>
				<a href="#">待续</a>
			</h3>
			<div>
				<table class="ta">
					
					<tr>
						<td>
							<a href="#">课程列表</a>
						</td>
					</tr>
				</table>
			</div>
			
			
			<h3>
				<a href="#">待续</a>
			</h3>
			<div>
				<table class="ta">
					
					<tr>
						<td>
							<a href="#">课程列表</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
  </body>
</html>
