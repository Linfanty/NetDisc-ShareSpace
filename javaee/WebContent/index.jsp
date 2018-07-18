<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
<title>NetDisc</title>

<style> 
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	border: 1px soild #e7e7e7;
	background-color: #f3f3f3;
}

li{
	float: left;
}

li a{
	display: block;
	color: #666;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not(.active) {
	backgroud-color: #ddd;
}

li a.active{
	color: white;
	background-color: #4CAF50;
}
</style>

</head>
<body>


<ul>
	<li><a class = "active" href = "/Share-Space/" target = "_blank" >  Share Space </a> <li> &nbsp;
	<li><a href = "/My-Space/" target = "_self" > My Space </a> <li> &nbsp;
	<li><a href = "/Group-space/" target = "_parent" > Group Space </a> <li> &nbsp;

	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<li><a href = "/javaee/login.jsp" target = "_parent" > Login </a> <li> &nbsp;
	<li><a href = "/javaee/register.jsp" target = "_parent" > Register </a> <li> &nbsp;
<br>
</ul>

</body>
</html>