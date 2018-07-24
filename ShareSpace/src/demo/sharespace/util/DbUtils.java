package demo.sharespace.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {

	// JDBC 驱动名及数据库 URL
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/sharespace?useUnicode=true&characterEncoding=utf-8&useSSL=true";

	// 数据库的用户名与密码，需要根据自己的设置
	private static final String USER = "root";
	private static final String PASS = "0725";

	private static Connection conn;

	static {
		try {
			// 注册 JDBC 驱动器
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}

	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
