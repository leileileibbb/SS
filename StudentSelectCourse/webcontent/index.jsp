<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>学生选课系统-登录</title>
<style type="text/css">
<!--
#behind {
	text-align:center;
	margin:100px auto;
	z-index:1;
	width:800px;
	height:532px;
	background:url(images/index.jpg);
	background-repeat:no-repeat;
}
#Layer1{

position:absolute;
	margin-left:200px;
	margin-top:310px;
	z-index:1;

}
input[type="text"]{
	width:250px;
	height:35px;
}
input[type="password"]{
	width:250px;
	height:35px;
}
.STYLE6 {font-size: 14px}
.shadow{
		filter: progid:DXImageTransform.Microsoft.Shadow(color='#7d7d7d', Direction=150, Strength=10); 
		background-color:#dae6f4;
		-moz-box-shadow:2px 2px 5px #7d7d7d;
		 -webkit-box-shadow:2px 2px 5px #7d7d7d;
		  box-shadow:10px 5px 10px #7d7d7d;
}
-->
</style>
</head>

<body>
 <div id="behind" class="shadow">

<div id="Layer1">
  <form action="IndexAction">
  
  <table style="font-color:gray">
  <tr>
  
  	<td width="100px"><input type="radio" name="type" value="0"/><font color="gray">学生</font></td>
  	<td><input type="radio" name="type" value="1"/><font color="gray">管理员</font></td>
  </tr>
  	<tr>
  	
  	<td colspan="2" align="center"><input type="submit" value="提交"/></td>
  	</tr>
  </table>
  </form>
</div>

</div>
</body>
</html>
