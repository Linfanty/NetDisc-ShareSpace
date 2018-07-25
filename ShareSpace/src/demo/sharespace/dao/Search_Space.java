package demo.sharespace.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo.sharespace.bean.FileBean;
import demo.sharespace.util.DbUtils;

public class Search_Space {

	public List<FileBean> getMyFileList( String userid) {
		List<FileBean> fileBeans = new ArrayList<FileBean>();
		Connection conn = DbUtils.getConnection();
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "select * from file,user_file where user_file.fileid=file.fileid and username like '%" + userid + "%'";
			ResultSet rs = stmt.executeQuery(sql);
			FileBean fileBean = null;
			// 展开结果集数据库
			while (rs.next()) {
				 fileBean = new FileBean();
				 // 通过字段检索
				 fileBean.setUserName(rs.getString("username"));
				 fileBean.setFileId(rs.getString("fileid"));
				 System.out.println(rs.getString("username") + "    " + rs.getString("fileid") );
				 
				 
				 fileBean.setFileName(rs.getString("filename"));
				 fileBean.setFilePath(rs.getString("filepath"));
				 fileBeans.add(fileBean);
			}

			// 完成后关闭
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fileBeans;
	}
	
}
