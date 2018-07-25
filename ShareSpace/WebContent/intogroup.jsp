<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="demo.sharespace.bean.FileBean" %>
<%@ page import="demo.sharespace.dao.IntoGroup" %>  
<%@ page import="demo.sharespace.util.RequestUtils" %>    
<%@ page import="java.util.List" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<%
IntoGroup space = new IntoGroup();
List<FileBean> fileList = space.getMyFileList(RequestUtils.getGroupName(request));
%>
<h1> 搜索到的群组 </h1>
<!--  <form action="/ShareSpace/IntoGroup2" method="post"> !-->

<table>
<tr><th>群组ID</th><th>群组名</th></tr>
<%
for(FileBean file : fileList){
%>
<tr>
<td><%=file.getGroupId() %></td>
<td><%=file.getGroupName() %></td>
<!-- <input type="hidden" name= "GroupName" value=<%=file.getGroupName() %> > !-->
<!-- <td><input type="submit" value="加入"></td> -->
<td><a href = \"/ShareSpace/IntoGroup2?GroupName=" + file.getGroupName() + "\"> 添加群组 </a></td>

</tr>
<%
}
%>
</table>


</form>
</center>
</body>
</html>