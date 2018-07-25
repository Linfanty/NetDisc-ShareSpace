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
 * Servlet implementation class MyGroupList
 */
@WebServlet("/MyGroupList")
public class MyGroupList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyGroupList() {
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
		String groupname = "";
		String username = "";
		String userid = (String)session.getAttribute("userid");
		Connection conn = DbUtils.getConnection();
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "select sgroup.groupname,user.userid,user.username from sgroup,user,guser " +
					"where sgroup.groupid = guser.groupid and user.userid = guser.userid and user.userid = '" + userid + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// 通过字段检索
				username = rs.getString("username");
				groupname = rs.getString("groupname");
				break;
			}
			
			rs.close();
			stmt.close();
			session.setAttribute("username",username);
			session.setAttribute("groupname",groupname);
			response.sendRedirect("/ShareSpace/Group.jsp");
		}catch (SQLException e) {
			e.printStackTrace();
		}

		
		
	}

}
