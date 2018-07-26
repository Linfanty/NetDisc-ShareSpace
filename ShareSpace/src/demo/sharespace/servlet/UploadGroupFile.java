package demo.sharespace.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import demo.sharespace.util.DbUtils;
import demo.sharespace.util.RequestUtils;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadGroupFile")
public class UploadGroupFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 上传文件存储目录
	private static final String UPLOAD_DIRECTORY = "upload";

	// 上传配置
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadGroupFile() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// TODO Auto-generated method stub
		// doGet(request, response);

		// 检测是否为多媒体上传
		if (!ServletFileUpload.isMultipartContent(request)) {
			// 如果不是则停止
			PrintWriter writer = response.getWriter();
			writer.println("Error: 表单必须包含 enctype=multipart/form-data");
			writer.flush();
			return;
		}

		// 配置上传参数
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// 设置临时存储目录
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);

		// 设置最大文件上传值
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// 设置最大请求值 (包含文件和表单数据)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// 中文处理
		upload.setHeaderEncoding("UTF-8");

		// 构造临时路径来存储上传的文件
		// 这个路径相对当前应用的目录
		// String uploadPath = request.getServletContext().getRealPath("./") +
		// File.separator + UPLOAD_DIRECTORY;
		String uploadPath = "F:\\2018JAVA_WEB" + File.separator + UPLOAD_DIRECTORY;

		// 如果目录不存在则创建
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		String groupnamee = null;
		try {
			// 解析请求的内容提取文件数据
			@SuppressWarnings("unchecked")
			List<FileItem> formItems = upload.parseRequest(request);

			if (formItems != null && formItems.size() > 0) {
				// 迭代表单数据
				for (FileItem item : formItems) {
					// 处理不在表单中的字段
					if (!item.isFormField()) {
						String filename = new File(item.getName()).getName();
						String groupid = (String)session.getAttribute("groupid");
						
						String fileName = new File(item.getName()).getName(); // 文件名 == getName名
						String uuid = UUID.randomUUID().toString(); // 文件夹 随机UID 名
						String fileDirStr = uploadPath + File.separator + uuid;
						File fileDir = new File(fileDirStr);
						if (!fileDir.exists()) { // 创建文件夹
							fileDir.mkdir();
						}
						//					文件路径  = 上传路径 + \\ 随机文件夹名 + \\ + 文件名
						String filePath = uploadPath + File.separator + uuid + File.separator + fileName;
						File storeFile = new File(filePath); // 存储
						
						// 在控制台输出文件的上传路径
						System.out.println(filePath);
						// 保存文件到硬盘
						item.write(storeFile);
						request.setAttribute("message", "文件上传成功!");// 把 文件上传成功! 传给 message
						
						int groupidd = Integer.parseInt(groupid);
						Connection conn = DbUtils.getConnection();
						Statement stmt = conn.createStatement();
						String sql = "select * from sgroup where groupid = "+groupidd+" ";
						ResultSet rs = stmt.executeQuery(sql);
						while( rs.next() ) {
							groupnamee = (String)rs.getString("groupname");
							
						}					
						insertFileInfo2DB(filename, groupidd, uuid, groupnamee);
						}
					}
				}
			}	
			 catch (Exception e) {
				e.printStackTrace();
		    }
		response.sendRedirect("/ShareSpace/GroupFile.jsp");
	 }
//存入数据库
	private void insertFileInfo2DB(String filename, int groupid, String fileid ,String groupname) {
		Connection conn = DbUtils.getConnection();
		Statement statement = null;
		try {
			statement = conn.createStatement();
			System.out.println(groupid + "    "  + fileid +  "    " +   groupname +  "    " +  filename); /////////////////
			String sql = "insert into gfile(groupid,fileid,groupname,filename) "
					+ " values("+groupid+" , '"+fileid+"' , '"+groupname+"' , '"+filename+"')";
			statement.execute(sql);	
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

	}

}
