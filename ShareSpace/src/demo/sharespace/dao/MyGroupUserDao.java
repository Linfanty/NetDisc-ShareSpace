package demo.sharespace.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.RE;

import demo.sharespace.bean.FileBean;
import demo.sharespace.util.DbUtils;

public class MyGroupUserDao {
	public List<FileBean> getMyFileList(String groupid) {
		List<FileBean> fileBeans = new ArrayList<FileBean>();
		Connection conn = DbUtils.getConnection();
		int gid  = Integer.parseInt(groupid);
		
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "select * from guser where groupid = "+gid+"";
			ResultSet rs = stmt.executeQuery(sql);
			FileBean fileBean = null;
			// 展开结果集数据库
			
			while (rs.next()) {
				 fileBean = new FileBean();
				 // 通过字段检索
				 fileBean.setUserId(rs.getString("userid"));
				 fileBean.setUserName(rs.getString("username"));
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
