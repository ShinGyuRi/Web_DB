package kr.co.sku.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// ����
	public static Connection getConnection() throws Exception {
		Connection conn = null;
		// 3. ����̹��ε�... ( �� ��񺥴��� ������ Ŭ������ �޸𸮿� �÷���)
		

		// 4. ����
		String url = "jdbc:oracle:thin:@127.0.0.1:1523:xe";
		String user = "scott";
		String password = "tiger";
		conn = DriverManager.getConnection(url, user, password);

		return conn;
	}
	public static void close(Connection conn, Statement ps, ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(conn, ps);
	}

	// �ݱ�
	public static  void close(Connection conn, Statement ps){
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
