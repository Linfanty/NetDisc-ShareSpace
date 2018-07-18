<%@ page language="java" import="java.util.*" contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="javascript">  
function isValid(form)  
{  
	if (form.username.value=="")  
	{  
	 	alert("用户名不能为空");  
	 	return false;  
	}  
	if (form.pwd.value!=form.pwd2.value)  
	{  
		alert("两次输入的密码不同！");  
		return false;  
	}  
	else if (form.pwd.value=="")  
	{  
		alert("用户密码不能为空！");  
		return false;  
	}  
	else return true;  
}  
</script>  
</head>
 <body bgcolor="#e3e3e3">
  <body>
  <center>
  <h2>用户注册</h2>
  <form action="check2.jsp" method="post" onSubmit="return isValid(this);">
<table>
  <tr><td>用户名:</td><td><input type="text" name="username" size="20"/></td></tr>
  <tr><td>输入密码:</td><td><input type="text" name="pwd" size="20"/></td></tr>
  <tr><td>再次确认密码:</td><td><input type="text"name="pwd2" size="20"/></td><tr>
  <tr><td><input type="submit" value="注册"/><td><input type="reset" value="重置"/>
  </table>
</form>
  </center>
   <br>
  </body>
</html>