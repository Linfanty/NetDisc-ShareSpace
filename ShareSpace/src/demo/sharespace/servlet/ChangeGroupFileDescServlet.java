package demo.sharespace.servlet;

import java.io.IOException;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.FileInfo;
import demo.sharespace.bean.FileBean;
import demo.sharespace.util.DbUtils;



/**
 * Servlet implementation class ChangeDescServlet
 */
@WebServlet("/ChangeGroupFileDescServlet")
public class ChangeGroupFileDescServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeGroupFileDescServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		String filedesc = request.getParameter("filedesc"); // 用来获取页面输入框输入的数据 用户名
		String fileid = request.getParameter("fileId"); // 用来获取页面输入框输入的数据 用户密码
		String groupid = (String)session.getAttribute("groupid");//取Session中groupid
		Connection conn = DbUtils.getConnection();
		
		System.out.println(filedesc);
		System.out.println(fileid);
		
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "update file set filedesc = '"+filedesc+"'  where file.fileid = '" + fileid + "' and gfile.groupid = '" + groupid + "' and file.fileid=gfile.fileid";
			stmt.execute(sql);
			stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/ShareSpace/GroupFile.jsp");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
