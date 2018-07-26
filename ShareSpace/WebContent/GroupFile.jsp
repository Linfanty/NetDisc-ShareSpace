<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="demo.sharespace.bean.FileBean" %>
<%@ page import="demo.sharespace.dao.SearchGroupFile" %>  
<%@ page import="demo.sharespace.util.RequestUtils" %>    
<%@ page import="java.util.List" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 

"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
SearchGroupFile space = new SearchGroupFile();
List<FileBean> fileList = space.getMyFileList(RequestUtils.getGroupId(request));
%>
<center>
<h2> 群文件 </h2>
<table border="1">
<tr><th>群组ID</th><th>群组名</th><th>文件ID</th><th>文件名</th><th colspan = "4">操作</th></tr>
<%
for(FileBean file : fileList){
%>
<tr>
<td><%=file.getGroupId() %></td>
<td><%=file.getGroupName() %></td>
<%-- <td><%=file.getFilePath() %></td>  --%>
<td><%=file.getFileId() %></td>
<td><%=file.getFileName() %></td>
<% out.println("<td><a href = \"/ShareSpace/DownloadGroupFile?fileId=" + file.getFileId() + "\"> 下载 </a></td>");%> 
 <% out.println("<td><a href = \"/ShareSpace/DeleteGroupFile?fileId=" + file.getFileId() + "\"> 删除 </a></td>");%> 
<%-- out.println("<td><a href = \"/ShareSpace/ChangeGroupFileState?fileId=" + file.getFileId() + "\"> 修改权限 </a></td>");--%>
<%-- out.println("<td><a href = \"ChangeGroupFileDesc.jsp?fileId=" + file.getFileId() + "\"> 修改描述 </a></td>"); --%>
</tr>
<%
}
%>
</table>
<br>
<a href = "/ShareSpace/AddGroupFile.jsp"> 添加群文件 </a>
<br><br>
<a href = "/ShareSpace/Group.jsp"> 返回我的群组页 </a>

</center>
</body>
</html>