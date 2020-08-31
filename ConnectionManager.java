package new_board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {


		// TODO 自動生成されたメソッド・スタブ

		final static String DRIVER = "com.mysql.cj.jdbc.Driver";

		final static String URL = "jdbc:mysql://localhost/test?serverTimezone=JST&useUnicode=true&characterEncoding=utf8";

		final static String USER = "root";

		final static String PASS = "hiroaki";



		public static Connection getConnection()
			throws SQLException {
				try {
					Class.forName(DRIVER);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					throw new IllegalStateException(
							"fail to class load :"
									+ e.getMessage());
				}
				Connection con = DriverManager.getConnection(URL, USER, PASS);
				return con;
			}

}
