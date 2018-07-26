package demo.sharespace.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.sharespace.util.DbUtils;

/**
 * Servlet implementation class AddUser2
 */
@WebServlet("/AddUser2")
public class AddUser2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String GroupId = request.getParameter("GroupId");
		Connection conn = DbUtils.getConnection();
		
		HttpSession session = request.getSession();
		String username2 = (String)session.getAttribute("username2");
		
		System.out.println("username2为：" + username2);
		System.out.println("GroupId为："+ GroupId);
		
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql0 = "select * from user where username = '"+username2+"'";
			ResultSet rs = stmt.executeQuery(sql0);
			// 展开结果集数据库
			int userid = 0;
			while(rs.next()) {
				userid = rs.getInt("userid");
				System.out.println("userid为："+ userid);
				break;
			}
			
			
			String sql00 = "select * from guser where userid = "+userid+" and groupid = "+ GroupId +" ";
			stmt.execute(sql00);
			ResultSet rs00 = stmt.executeQuery(sql00);
			int flag = 0;
			while(rs00.next()) {
				flag = 1;
				break;
			}
			
			
			System.out.println("flag为："+ flag);
			if(flag == 1)
			{
				rs.close();
				stmt.close();
				response.sendRedirect("/ShareSpace/GroupUser.jsp?GroupId=" + GroupId);
			}
			else {
				String sql = "insert into guser(groupid,userid,username) "
						+ "values("+ GroupId +", "+userid+", '"+username2+"')";
			    stmt.execute(sql);	
			    rs.close();
				stmt.close();
				response.sendRedirect("/ShareSpace/GroupUser.jsp?GroupId=" + GroupId);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
