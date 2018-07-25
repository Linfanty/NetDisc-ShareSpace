package demo.sharespace.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.sharespace.util.DbUtils;

/**
 * Servlet implementation class CreateGroup
 */
@WebServlet("/CreateGroup")
public class CreateGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String groupname = request.getParameter("groupname"); // 用来获取页面输入框输入的数据 群组名称
		String userid = request.getParameter("userid"); // 用来获取页面输入框输入的数据 用户密码
		String groupdesc = request.getParameter("groupdesc"); 
		Connection conn = DbUtils.getConnection();
		
		int u = Integer.parseInt(userid);
		
		System.out.println(groupname);
		System.out.println(u);
		System.out.println(groupdesc);
		
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "insert into sgroup(groupname, groupdesc, userid) values('"+groupname+"', '"+groupdesc+"', '"+u+"')";
			stmt.execute(sql);
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/ShareSpace/space/GroupSpace.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
