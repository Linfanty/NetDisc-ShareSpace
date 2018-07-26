<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="demo.sharespace.bean.FileBean" %>
<%@ page import="demo.sharespace.dao.MySpaceDao" %>  
<%@ page import="demo.sharespace.util.RequestUtils" %>    
<%@ page import="java.util.*" %>      

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建群组</title>
</head>

<body background="file:///F:/2018JAVA_WEB/ShareSpace/backgroud.png"  width="100%" height="100%" text="white" >
<center>
<form action = "/ShareSpace/CreateGroup"  method="post"> 

  	<h2> 输入群组名称 </h2>
  	<input type="text" name="groupname">
  	<input type="hidden" name="userid" value= <%=session.getAttribute("userid") %> > <br>
  	 <h2> 输入群组描述 </h2>
  	<input type="text" name="groupdesc">
	<input type="submit" value="提交" >

</form>
<br>
  <a href="/ShareSpace/space/GroupSpace.jsp">返回群组页</a>
</center>
</body>
</html>