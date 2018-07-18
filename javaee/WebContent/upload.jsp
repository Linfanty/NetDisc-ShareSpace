<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传页面 - 网盘测试</title>

<style> <%-- 测试模块 --%> 
span{display:block;}
ul{
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 200px;
	backgroud-color: #f1f1f1;
}
li a{
	display: block;
	color: #000;
	padding: 8px 16px;
	text-decoration: none; 
}

li a.active{
	background-color: #4CAF50;
	color: white;
}

li a.hover:not(.active) {
	background-color： #555；
	color: white;
}


</style> 


</head>
<body>
<h1>文件上传页面 - 网盘测试V1.0</h1>
<form method="post" action="TomcatTest/UploadServlet" enctype="multipart/form-data">
    选择一个文件:
    <input type="file" name="uploadFile" />
    <br/><br/>
    <input type="submit" value="上传" />
</form>

<%-- 测试模块 
<ul>
<li><a href = "/html/" target = "_blank" > HTML </a> <li> &nbsp;
<li><a href = "/css/" target = "_self" > CSS </a> <li> &nbsp;
<li><a href = "/JSP/" target = "_parent" > JSP </a> <li> &nbsp;
<br>
<li><a href = "//www.baidu.com/"> X M L </a> <li> 
</ul>
--%>
<ul>
	<li> <a class = "active" href = "#home"> 主页</a> <li>
	<li> <a class = "news" > Find </a> <li>
	<li> <a class = "contact"> My Space </a> <li>
	<li> <a class = "about" > Group</a> <li>
</ul>



<h2> RadioHead </h2>
<span> Record: OK Computer </span>
<span> Year: 1997 </span>

</body>
</html>