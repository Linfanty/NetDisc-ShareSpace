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
 * Servlet implementation class Search_User
 */
@WebServlet("/Search_User2")
public class Search_User2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search_User2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String GroupId = request.getParameter("GroupId");
		request.setCharacterEncoding("UTF-8");
		String username2 = request.getParameter("username2");
		System.out.println(username2);
		Connection conn = DbUtils.getConnection();
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "select * from user where username like '%" + username2 + "%'"; 
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// 通过字段检索
				username2 = rs.getString("username");
				System.out.println(username2);
			}
			
			rs.close();
			stmt.close();
			
			session.setAttribute("username2", username2);
			response.sendRedirect("/ShareSpace/AddUser.jsp?GroupId=" + GroupId);
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
