package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {
	public static Connection con;

	public static Connection conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/curso?user=root&password=root&useSSL=false&serverTimezone=UTC";
			con = DriverManager.getConnection(url);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return con;
	}

	public static void desconexion() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
