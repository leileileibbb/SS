<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="path"  value="${pageContext.request.contextPath}"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>学生选课系统</title>
</head>
<style type="text/css">
<!--

/*滚动条样式*/
body{
	        scrollbar-arrow-color:#034079;          /*三角箭头的颜色*/ 
            scrollbar-3dlight-color:#ADD9E6;        /*立体滚动条亮边的颜色*/ 
            scrollbar-highlight-color:#89C4D5;      /*滚动条空白部分的颜色*/ 
            scrollbar-shadow-color:#89C4D5;        /*立体滚动条阴影的颜色*/ 
            scrollbar-darkshadow-color:#ADD9E6;    /*滚动条强阴影颜色*/ 
            scrollbar-track-color:#ADD9E6;          /*立体滚动条背景颜色*/ 
            scrollbar-base-color:#ADD9E6;          /*滚动条的基本颜色*/ 
}


-->
</style>
<frameset rows="200,*" cols="*" frameborder="No" border="0" framespacing="0" >
  <frame src="${path }/jsp/front/top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame"  />
  <frameset cols="180,*" frameborder="no" border="0" framespacing="0">
    <frame src="${path }/jsp/front/left.jsp" name="leftFrame" scrolling="auto" bordercolor="#326799"  noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="${path }/jsp/front/stu_info.jsp" name="mainFrame" id="mainFrame" title="default" />
  </frameset>
</frameset><!-- /jsp/front/ -->
<noframes><body>
</body>
</noframes></html>


