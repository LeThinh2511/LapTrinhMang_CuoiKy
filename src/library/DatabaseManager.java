package library;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManager {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/QuanLySach", "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
