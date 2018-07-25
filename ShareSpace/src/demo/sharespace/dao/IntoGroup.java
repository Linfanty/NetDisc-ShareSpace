package demo.sharespace.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo.sharespace.bean.FileBean;
import demo.sharespace.util.DbUtils;

public class IntoGroup {

	public List<FileBean> getMyFileList(String groupname) {	
		List<FileBean> fileBeans = new ArrayList<FileBean>();
		Connection conn = DbUtils.getConnection();
		try {
			// 执行 SQL 查询
			Statement stmt = conn.createStatement();
			String sql = "select groupname,groupid,groupdesc from sgroup where groupname like '%" + groupname + "%'";
			ResultSet rs = stmt.executeQuery(sql);
			FileBean fileBean = null;
			// 展开结果集数据库
			while (rs.next()) {
				 fileBean = new FileBean();
				 // 通过字段检索
				 fileBean.setGroupName(rs.getString("groupname"));
				 fileBean.setGroupId(rs.getString("groupid"));
				 fileBean.setGroupDesc(rs.getString("groupdesc")); 
				 System.out.println(groupname + "   " + rs.getString("groupname") + "  " + rs.getString("groupid"));
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
