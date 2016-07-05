<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<c:set var="path"  value="${pageContext.request.contextPath}"/>
<head>
<title>学生选课系统-后台登录</title>
<link style="stylesheet" href="${path }/css/behindlogin.css" />
</head>

<body background="${path }/images/loginbg.png">

 <h3><center><font color="red">  <%
   if(session.getAttribute("result")==null)
      session.setAttribute("result","");
   			%>
   			
  	  <%=session.getAttribute("result")%></font></center></h3>
 <center>
<div id="Layer1" style="background:url(${path }/images/loginfrbg.jpg);	position:absolute;
	left:411px;
	top:100px;
	width:480px;
	height:215px;
	z-index:1;
	
	background-repeat:no-repeat;">
 
  <form action="AdminAction!checkAdminer" style="height:250px;width:480px;">
    <table width="441" height="227" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="128" height="75">&nbsp;</td>
        <td width="313">&nbsp;</td>
      </tr>
      <tr>
        <td height="50" align="right" valign="middle"><span class="STYLE6">用户名：</span></td>
        <td align="left" valign="middle"> <input type="text" name="admin.username" width="250px" height="35px" style="border-color:#00CCFF;width:250px;height:30px;padding-top:3px;"/></td>
      </tr>
      <tr>
        <td height="50" align="right" valign="middle"><span class="STYLE6">密&nbsp;&nbsp;码</span>： </td>
        <td align="left" valign="middle">  <input type="password" name="admin.password"   style="border-color:#00CCFF;width:250px;height:30px;padding-top:3px;"/></td>
      </tr>
      <tr>
        <td height="50" colspan="2" align="center" valign="middle"><input name="submit" type="submit" value="提  交" style="height:30;width:80" />&nbsp;&nbsp;
          <input name="reset" type="reset" value="重  置" style="height:30;width:80" />&nbsp;&nbsp;
          <input name="submit" type="submit" value="提  交" style="height:30;width:80" />
          </td>
        </tr>
    </table>
  </form>
</div>
</center>
</body>
</html>
