<%@ page language="java" import="java.sql.*" contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>检验注册页面</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 
  </head>
  
  <body>
    <br>
   <%
   request.setCharacterEncoding("utf-8");
   String users = request.getParameter("username");
   String pass = request.getParameter("pwd");
   ResultSet rs = null;
   boolean flag = false;
   %>
   <% 
    String driver = "com.mysql.jdbc.Driver";  
    String url = "jdbc:mysql://localhost:3306/netdisc";  
    String use = "root";   
    String password = "0725";  
    Class.forName(driver);  
    
    Connection conn = DriverManager.getConnection(url, use, password);  
    PreparedStatement sql = conn.prepareStatement("insert into user(usename, usepwd) values(?,?) ");
    // PreparedStatement sql = conn.prepareStatement("select * from user values(?, ?, ?, ?)");
    sql.setString(1, users); //把输入的用户名username 赋值给数据库的第一项
    sql.setString(2, pass);  //把输入的密码pwd 赋值给数据库的第二项
    
    // String tiaoshu = null;
    // sql.setString(1, tiaoshu);
    
    PreparedStatement sql2 = conn.prepareStatement("select * from user where usename = '"+users+"' ");
    rs = sql2.executeQuery();
    if ( rs.next() ) 
   		 flag = true;
        
    %>
    
    <!-- 判断是否是正确的登录用户 -->
<% 
	if (flag == false){  // 创建用户
		int rtn = sql.executeUpdate(); 
		sql.close();
		conn.close();
	%>
	<jsp:forward page = "register_success.jsp" /> <!--注册成功 -->
	<%	} else if (flag == true ){ %>
	<jsp:forward page = "register_fail.jsp"/> <!--登录失败 -->
	<% } %>


  </body>
</html>