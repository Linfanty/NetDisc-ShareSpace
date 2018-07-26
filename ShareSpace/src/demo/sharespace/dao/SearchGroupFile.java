package demo.sharespace.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import demo.sharespace.bean.FileBean;
import demo.sharespace.util.DbUtils;

	public class SearchGroupFile{

		public List<FileBean> getMyFileList(String Groupid) {
			System.out.println(Groupid);
			List<FileBean> fileBeans = new ArrayList<FileBean>();
			Connection conn = DbUtils.getConnection();
			try {
				// 执行 SQL 查询
				Statement stmt = conn.createStatement();
				String sql = "select * from gfile where  groupid = '" + Groupid + "'";
				ResultSet rs = stmt.executeQuery(sql);
				FileBean fileBean = null;
				// 展开结果集数据库
				while (rs.next()) {
					 fileBean = new FileBean();
					 // 通过字段检索
					 fileBean.setGroupId(rs.getString("groupid"));
					 fileBean.setGroupName(rs.getString("groupname"));
					 fileBean.setFileId(rs.getString("fileid"));
					 fileBean.setFileName(rs.getString("filename"));
					 //fileBean.setFileDesc(rs.getString("filedesc"));
					 //fileBean.setFileState(rs.getString("filestate"));
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