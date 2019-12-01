package modules.users.functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import classes.DataConnection;
import functions.Functions;
import menu.menu_principal;

public class login {
	public static String getUsername;
	public static String getPassword;

	public static void main(String[] args) throws Exception {
		JTextField username = new JTextField();
		JPasswordField password = new JPasswordField();
		Object[] menu = { "Username", username, "Password", password };
		String botons[] = { "Login", "return" };
		Integer option = 0;
		boolean error = false;
		int resultado = 0;
		do {
			option = JOptionPane.showInternalOptionDialog(null, menu, "Login", 0, JOptionPane.QUESTION_MESSAGE, null,
					botons, botons[0]);
			if (option == -1 || option == 1) {
				error = false;
			} else {
				getUsername = username.getText();
				getPassword = String.valueOf(password.getPassword());
				Connection conn = null;
				try {
					try {
						conn = DataConnection.getConnection();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					PreparedStatement statement = conn.prepareStatement("SELECT * FROM Admin WHERE username='"
							+ getUsername + "' AND password='" + getPassword + "'");
					ResultSet resultdatos = statement.executeQuery();
					if (resultdatos.next()) {
						menu_principal.main(null);
						error = false;
					} else {
						Functions.mensajeerror("Usuario y/o contraseña incorrectos", "Error");
						error = true;
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e, "Error de conexión", JOptionPane.ERROR_MESSAGE);

					error = true;
				}
			}

		} while (error == true);

	}

	public static String getGetUsername() {
		return getUsername;
	}

	public static void setGetUsername(String getUsername) {
		login.getUsername = getUsername;
	}

	public static String getGetPassword() {
		return getPassword;
	}

	public static void setGetPassword(String getPassword) {
		login.getPassword = getPassword;
	}

}
