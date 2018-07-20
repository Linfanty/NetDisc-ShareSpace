package demo.sharespace.servlet;

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
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet") // 类级别的注解
// 表示访问该servlet的 url 映射（地址）（此处为相对路径，即 “项目名称/DownloadServlet” ）。
// 该注解的作用等价于 在web.xml中配置的该servlet的<servlet-mapping>元素中<url-pattern>的配置

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	// 复写 javax.servlet.http.HttpServlet.doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:").append(request.getContextPath());
		
		// \"/ShareSpace/DownloadServlet?fileId=" + file.getFileId() + "\"
		String fileId = (String) request.getParameter("fileId"); // 得到request中存储的 fileId 用户对象信息
		String fileName = "";
		String filePath = "";
		Connection conn = DbUtils.getConnection();
		
		
		System.out.println("文件Id为：" + fileId);
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "select filename, filepath from file where fileid = '" + fileId + "'";
			// 查询相同的文件ID
			ResultSet rs = stmt.executeQuery(sql);
			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				fileName = rs.getString("filename");
				filePath = rs.getString("filepath");
				System.out.println("文件路径为：" + filePath + "   文件名为：  " + fileName);
				break;
			}
			
			// 完成后关闭
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		File file = new File(filePath);
		if (file.exists()) { // 下载文件
			FileInputStream fis = new FileInputStream(file);
			fileName = URLEncoder.encode(fileName, "UTF-8");
			
			byte[] bs = new byte[fis.available()];
			fis.read(bs);
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
			ServletOutputStream os = response.getOutputStream(); //  获得字节流 写字节 上传文件
			os.write(bs);
			os.flush();
			os.close();
			fis.close();
		} else {
			System.out.println("文件不存在：" + filePath);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
