package modules.users.functions;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import classes.Fecha;
import functions.Functions;
import functions.validate;

public class Datos_users {
	// Name
	public static String pidename() {
		String name = "";
		boolean correcto = false;
		do {
			name = JOptionPane.showInputDialog("Give me the new Name of the client");
			if (name == null) {
				return null;
			}
			if (validate.validaname(name) == false) {
				Functions.mensajeerror("Error, please use only letters", "Error");
				correcto = false;
			} else {
				correcto = true;
			}
		} while (correcto == false);
		return name;
	}

	// Surname
	public static String pidesurname() {
		String surname = "";
		boolean correcto = false;
		do {
			surname = JOptionPane.showInputDialog("Give me the new Surname of the client");
			if (surname == null) {
				return null;
			}
			if (validate.validasurname(surname) == false) {
				Functions.mensajeerror("Error, please use only letters", "Error");
				correcto = false;
			} else {
				correcto = true;
			}
		} while (correcto == false);
		return surname;
	}

	// Phone
	public static String pidephone() {
		String phone = "";
		boolean correcto = false;
		do {
			phone = JOptionPane.showInputDialog("Give me the new Phone of the client");
			if (phone == null) {
				return null;
			}
			if (validate.validaphone(phone) == false) {
				Functions.mensajeerror("Error, please use a valid Phone", "Error");
				correcto = false;
			} else {
				correcto = true;
			}
		} while (correcto == false);
		return phone;
	}

	// DNI
	public static String pidedni() {
		String dni = "";
		boolean correcto = false;
		do {
			dni = JOptionPane.showInputDialog("Give me the new DNI of the client");
			if (dni == null) {
				return null;
			}
			if (validate.validadni(dni) == false) {
				Functions.mensajeerror("Error, please use a valid DNI 8numbers and 1 letter", "Error");
				correcto = false;
			} else {
				correcto = true;
			}
		} while (correcto == false);
		return dni;
	}

	// Email
	public static String pideemail() {
		String email = "";
		boolean correcto = false;
		do {
			email = JOptionPane.showInputDialog("Give me the new Email of the client");
			if (email == null) {
				return null;
			}
			if (validate.validaemail(email) == false) {
				Functions.mensajeerror("Error, please use a valid email", "Error");
				correcto = false;
			} else {
				correcto = true;
			}
		} while (correcto == false);
		return email;
	}

	// Birthday
	public static Fecha pidebirthday() {
		String fecha = "";
		Fecha f = null;
		boolean correcto = false;
		do {
			fecha = JOptionPane.showInputDialog("Give me the new date");
			if (fecha == null) {
				return null;
			}
			if (validate.validafecha(fecha) == false) {
				Functions.mensajeerror("Error, please set the correct date format\n(dd/mm/yyyy)", "Error");
				correcto = false;
			} else {
				f = new Fecha(fecha);
				if (f.vfecha() == true) {
					if (f.comparaNacimiento() == false) {
						Functions.mensajeerror("Error, set a date before 01/01/2008", "Error");
						correcto = false;
					} else {
						correcto = true;
					}
				} else {
					Functions.mensajeerror("Error, please set a valid date!", "Error");
					correcto = false;
				}
			}
		} while (correcto == false);
		return f;
	}

	// IDCLIENTE
	public static String pideidcliente() {
		boolean correcto = false;
		String id = "";
		do {
			id = JOptionPane.showInputDialog("Give me the new ID CLIENT");
			if (id == null) {
				return null;
			}
			if (validate.validaidclient(id) == false) {
				Functions.mensajeerror("Error, please set a correct ID (8 Numbers and 3 Letters)", "Error");
				correcto = false;
			} else {
				correcto = true;
			}
		} while (correcto == false);
		return id;
	}

	// Username
	public static String pideusername() {
		boolean correcto = false;
		String username = "";
		do {
			username = JOptionPane.showInputDialog("Give me the new username");
			if (username == null) {
				return null;
			}
			if (validate.validausername(username) == false) {
				Functions.mensajeerror("Please set a correct Username", "Error");
				correcto = false;
			} else {
				correcto = true;
			}
		} while (correcto == false);
		return username;
	}

	// Password
	public static String pidepassword() {
		boolean correcto = false;
		String p = "";
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Enter a new password:");
		JPasswordField pass = new JPasswordField(8);
		panel.add(label);
		panel.add(pass);
		String[] options = new String[] { "OK", "Cancel" };
		do {
			int option = JOptionPane.showOptionDialog(null, panel, "Password", JOptionPane.NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
			if (option == -1 || option == 1) {
				return null;
			}
			if (option == 0) // pressing OK button
			{
				char[] password = pass.getPassword();
				System.out.println("Your password is: " + new String(password));
				p = password.toString();
				correcto = true;
			}
		} while (correcto == false);
		return p;
	}
}
