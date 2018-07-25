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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) // 表单的提交一般用post方式，而不用get方式。
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username"); // 用来获取页面输入框输入的数据 用户名
		String password = request.getParameter("password"); // 用来获取页面输入框输入的数据 用户密码
		Connection conn = DbUtils.getConnection();
		boolean checkSuccess = false;
		
		String userid = ""; // 用户ID
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "select userid, username "
					+ "from user "
					+ "where username = '" + username + "' and userpwd = '" + password + "' ";
			
			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				userid = rs.getString("userid"); // 得到 用户Id
				String name = rs.getString("username"); // 得到 用户名
				checkSuccess = username.equals(name); // 输入的用户名 == 得到的用户名
				break;
			}

			// 完成后关闭
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (checkSuccess) {  // 校验成功
			// request.setAttribute("login_flag", "1");
			// request.setAttribute("username", username);
			// request.getRequestDispatcher("/home.jsp").forward(request,
			// response);

			session.setAttribute("login_flag", "1");  // login_flag 是 1
			session.setAttribute("username", username); // username 是 username
			session.setAttribute("userid", userid); // userid 是 userid
			response.sendRedirect("/ShareSpace/home.jsp"); // 重定向 页面跳转 绝对路径 地址栏信息改变，可以跳转到任意网页。 
		} else {
			session.setAttribute("login_flag", "-1"); // 登录不成功 login_flag 是 -1
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			// 服务器内部跳转，地址栏信息不变，只能跳转到web应用内的网页 可以是相对路径也可以是绝对路径。 
			// request.getRequestDispatcher("想跳转的servlet名").forward(request, response);
		}
	}

}
