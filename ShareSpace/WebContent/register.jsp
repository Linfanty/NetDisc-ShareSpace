<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<style type="text/css">
#checkNull, #checkPasswd {
	display: none;
	color: red;
}
</style>
</head>
<body background="file:///F:/2018JAVA_WEB/ShareSpace/backgroud.png"  width="100%" height="100%" text="white" >
<center>
<h1>注册</h1>
<form action="/ShareSpace/RegisterServlet" method="post" onsubmit="return checkPasswd(this)">
账号: <input id="username" type="text" name="username">
<br/>
密码: <input id="password1" type="password" name="password">
<br/>
确认密码: <input id="password2" type="password" name="password">
<br/>
<input type="submit" value="提交">
<input type="reset" value="重置">
</form>
<p id="checkNull">不允许为空！</p>
<p id="checkPasswd">两次输入的密码不一致！</p>
<%
if("-1".equals(request.getAttribute("register_flag"))){
%>
<p>用户名或密码不能为空！</p>
<%
}else if("-2".equals(request.getAttribute("register_flag"))){
%>
<p>写入错误，请稍后再试！</p>
<%
}
%>
</center>
<script type="text/javascript">
function checkPasswd() {
	debugger;
	if(document.getElementById("username").value == "" 
			|| document.getElementById("password1").value == "" 
			|| document.getElementById("password2").value == ""){
		document.getElementById("checkPasswd").style.display = "none";
		document.getElementById("checkNull").style.display = "block";
		return false;
	}
		
	if(document.getElementById("password1").value != document.getElementById("password2").value){
		document.getElementById("checkNull").style.display = "none";
		document.getElementById("checkPasswd").style.display = "block";
		return false;
	}
	
	return true;
}
</script>
</body>
</html>