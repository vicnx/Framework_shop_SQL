package modules.users.functions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import classes.DataConnection;
import classes.Fecha;
import functions.Functions;
import functions.validate;
import modules.users.classes.Admin;
import modules.users.classes.Client;

public class Functions_sql {
	// read all Admins
	public static void readAllAdmin() throws Exception {
		// Cfremos una tabla para mostrar el contenido
		String columnas[] = { "name", "surname", "DNI", "username" };
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(columnas);
		JTable tabla = new JTable(modelo);
		JScrollPane desplazamiento = new JScrollPane(tabla);
		JFrame F = new JFrame();
		JButton close = new JButton("Close");
		desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFillsViewportHeight(true);
		tabla.setDefaultEditor(Object.class, null);
		F.getContentPane().add(desplazamiento, BorderLayout.NORTH);
		F.getContentPane().add(close);
		F.pack();
		desplazamiento.setPreferredSize(new Dimension(400, 400));
		Object ter[] = { desplazamiento };
		// Read
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

		tabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String name = null, surname, phone, DNI, email, birthday, username, password, cad = "";

				if (e.getClickCount() == 2) {
					int row = tabla.getSelectedRow();
					if (row == -1) {
						Functions.mensajeerror("Nada que mostrar", "Error");
					} else {
						String dato = (String) tabla.getValueAt(row, 2);
						try {
							Connection read = DataConnection.getConnection();
							PreparedStatement statement2 = read
									.prepareStatement("SELECT * FROM Admin WHERE DNI='" + dato + "'");
							ResultSet r = statement2.executeQuery();
							while (r.next()) {
								name = r.getString("name");
								surname = r.getString("surname");
								phone = r.getString("phone");
								DNI = r.getNString("DNI");
								email = r.getString("email");
								birthday = r.getString("birthday");
								username = r.getString("username");
								password = r.getString("password");

								cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: "
										+ DNI + "\nEmail: " + email + "\nBirthday: " + birthday + "\nusername: "
										+ username + "\npassword: " + password + "\n\n";
							}
						} catch (Exception e2) {
							// TODO: handle exception
						} // fintrycatch
						if (cad.isEmpty()) {
							Functions.mensajeerror("Nada que mostrar", "Error");
						} else {
							Functions.mensajeinf(cad, name);

						}
					}
				} // fin 2 cliks
			}
		});

		while (result.next()) {
			name = result.getString("name");
			surname = result.getString("surname");
			phone = result.getString("phone");
			DNI = result.getNString("DNI");
			email = result.getString("email");
			birthday = result.getString("birthday");
			username = result.getString("username");
			password = result.getString("password");

			// añadimos datos a la tabla
			modelo.addRow(new Object[] { name, surname, DNI, username });
			cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: " + DNI + "\nEmail: "
					+ email + "\nBirthday: " + birthday + "\nusername: " + username + "\npassword: " + password
					+ "\n\n";
			// System.out.println(result.getString("firstname"));
			// System.out.println(result.getString("lastname"));

		}
		if (cad.isEmpty()) {
			Functions.mensajeerror("No hay Admins en la BD", "Error");

		} else {
			JOptionPane.showMessageDialog(null, ter);
			// F.setVisible(true);
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

	// updateAdmin
	public static void UpdateAdmin() throws Exception {
		// Select Admin
		JComboBox<String> combo = new JComboBox<String>();
		String selectbox = "";
		int optionbox = 0;
		String consulta = "SELECT * FROM Admin ORDER by username ASC";
		String opmenu[] = { "OK", "Cancel" };
		String username = "";
		// Form admin
		String caderrors = "", getName = "", getSurname = "", getPhone = "", getDNI = "", getEmail = "",
				getUsername = "", getPassword = "", getBirthday = "";
		Fecha birthday = null;
		boolean error = false;
		String optionmenu[] = { "Update", "Return" };
		Integer option = 0;
		JTextField name = new JTextField();
		JTextField surname = new JTextField();
		JTextField phone = new JTextField();
		JTextField email = new JTextField();
		JTextField usernamefield = new JTextField();
		JPasswordField password = new JPasswordField();
		JTextField dni = new JTextField();
		JTextField fbirthday = new JTextField();
		// Creamos unos bordes para apariencia
		Border bordererror = BorderFactory.createLineBorder(Color.RED, 1);
		Border borderdefault = new JTextField().getBorder();
		// Creamos el panel en un objeto para que aparezca en una ventan.
		Object[] menu = { "Update an Administrator\n\n", "Name", name, "Surname", surname, "Phone (Ex: 623456789)",
				phone, "Email (Ex: yourname@email.com)", email, "DNI (Ex: 12345678A) ", dni, "Username", usernamefield,
				"Password", password, "Date Birthday", fbirthday };

		Connection conn = DataConnection.getConnection();
		PreparedStatement statement = conn.prepareStatement(consulta);
		ResultSet result = statement.executeQuery();

		String rname = null;
		String rsurname = null;
		String rphone = null;
		String rDNI = null;
		String remail = null;
		String rbirthday = null;
		String rusername = null;
		String rpassword = null;
		while (result.next()) {
			username = result.getString("username");
			combo.addItem(username);
		}
		Object menubox[] = { "Select an Admin to modify", combo };
		optionbox = option = JOptionPane.showInternalOptionDialog(null, menubox, "Admin", 0,
				JOptionPane.QUESTION_MESSAGE, null, optionmenu, optionmenu[0]);
		if (optionbox == 1 | optionbox == -1) {
			return;
		}
		selectbox = (String) combo.getSelectedItem();
		// Mostrar datos de user seleccionado
		PreparedStatement datos = conn.prepareStatement("SELECT * FROM Admin WHERE username='" + selectbox + "'");
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
			name.setText(rname);
			surname.setText(rsurname);
			phone.setText(rphone);
			email.setText(remail);
			dni.setText(rDNI);
			usernamefield.setText(rusername);
			password.setText(rpassword);
			fbirthday.setText(rbirthday);
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
			usernamefield.setBorder(borderdefault);
			getUsername = usernamefield.getText();
			if (getUsername.isEmpty()) {
				usernamefield.setBorder(bordererror);
				caderrors = caderrors + "- Username empty\n";
				error = true;
			} else {
				if (validate.validausername(getUsername) == false) {
					usernamefield.setBorder(bordererror);
					caderrors = caderrors + "- Username Incorrect\n";
					error = true;
				}
			}
			// Input password
			password.setBorder(borderdefault);
			char[] p = password.getPassword();
			getPassword = String.valueOf(password.getPassword());
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
		Admin admin = new Admin(getName, getSurname, getPhone, getDNI, getEmail, birthday, getUsername, getPassword);
		// Añadimos los datos a la BD
		try {
			System.out.println("parte modify");
			String updatesql = "UPDATE Admin SET name='" + getName + "',surname='" + getSurname + "',phone='" + getPhone
					+ "',DNI='" + getDNI + "',email='" + getEmail + "',birthday='" + birthday.ToString()
					+ "',password='" + getPassword + "',age='" + admin.getAge() + "',username='" + getUsername
					+ "' WHERE username='" + selectbox + "'";
			PreparedStatement update = conn.prepareStatement(updatesql);
			System.out.println(selectbox);
			update.executeUpdate();
		} catch (Exception e) {
			Functions.mensajeerror("DNI duplicado", "Error");
		} finally {
			System.out.println("Insert COmpleted");
		}

	}

	public static void UpdateClient() throws Exception {
		// Select Admin
		JComboBox<String> combo = new JComboBox<String>();
		String selectbox = "";
		int optionbox = 0;
		String consulta = "SELECT * FROM Client ORDER by idclient ASC";
		String opmenu[] = { "OK", "Cancel" };
		String idclient = "";
		// Form admin
		String caderrors = "", getName = "", getSurname = "", getPhone = "", getDNI = "", getEmail = "",
				getIdclient = "", getBirthday = "";
		Fecha birthday = null;
		boolean error = false;
		String optionmenu[] = { "Update", "Return" };
		Integer option = 0;
		JTextField name = new JTextField();
		JTextField surname = new JTextField();
		JTextField phone = new JTextField();
		JTextField email = new JTextField();
		JTextField idclientfield = new JTextField();
		JTextField dni = new JTextField();
		JTextField fbirthday = new JTextField();
		// Creamos unos bordes para apariencia
		Border bordererror = BorderFactory.createLineBorder(Color.RED, 1);
		Border borderdefault = new JTextField().getBorder();
		// Creamos el panel en un objeto para que aparezca en una ventan.
		Object[] menu = { "Create new Administrator\n\n", "Name", name, "Surname", surname, "Phone (Ex: 623456789)",
				phone, "Email (Ex: yourname@email.com)", email, "DNI (Ex: 12345678A) ", dni, "Idclient", idclientfield,
				"Date Birthday", fbirthday };

		Connection conn = DataConnection.getConnection();
		PreparedStatement statement = conn.prepareStatement(consulta);
		ResultSet result = statement.executeQuery();

		String rname = null;
		String rsurname = null;
		String rphone = null;
		String rDNI = null;
		String remail = null;
		String rbirthday = null;
		String ridclient = null;
		while (result.next()) {
			idclient = result.getString("idclient");
			combo.addItem(idclient);
		}
		Object menubox[] = { "Select an Client to modify", combo };
		optionbox = option = JOptionPane.showInternalOptionDialog(null, menubox, "Client", 0,
				JOptionPane.QUESTION_MESSAGE, null, optionmenu, optionmenu[0]);
		if (optionbox == 1 | optionbox == -1) {
			return;
		}
		selectbox = (String) combo.getSelectedItem();
		// Mostrar datos de user seleccionado
		PreparedStatement datos = conn.prepareStatement("SELECT * FROM Client WHERE idclient='" + selectbox + "'");
		ResultSet resultdatos = datos.executeQuery();
		while (resultdatos.next()) {
			rname = resultdatos.getString("name");
			rsurname = resultdatos.getString("surname");
			rphone = resultdatos.getString("phone");
			rDNI = resultdatos.getString("DNI");
			remail = resultdatos.getString("email");
			rbirthday = resultdatos.getString("birthday");
			ridclient = resultdatos.getString("idclient");
		}
		do {
			name.setText(rname);
			surname.setText(rsurname);
			phone.setText(rphone);
			email.setText(remail);
			dni.setText(rDNI);
			idclientfield.setText(ridclient);
			fbirthday.setText(rbirthday);
			caderrors = "";
			error = false;
			option = JOptionPane.showInternalOptionDialog(null, menu, "Client", 0, JOptionPane.QUESTION_MESSAGE, null,
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
			// Input idclient
			idclientfield.setBorder(borderdefault);
			getIdclient = idclientfield.getText();
			if (getIdclient.isEmpty()) {
				idclientfield.setBorder(bordererror);
				caderrors = caderrors + "- IdClient empty\n";
				error = true;
			} else {
				if (validate.validaidclient(getIdclient) == false) {
					idclientfield.setBorder(bordererror);
					caderrors = caderrors + "- Idclient Incorrect\n";
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
		Fecha registro = new Fecha();
		Client client = new Client(getName, getSurname, getPhone, getDNI, getEmail, birthday, registro, getIdclient);
		// Añadimos los datos a la BD
		try {
			System.out.println("parte modify");
			String updatesql = "UPDATE Client SET name='" + getName + "',surname='" + getSurname + "',phone='"
					+ getPhone + "',DNI='" + getDNI + "',email='" + getEmail + "',birthday='" + birthday.ToString()
					+ "',registro='" + registro.ToString() + "',idclient='" + getIdclient + "',age='" + client.getAge()
					+ "' WHERE idclient='" + selectbox + "'";
			PreparedStatement updateclient = conn.prepareStatement(updatesql);
			System.out.println(selectbox);
			updateclient.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Update COmpleted");
		}

	}
}
