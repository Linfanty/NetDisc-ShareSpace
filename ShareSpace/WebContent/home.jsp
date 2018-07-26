<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="demo.sharespace.bean.FileBean" %>
<%@ page import="demo.sharespace.dao.MySpaceDao" %>  
<%@ page import="demo.sharespace.util.RequestUtils" %>    
<%@ page import="java.util.List" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body background="file:///F:/2018JAVA_WEB/ShareSpace/backgroud.png"  width="100%" height="100%" text="white" >
<center>
<%

if("1".equals(session.getAttribute("login_flag"))){
%>
<h2>
<a id="ss" href="/ShareSpace/space/ShareSpace.jsp">Share Space</a>
<a id="ms" href="/ShareSpace/space/MySpace.jsp">My Space</a>
<a id="gs" href="/ShareSpace/space/GroupSpace.jsp">Group Space</a>
<a id="upload" href="/ShareSpace/upload.jsp">上传</a>
欢迎,
<%=session.getAttribute("username") %>
<a id="logout" href="/ShareSpace/LogoutServlet">登出</a>
</h2>


<%
MySpaceDao mySpaceDao = new MySpaceDao();
List<FileBean> fileList = mySpaceDao.getMyFileList(RequestUtils.getUserId(request));
%>
<br/>
<br/>
<br/>
<table border="1">
<tr><th>文件ID</th><th>文件名</th><th>上传日期</th><th>文件描述</th><th>文件权限</th><th colspan = "4">操作</th></tr>
<%
for(FileBean file : fileList){
%>
<tr>
<td><%=file.getFileId() %></td>
<td><%=file.getFileName() %></td>
<%-- <td><%=file.getFilePath() %></td>  --%>
<td><%=file.getFileDate() %></td>
<td><%=file.getFileDesc() %></td>
<td><%=file.getFileState() %></td>
<% out.println("<td><a href = \"/ShareSpace/DownloadServlet?fileId=" + file.getFileId() + "\"> 下载 </a></td>");%>
<% out.println("<td><a href = \"/ShareSpace/DeleteServlet?fileId=" + file.getFileId() + "\"> 删除 </a></td>");%>
<% out.println("<td><a href = \"/ShareSpace/ChangeServlet?fileId=" + file.getFileId() + "\"> 修改权限 </a></td>");%>
<% out.println("<td><a href = \"ChangeDesc.jsp?fileId=" + file.getFileId() + "\"> 修改描述 </a></td>"); %>

</tr>
<%
}
%>
</table>
<%
}else{
	response.sendRedirect("/ShareSpace/login.jsp");
}
%>
</center>
</body>
</html>