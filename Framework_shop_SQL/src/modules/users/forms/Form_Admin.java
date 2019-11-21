package modules.users.forms;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import classes.DataConnection;
import classes.Fecha;
import functions.Functions;
import functions.validate;

public class Form_Admin {
	public static void FormAdmin() {
		String caderrors = "", getName = "", getSurname = "", getPhone = "", getDNI = "", getEmail = "",
				getUsername = "", getPassword = "", getBirthday = "";
		Fecha birthday = null;
		boolean error = false;
		String optionmenu[] = { "Create", "Return" };
		Integer option = 0;
		JTextField name = new JTextField();
		JTextField surname = new JTextField();
		JTextField phone = new JTextField();
		JTextField email = new JTextField();
		JTextField username = new JTextField();
		JPasswordField password = new JPasswordField();
		JTextField dni = new JTextField();
		JTextField fbirthday = new JTextField();
		// Creamos unos bordes para apariencia
		Border bordererror = BorderFactory.createLineBorder(Color.RED, 1);
		Border borderdefault = new JTextField().getBorder();
		// Creamos el panel en un objeto para que aparezca en una ventan.
		Object[] menu = { "Create new Administrator\n\n", "Name", name, "Surname", surname, "Phone (Ex: 623456789)",
				phone, "Email (Ex: yourname@email.com)", email, "DNI (Ex: 12345678A) ", dni, "Username", username,
				"Password", password, "Date Birthday", fbirthday };
		do {
			name.setText("Admin");
			surname.setText("Admin");
			phone.setText("686868686");
			email.setText("admin@shop.com");
			dni.setText("12345678A");
			username.setText("admin");
			password.setText("Password1$");
			fbirthday.setText("10/04/2000");
			caderrors = "";
			error = false;
			option = JOptionPane.showInternalOptionDialog(null, menu, "Admin", 0, JOptionPane.QUESTION_MESSAGE, null,
					optionmenu, optionmenu[0]);
			if (option == -1 || option == 1) {
				return;
			}
			// input name
			name.setBorder(borderdefault);
			getName = name.getText();
			if (getName.isEmpty()) {// Si esta vacio entra en el error.
				name.setBorder(bordererror);
				caderrors = caderrors + "- Name empty\n";
				error = true;
			} else {
				if (validate.validaname(getName) == false) {
					name.setBorder(bordererror);
					caderrors = caderrors + "- Name Incorrect, use only letters\n";
					error = true;
				}
			}
			// Input Surname
			surname.setBorder(borderdefault);
			getSurname = surname.getText();
			if (getSurname.isEmpty()) {// Si esta vacio entra en el error.
				surname.setBorder(bordererror);
				caderrors = caderrors + "- Surname empty\n";
				error = true;
			} else {
				if (validate.validasurname(getSurname) == false) {
					surname.setBorder(bordererror);
					caderrors = caderrors + "- Surname Incorrect, use only letters\n";
					error = true;
				}
			}
			// Input phone
			phone.setBorder(borderdefault);
			getPhone = phone.getText();
			if (getPhone.isEmpty()) {
				phone.setBorder(bordererror);
				caderrors = caderrors + "- Phone empty\n";
				error = true;
			} else {
				if (validate.validaphone(getPhone) == false) {
					phone.setBorder(bordererror);
					caderrors = caderrors + "- Phone Incorrect\n";
					error = true;
				}
			}
			// Input email
			email.setBorder(borderdefault);
			getEmail = email.getText();
			if (getEmail.isEmpty()) {
				email.setBorder(bordererror);
				caderrors = caderrors + "- Email empty\n";
				error = true;
			} else {
				if (validate.validaemail(getEmail) == false) {
					email.setBorder(bordererror);
					caderrors = caderrors + "- Email Incorrect\n";
					error = true;
				}
			}
			// Input DNI
			dni.setBorder(borderdefault);
			getDNI = dni.getText();
			if (getDNI.isEmpty()) {
				dni.setBorder(bordererror);
				caderrors = caderrors + "- DNI empty\n";
				error = true;
			} else {
				if (validate.validadni(getDNI) == false) {
					dni.setBorder(bordererror);
					caderrors = caderrors + "- DNI Incorrect\n";
					error = true;
				}
			}
			// Input Username
			username.setBorder(borderdefault);
			getUsername = username.getText();
			if (getUsername.isEmpty()) {
				username.setBorder(bordererror);
				caderrors = caderrors + "- Username empty\n";
				error = true;
			} else {
				if (validate.validausername(getUsername) == false) {
					username.setBorder(bordererror);
					caderrors = caderrors + "- Username Incorrect\n";
					error = true;
				}
			}
			// Input password
			password.setBorder(borderdefault);
			char[] p = password.getPassword();
			getPassword = p.toString();
			System.out.println("Password is: " + new String(p));
			// getPassword = password.getText();
			if (getPassword.isEmpty()) {
				password.setBorder(bordererror);
				caderrors = caderrors + "- Password empty\n";
				error = true;
			} else {
				if (validate.validapass(getPassword) == false) {
					password.setBorder(bordererror);
					caderrors = caderrors + "- Password Incorrect(At least 8 chars, Contains at least one digit\n"
							+ "     Contains at least one lower alpha char and one upper alpha char\n"
							+ "     Contains at least one char within a set of special chars (@#%$^ etc.), Does not contain space, tab, etc.\n";
					error = true;
				}
			}
			// Input Fecha nacimiento
			fbirthday.setBorder(borderdefault);
			if (fbirthday.getText().isEmpty()) {
				fbirthday.setBorder(bordererror);
				caderrors = caderrors + "- Fecha Birthday empty\n";
				error = true;
			} else {
				getBirthday = fbirthday.getText();
				if (validate.validafecha(getBirthday) == true) {
					birthday = new Fecha(getBirthday);
					if (birthday.vfecha() == true) {
						if (birthday.comparaNacimiento() == false) {
							caderrors = caderrors + "- Ser a date before 01/01/2008\n";
							error = true;
						}
					} else {
						caderrors = caderrors + "- Insert a valid date!\n";
						error = true;
					}
				} else {
					fbirthday.setBorder(bordererror);
					caderrors = caderrors + "- Set a corret date\n (dd/mm/yyyy)\n";
					error = true;
				}
			}
			// Si sale un error entra en el IF y los muestra todos.
			if (error == true) {
				Functions.mensajeerror(caderrors, "Error");
			}

		} while (error == true);
		// creamos el Admin
		// Admin admin = new Admin(getName, getSurname, getPhone, getDNI, getEmail,
		// birthday, getUsername, getPassword);
		// Añadimos los datos a la BD
		try {
			Connection conn = DataConnection.getConnection();
			PreparedStatement posted = conn.prepareStatement(
					"INSERT INTO Admin (name,surname,phone,DNI,email,birthday,username,password) VALUES ('" + getName
							+ "','" + getSurname + "','" + getPhone + "','" + getDNI + "','" + getEmail + "','"
							+ birthday.ToString() + "','" + getUsername + "','" + getPassword + "')");
			posted.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Insert COmpleted");
		}

	}
}
