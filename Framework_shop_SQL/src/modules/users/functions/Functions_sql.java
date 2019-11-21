package modules.users.functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import classes.DataConnection;
import functions.Functions;

public class Functions_sql {
	// read all Admins
	public static void readAllAdmin() throws Exception {
		String name = "";
		String surname = "";
		String phone = "";
		String DNI = "";
		String email = "";
		String birthday = "";
		String username = "";
		String password = "";
		String cad = "";
		Connection conn = DataConnection.getConnection();
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM Admin");
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			name = result.getString("name");
			surname = result.getString("surname");
			phone = result.getString("phone");
			DNI = result.getNString("DNI");
			email = result.getString("email");
			birthday = result.getString("birthday");
			username = result.getString("username");
			password = result.getString("password");

			cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: " + DNI + "\nEmail: "
					+ email + "\nBirthday: " + birthday + "\nusername: " + username + "\npassword: " + password
					+ "\n\n";
			// System.out.println(result.getString("firstname"));
			// System.out.println(result.getString("lastname"));

		}
		if (cad.isEmpty()) {
			Functions.mensajeerror("No hay Admins en la BD", "Error");

		} else {
			JOptionPane.showMessageDialog(null, cad);
		}
	}
}
