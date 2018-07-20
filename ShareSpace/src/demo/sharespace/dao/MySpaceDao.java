package demo.sharespace.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo.sharespace.bean.FileBean; // FileBean.java 一个遵循特定写法的Java类
import demo.sharespace.util.DbUtils; // DBUtils.java 连接数据库

public class MySpaceDao {

	public List<FileBean> getMyFileList(String userId) { // 得到我的文件列表
		List<FileBean> fileBeans = new ArrayList<FileBean>();
		Connection conn = DbUtils.getConnection();
		
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "select t1.fileid, t1.filename, t1.filepath "
					+ "from file t1 inner join user_file t2 "
					+ "on t1.fileid = t2.fileid "
					+ "where t2.userid = '" + userId + "'";
			
			ResultSet rs = stmt.executeQuery(sql);
			FileBean fileBean = null;
			// 展开结果集数据库
			while (rs.next()) {
				 fileBean = new FileBean();
				 // 通过字段检索
				 fileBean.setFileId(rs.getString("fileid"));
				 fileBean.setFileName(rs.getString("filename"));
				 fileBean.setFilePath(rs.getString("filepath"));
				 
				 fileBeans.add(fileBean); /// fileBeans
			}

			// 完成后关闭
			rs.close(); // 关闭数据库结果集
			stmt.close(); // 关闭数据集连接
		} catch (Exception e) { // 抛出数据库查询异常
			e.printStackTrace();
		}
		
		return fileBeans; // 返回一个List<FileBean> 由FileBean类形成的LIST列表
	}
	
}
