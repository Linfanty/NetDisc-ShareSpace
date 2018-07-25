package demo.sharespace.servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.sharespace.util.DbUtils;

/**
 * Servlet implementation class ExitGroup
 */
@WebServlet("/ExitGroup")
public class ExitGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExitGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String groupid = request.getParameter("GroupId");
		String userid = (String)session.getAttribute("userid");
		
		int i  = Integer.parseInt(groupid);
		int j  = Integer.parseInt(userid);
		Connection conn = DbUtils.getConnection();
		System.out.println(i + "  " + j);
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "delete from guser where groupid = "+i+" and userid = "+j+" ";
			
			stmt.execute(sql);
			stmt.close();	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/ShareSpace/Group.jsp"); // 重定向 页面跳转 绝对路径 地址栏信息改变，可以跳转到任意网页。 
	}

}
