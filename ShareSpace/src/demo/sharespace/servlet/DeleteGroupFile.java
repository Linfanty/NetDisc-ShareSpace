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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteGroupFile")
public class DeleteGroupFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteGroupFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String fileId = (String) request.getParameter("fileId"); // 得到request中存储的 fileId 用户对象信息
		String groupid = (String) session.getAttribute("groupid");		
		Connection conn = DbUtils.getConnection();		
		System.out.println("文件/群Id为：" + fileId +"/" + groupid);
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "delete from gfile where fileid = '" + fileId + "' and groupid = '" + groupid + "'";
			// 查询相同的文件ID
		    stmt.execute(sql);
			// 展开结果集数据库
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		response.sendRedirect("/ShareSpace/GroupFile.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
