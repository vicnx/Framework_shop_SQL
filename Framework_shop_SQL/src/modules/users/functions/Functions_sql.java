package modules.users.functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JLabel;
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

	public static void readAllClient() throws Exception {
		String name = "";
		String surname = "";
		String phone = "";
		String DNI = "";
		String email = "";
		String birthday = "";
		String registro = "";
		String idclient = "";
		String cad = "";
		Connection conn = DataConnection.getConnection();
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM Client");
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			name = result.getString("name");
			surname = result.getString("surname");
			phone = result.getString("phone");
			DNI = result.getNString("DNI");
			email = result.getString("email");
			birthday = result.getString("birthday");
			registro = result.getString("registro");
			idclient = result.getString("idclient");

			cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: " + DNI + "\nEmail: "
					+ email + "\nBirthday: " + birthday + "\nFecha registro: " + registro + "\nidcliente: " + idclient
					+ "\n\n";
			// System.out.println(result.getString("firstname"));
			// System.out.println(result.getString("lastname"));

		}
		if (cad.isEmpty()) {
			Functions.mensajeerror("No hay clientes en la BD", "Error");

		} else {
			JOptionPane.showMessageDialog(null, cad);
		}

	}

//deleteAdmin
	public static void deleteAdmin() throws Exception {
		JComboBox<String> combo = new JComboBox<String>();
		int option = 0;
		String selection = "";
		String consulta = "SELECT username FROM Admin ORDER by username ASC";
		String username = "";
		String opmenu[] = { "OK", "Cancel" };
		Connection conn = DataConnection.getConnection();
		PreparedStatement statement = conn.prepareStatement(consulta);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			username = result.getString("username");
			combo.addItem(username);
		}
		Object[] menu = { "Select a Admin to delete", combo };
		option = JOptionPane.showInternalOptionDialog(null, menu, "Admin", 0, JOptionPane.QUESTION_MESSAGE, null,
				opmenu, opmenu[0]);
		if (option == 1 || option == -1) {
			return;
		}
		selection = (String) combo.getSelectedItem();
		PreparedStatement eliminar = conn.prepareStatement("DELETE FROM Admin WHERE username='" + selection + "'");
		eliminar.executeUpdate();
	}

//deleteClient
	public static void deleteClient() throws Exception {
		JComboBox<String> combo = new JComboBox<String>();
		int option = 0;
		JLabel namel = new JLabel();
		String selection = "";
		String consulta = "SELECT idclient,name FROM Client ORDER by idclient ASC";
		String idclient = "";
		String name = "";
		String opmenu[] = { "OK", "Cancel" };
		Connection conn = DataConnection.getConnection();
		PreparedStatement statement = conn.prepareStatement(consulta);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			name = result.getString("name");
			idclient = result.getString("idclient");
			combo.addItem(idclient);
		}
		Object[] menu = { "Select a Client to delete", combo };
		option = JOptionPane.showInternalOptionDialog(null, menu, "Client", 0, JOptionPane.QUESTION_MESSAGE, null,
				opmenu, opmenu[0]);
		if (option == 1 || option == -1) {
			return;
		}
		selection = (String) combo.getSelectedItem();
		PreparedStatement eliminar = conn.prepareStatement("DELETE FROM Client WHERE idclient='" + selection + "'");
		eliminar.executeUpdate();
	}
}
