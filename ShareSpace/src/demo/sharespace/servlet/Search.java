package demo.sharespace.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		String filename = request.getParameter("filename");
		String filepath ="" ;
		String fileid ="" ;
		Connection conn = DbUtils.getConnection();
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "select * from file where filename like '%" + filename + "%' and filestate = '公开' ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// 通过字段检索
				fileid = rs.getString("fileid");
				filepath = rs.getString("filepath");
				break;
			}
			rs.close();
			stmt.close();
			session.setAttribute("search_flag", "1");
			session.setAttribute("filename", filename);
			response.sendRedirect("/ShareSpace/search.jsp");
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
