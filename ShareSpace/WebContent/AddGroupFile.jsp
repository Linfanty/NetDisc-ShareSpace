<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="demo.sharespace.bean.FileBean" %>
<%@ page import="demo.sharespace.dao.SearchGroupFile" %>  
<%@ page import="demo.sharespace.dao.Search_Space" %>  
<%@ page import="demo.sharespace.util.RequestUtils" %>    
<%@ page import="java.util.List" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="file:///F:/2018JAVA_WEB/ShareSpace/backgroud.png"  width="100%" height="100%" text="white" >
<% String groupid = RequestUtils.getGroupId(request); // 取GroupId的Session   %>
<% System.out.println( groupid ); %>
<center>
<h2>群组文件上传</h2>
<form method="post" action="/ShareSpace/UploadGroupFile" enctype="multipart/form-data">
    <input type="file" name="uploadFile" />
    <input type="submit" value="上传" />
</form>
   
<br>
<a href = "/ShareSpace/GroupFile.jsp"> 返回群文件页 </a>

</center>
</body>
</html>