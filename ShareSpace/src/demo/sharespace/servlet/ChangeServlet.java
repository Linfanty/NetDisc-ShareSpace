package demo.sharespace.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
 * Servlet implementation class ChangeServlet
 */
@WebServlet("/ChangeServlet")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String fileId = (String) request.getParameter("fileId"); // 得到request中存储的 fileId 用户对象信息
		String fileName = "";
		String filePath = "";
		Connection conn = DbUtils.getConnection();
		
		System.out.println("文件Id为：" + fileId);
		int cg = -1;
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "select * from file  where fileid = '" + fileId + "' ";
			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				String midState = rs.getString("filestate"); // 得到 state
				
				if(midState.equals("公开") )
					cg = 1;
				else cg = 0;
				System.out.println(midState + "  "+ cg);
				break;
			}

			// 完成后关闭
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			
			if( cg == 1) {
				String sql = "update file set filestate = '私密'    where fileid = '" + fileId + "'";
			    stmt.execute(sql);
				stmt.close();
			}	
			else {
				String sql = "update file set filestate = '公开'    where fileid = '" + fileId + "'";
			    stmt.execute(sql);
				stmt.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("/ShareSpace/home.jsp");
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
