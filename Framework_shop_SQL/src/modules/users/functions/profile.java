package modules.users.functions;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import classes.DataConnection;
import classes.Fecha;
import functions.Functions;
import functions.validate;
import modules.users.classes.Admin;

public class profile {

	public static void main(String[] args) throws Exception {
		String rname = null, rpassword = null, rsurname = null, rphone = null, rDNI = null, remail = null,
				rbirthday = null, rusername = null;
		boolean error = false;
		Integer option = 0, optionupdate = 0;
		String caderrors = "", getName = "", getSurname = "", getPhone = "", getDNI = "", getEmail = "",
				getUsername = "", getPassword = "", getBirthday = "";
		Fecha fbirthday = null;
		JTextField namefield = new JTextField();
		JTextField surnamefield = new JTextField();
		JTextField phonefield = new JTextField();
		JTextField emailfield = new JTextField();
		JTextField usernamefieldfield = new JTextField();
		JPasswordField passwordfield = new JPasswordField();
		JTextField dnifield = new JTextField();
		JTextField birthdayfield = new JTextField();
		// Creamos unos bordes para apariencia
		Border bordererror = BorderFactory.createLineBorder(Color.RED, 1);
		Border borderdefault = new JTextField().getBorder();
		// Creamos el panel en un objeto para que aparezca en una ventan.
		Object[] menu = { "Update yout profile\n\n", "Name", namefield, "Surname", surnamefield,
				"Phone (Ex: 623456789)", phonefield, "Email (Ex: yourname@email.com)", emailfield,
				"DNI (Ex: 12345678A) ", dnifield, "Username", usernamefieldfield, "Password", passwordfield,
				"Date Birthday", birthdayfield };

		String name = "", surname, phone, DNI, email, birthday, username, password, cad = "";
		String usernamefirst = login.getUsername;
		String menu1[] = { "Update", "Close" };

		Connection conn = DataConnection.getConnection();
		PreparedStatement statement = conn
				.prepareStatement("SELECT * FROM Admin WHERE username='" + usernamefirst + "'");
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			name = result.getString("name");
			surname = result.getString("surname");
			phone = result.getString("phone");
			DNI = result.getString("DNI");
			email = result.getString("email");
			birthday = result.getString("birthday");
			username = result.getString("username");
			password = result.getString("password");
			cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: " + DNI + "\nEmail: "
					+ email + "\nBirthday: " + birthday + "\nusername: " + username + "\npassword: " + password
					+ "\n\n";

		}

		option = Functions.menubuttons(menu1, cad, usernamefirst + " Profile", 1);
		if (option == -1 || option == 1) {
			return;
		} else {
			PreparedStatement datos = conn
					.prepareStatement("SELECT * FROM Admin WHERE username='" + usernamefirst + "'");
			ResultSet resultdatos = datos.executeQuery();
			while (resultdatos.next()) {
				rname = resultdatos.getString("name");
				rsurname = resultdatos.getString("surname");
				rphone = resultdatos.getString("phone");
				rDNI = resultdatos.getString("DNI");
				remail = resultdatos.getString("email");
				rbirthday = resultdatos.getString("birthday");
				rusername = resultdatos.getString("username");
				rpassword = resultdatos.getString("password");
			}
			do {
				namefield.setText(rname);
				surnamefield.setText(rsurname);
				phonefield.setText(rphone);
				emailfield.setText(remail);
				dnifield.setText(rDNI);
				usernamefieldfield.setText(rusername);
				passwordfield.setText(rpassword);
				birthdayfield.setText(rbirthday);
				caderrors = "";
				error = false;
				option = JOptionPane.showInternalOptionDialog(null, menu, "Admin", 0, JOptionPane.QUESTION_MESSAGE,
						null, menu1, menu1[0]);
				if (option == -1 || option == 1) {
					return;
				}
				// input name
				namefield.setBorder(borderdefault);
				getName = namefield.getText();
				if (getName.isEmpty()) {// Si esta vacio entra en el error.
					namefield.setBorder(bordererror);
					caderrors = caderrors + "- Name empty\n";
					error = true;
				} else {
					if (validate.validaname(getName) == false) {
						namefield.setBorder(bordererror);
						caderrors = caderrors + "- Name Incorrect, use only letters\n";
						error = true;
					}
				}
				// Input Surname
				surnamefield.setBorder(borderdefault);
				getSurname = surnamefield.getText();
				if (getSurname.isEmpty()) {// Si esta vacio entra en el error.
					surnamefield.setBorder(bordererror);
					caderrors = caderrors + "- Surname empty\n";
					error = true;
				} else {
					if (validate.validasurname(getSurname) == false) {
						surnamefield.setBorder(bordererror);
						caderrors = caderrors + "- Surname Incorrect, use only letters\n";
						error = true;
					}
				}
				// Input phone
				phonefield.setBorder(borderdefault);
				getPhone = phonefield.getText();
				if (getPhone.isEmpty()) {
					phonefield.setBorder(bordererror);
					caderrors = caderrors + "- Phone empty\n";
					error = true;
				} else {
					if (validate.validaphone(getPhone) == false) {
						phonefield.setBorder(bordererror);
						caderrors = caderrors + "- Phone Incorrect\n";
						error = true;
					}
				}
				// Input email
				emailfield.setBorder(borderdefault);
				getEmail = emailfield.getText();
				if (getEmail.isEmpty()) {
					emailfield.setBorder(bordererror);
					caderrors = caderrors + "- Email empty\n";
					error = true;
				} else {
					if (validate.validaemail(getEmail) == false) {
						emailfield.setBorder(bordererror);
						caderrors = caderrors + "- Email Incorrect\n";
						error = true;
					}
				}
				// Input DNI
				dnifield.setBorder(borderdefault);
				getDNI = dnifield.getText();
				if (getDNI.isEmpty()) {
					dnifield.setBorder(bordererror);
					caderrors = caderrors + "- DNI empty\n";
					error = true;
				} else {
					if (validate.validadni(getDNI) == false) {
						dnifield.setBorder(bordererror);
						caderrors = caderrors + "- DNI Incorrect\n";
						error = true;
					}
				}
				// Input Username
				usernamefieldfield.setBorder(borderdefault);
				getUsername = usernamefieldfield.getText();
				if (getUsername.isEmpty()) {
					usernamefieldfield.setBorder(bordererror);
					caderrors = caderrors + "- Username empty\n";
					error = true;
				} else {
					if (validate.validausername(getUsername) == false) {
						usernamefieldfield.setBorder(bordererror);
						caderrors = caderrors + "- Username Incorrect\n";
						error = true;
					}
				}
				// Input password
				passwordfield.setBorder(borderdefault);
				char[] p = passwordfield.getPassword();
				getPassword = String.valueOf(passwordfield.getPassword());
				System.out.println("Password is: " + new String(p));
				// getPassword = password.getText();
				if (getPassword.isEmpty()) {
					passwordfield.setBorder(bordererror);
					caderrors = caderrors + "- Password empty\n";
					error = true;
				} else {
					if (validate.validapass(getPassword) == false) {
						passwordfield.setBorder(bordererror);
						caderrors = caderrors + "- Password Incorrect(At least 8 chars, Contains at least one digit\n"
								+ "     Contains at least one lower alpha char and one upper alpha char\n"
								+ "     Contains at least one char within a set of special chars (@#%$^ etc.), Does not contain space, tab, etc.\n";
						error = true;
					}
				}
				// Input Fecha nacimiento
				birthdayfield.setBorder(borderdefault);
				if (birthdayfield.getText().isEmpty()) {
					birthdayfield.setBorder(bordererror);
					caderrors = caderrors + "- Fecha Birthday empty\n";
					error = true;
				} else {
					getBirthday = birthdayfield.getText();
					if (validate.validafecha(getBirthday) == true) {
						fbirthday = new Fecha(getBirthday);
						if (fbirthday.vfecha() == true) {
							if (fbirthday.comparaNacimiento() == false) {
								caderrors = caderrors + "- Ser a date before 01/01/2008\n";
								error = true;
							}
						} else {
							caderrors = caderrors + "- Insert a valid date!\n";
							error = true;
						}
					} else {
						birthdayfield.setBorder(bordererror);
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
			Admin admin = new Admin(getName, getSurname, getPhone, getDNI, getEmail, fbirthday, getUsername,
					getPassword);
			// Añadimos los datos a la BD
			try {
				System.out.println("parte modify");
				String updatesql = "UPDATE Admin SET name='" + getName + "',surname='" + getSurname + "',phone='"
						+ getPhone + "',DNI='" + getDNI + "',email='" + getEmail + "',birthday='" + fbirthday.ToString()
						+ "',password='" + getPassword + "',age='" + admin.getAge() + "',username='" + getUsername
						+ "' WHERE username='" + usernamefirst + "'";
				PreparedStatement update = conn.prepareStatement(updatesql);
				update.executeUpdate();
				login.main(null);
			} catch (Exception e) {
				Functions.mensajeerror("DNI duplicado", "Error");
			} finally {
				System.out.println("Insert COmpleted");
			}
		}

	}

}
