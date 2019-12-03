package classes;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnection {
	// Atributos
	private static Connection conn;
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String user = "root";
	private static String password = "";
	private static String url = "jdbc:mysql://localhost:3306/shop";

	// Conexion a la base de datos
	public static Connection getConnection() throws Exception {
		conn = null;
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conection!...");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;

	}
}
