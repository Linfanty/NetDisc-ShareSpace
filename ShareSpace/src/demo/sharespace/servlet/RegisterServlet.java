package demo.sharespace.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.sharespace.util.DbUtils;
import demo.sharespace.util.StringUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			System.out.println("用戶名或密碼不能為空！");
			request.setAttribute("register_flag", "-1"); // register_flag = -1
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} 
		
		
		else {
			Connection conn = DbUtils.getConnection();
			Statement statement = null;
			try {
				statement = conn.createStatement();
				String sql = "insert into user (username, userpwd) values ('" + username + "' , '" + password + "')";
				statement.execute(sql);

				session.setAttribute("login_flag", "1"); // login_flag = 1
				session.setAttribute("username", username);
				response.sendRedirect("/ShareSpace/home.jsp");
				return;
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			request.setAttribute("register_flag", "-2");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}

}
