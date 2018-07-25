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
@WebServlet("/Search_User")
public class Search_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search_User() {
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
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String filename = "";
		String filepath ="" ;
		String fileid ="" ;
		Connection conn = DbUtils.getConnection();
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "select * from file,user_file where user_file.fileid = file.fileid and username like '%" + username + "%'"; 
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// 通过字段检索
				fileid = rs.getString("fileid");
				filename = rs.getString("filename");
				filepath = rs.getString("filepath");
				
				break;
			}
			rs.close();
			stmt.close();
			session.setAttribute("search_flag", "1");
			session.setAttribute("username", username);
			response.sendRedirect("/ShareSpace/search-user.jsp");
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
