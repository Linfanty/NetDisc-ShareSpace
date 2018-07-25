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
 * Servlet implementation class IntoGroup2
 */
@WebServlet("/IntoGroup2")
public class IntoGroup2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IntoGroup2() {
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
		String username = (String)session.getAttribute("username");
		String groupname = "";
		
		int i  = Integer.parseInt(groupid);
		int j  = Integer.parseInt(userid);
		Connection conn = DbUtils.getConnection();
		
		int flag = 0;
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "select * from guser where groupid = "+groupid+" ";
			
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// 通过字段检索
				groupname = rs.getString("groupname");
				int gid2 = rs.getInt("groupid");
				if(i == gid2)  {
					response.sendRedirect("/ShareSpace/GroupIntoFail.jsp");
					flag = 1;
				}	
				break;
			}
			rs.close();
			stmt.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		if( flag == 0)
		{
			System.out.println(i + "  " + j + "   " + username + groupname);
			

			try {
				// 执行 SQL 查询
				Statement stmt = conn.createStatement();
				String sql = "insert into guser(groupid,userid,username,groupname) values (" + i +" ,  " + j + " , '" + username + "' , '" + groupname + "')";
				stmt.execute(sql);
				stmt.close();
				response.sendRedirect("/ShareSpace/Group.jsp");
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		


	}

}
