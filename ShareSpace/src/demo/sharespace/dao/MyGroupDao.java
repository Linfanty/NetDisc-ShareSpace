package demo.sharespace.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.regexp.internal.RE;

import demo.sharespace.bean.FileBean;
import demo.sharespace.util.DbUtils;

public class MyGroupDao {

	public List<FileBean> getMyFileList(String userid) {
		List<FileBean> fileBeans = new ArrayList<FileBean>();
		Connection conn = DbUtils.getConnection();
		try {
			// 执行 SQL 查询
			System.out.println("userid为：" + userid);
			Statement stmt = conn.createStatement();
			String sql = "select * from sgroup,guser " +
					"where sgroup.groupid = guser.groupid and guser.userid = '" + userid + "'";
			ResultSet rs = stmt.executeQuery(sql);
			FileBean fileBean = null;
			
			String U = null;
			String N = null;
			
			// 展开结果集数据库
			while (rs.next()) {
				 fileBean = new FileBean();
				 // 通过字段检索
				 int groupidd = Integer.parseInt(rs.getString("groupid"));
				 String sql0 = "select * from sgroup where groupid = "+groupidd+"";
				 Statement stmt0 = conn.createStatement();
				 ResultSet rs0 = stmt0.executeQuery(sql0);
				 int fg = 0;
				 while (rs0.next()) {
					 System.out.println("userid                   为：" + userid);
					 System.out.println("rs0.getString(\"userid\")为：" + rs0.getString("userid") );
					 
					 if( !userid.equals(rs0.getString("userid"))    ) {
						 int uidd = Integer.parseInt(rs0.getString("userid")); 
						 
						 String sql00 = "select * from user where userid = "+uidd+"   ";
						 Statement stmt00 = conn.createStatement();
						 ResultSet rs00 = stmt00.executeQuery(sql00);
						 
						 while( rs00.next() ) {
							 U = rs00.getString("userid");
							 N = rs00.getString("username");
						 }
						 rs00.close();
						 stmt00.close();
					 } 
					 else fg = 1;
				 }
				 
				 System.out.println("U： " + U + "   flag:" + fg );
				 if( fg == 1) {
					 fileBean.setGroupId(rs.getString("groupid"));
					 fileBean.setGroupName(rs.getString("groupname"));
					 fileBean.setUserId(rs.getString("userid"));
					 fileBean.setUserName(rs.getString("username"));
				 }
				 else {
					 fileBean.setGroupId(rs.getString("groupid"));
					 fileBean.setGroupName(rs.getString("groupname"));
					 fileBean.setUserId(U);
					 fileBean.setUserName(N);
				 }
				 
				 
				 rs0.close();
				 stmt0.close();
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
