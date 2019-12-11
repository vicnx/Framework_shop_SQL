package classes;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnection {
	// Atributos
	private static Connection conn;
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String user = "vicnx";
	private static String password = "12345678";
	private static String url = "jdbc:mysql://localhost:3306/Shop";

	// Conexion a la base de datos
	public static Connection getConnection() throws Exception {
		conn = null;
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			// Connection conn =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/Shop", "root",
			// "12345678");
			System.out.println("Conection!...");
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;

	}
}
