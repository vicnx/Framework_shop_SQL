package modules.users.functions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
		modelo.setColumnIdentifiers(columnas);
		JTable tabla = new JTable();
		tabla.setModel(modelo);
		tabla.setRowSorter(sorter);
		JScrollPane desplazamiento = new JScrollPane(tabla);
		desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFillsViewportHeight(true);
		tabla.setDefaultEditor(Object.class, null);
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
				String name = null, surname, phone, DNI, email, birthday, username, password, age, cad = "";

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
								age = r.getString("age");

								cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: "
										+ DNI + "\nEmail: " + email + "\nBirthday: " + birthday + "\nusername: "
										+ username + "\npassword: " + password + "\nage: " + age + "\n";
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
			String age = result.getString("age");

			// añadimos datos a la tabla
			modelo.addRow(new Object[] { name, surname, DNI, username });
			cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: " + DNI + "\nEmail: "
					+ email + "\nBirthday: " + birthday + "\nusername: " + username + "\npassword: " + password
					+ "\nage: " + age + "\n";
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
		// Cfremos una tabla para mostrar el contenido
		String columnas[] = { "name", "surname", "DNI", "idClient" };
		DefaultTableModel modelo = new DefaultTableModel();
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
		modelo.setColumnIdentifiers(columnas);
		JTable tabla = new JTable();
		tabla.setModel(modelo);
		tabla.setRowSorter(sorter);
		JScrollPane desplazamiento = new JScrollPane(tabla);
		desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFillsViewportHeight(true);
		tabla.setDefaultEditor(Object.class, null);
		desplazamiento.setPreferredSize(new Dimension(400, 400));
		Object ter[] = { desplazamiento };
		// Read
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

		tabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String name = null, surname, phone, DNI, email, birthday, registro, idclient, age, cad = "";

				if (e.getClickCount() == 2) {
					int row = tabla.getSelectedRow();
					if (row == -1) {
						Functions.mensajeerror("Nada que mostrar", "Error");
					} else {
						String dato = (String) tabla.getValueAt(row, 3);
						try {
							Connection read = DataConnection.getConnection();
							PreparedStatement statement2 = read
									.prepareStatement("SELECT * FROM Client WHERE idclient='" + dato + "'");
							ResultSet r = statement2.executeQuery();
							while (r.next()) {
								name = r.getString("name");
								surname = r.getString("surname");
								phone = r.getString("phone");
								DNI = r.getNString("DNI");
								email = r.getString("email");
								birthday = r.getString("birthday");
								registro = r.getString("registro");
								idclient = r.getString("idclient");
								age = r.getString("age");

								cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: "
										+ DNI + "\nEmail: " + email + "\nBirthday: " + birthday + "\nregistro: "
										+ registro + "\nidclient: " + idclient + "\nage:" + age + "\n";
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
			registro = result.getString("registro");
			idclient = result.getString("idclient");
			String age = result.getString("age");

			// añadimos datos a la tabla
			modelo.addRow(new Object[] { name, surname, DNI, idclient });
			cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: " + DNI + "\nEmail: "
					+ email + "\nBirthday: " + birthday + "\nregistro: " + registro + "\nidclient: " + idclient
					+ "\nage: " + age + "\n";
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

//deleteAdmin
	public static void deleteAdmin() throws Exception {
		// Cfremos una tabla para mostrar el contenido
		String columnas[] = { "name", "surname", "DNI", "username" };
		DefaultTableModel modelo = new DefaultTableModel();
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
		modelo.setColumnIdentifiers(columnas);
		JTable tabla = new JTable();
		tabla.setModel(modelo);
		tabla.setRowSorter(sorter);
		JScrollPane desplazamiento = new JScrollPane(tabla);
		desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFillsViewportHeight(true);
		tabla.setDefaultEditor(Object.class, null);
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
		String age = "";
		Connection conn = DataConnection.getConnection();
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM Admin");
		ResultSet result = statement.executeQuery();

		tabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int eliminate = 0;
				String name = null, surname = null, phone = null, DNI = null, email = null, birthday = null,
						username = null, password = null, age = null, cad = "";
				if (e.getClickCount() == 2) {
					int row = tabla.getSelectedRow();
					if (row == -1) {
						Functions.mensajeerror("Nada que mostrar", "Error");
					} else {
						String dato = (String) tabla.getValueAt(row, 3);
						try {
							Connection read = DataConnection.getConnection();
							PreparedStatement statement2 = read
									.prepareStatement("SELECT * FROM Admin WHERE username='" + dato + "'");
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
								age = r.getString("age");

								cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: "
										+ DNI + "\nEmail: " + email + "\nBirthday: " + birthday + "\nusername: "
										+ username + "\npassword: " + password + "\nage: " + age + "\n";
							}
							eliminate = JOptionPane.showConfirmDialog(null, "Seguro de eliminar?");
							if (eliminate == 0) {
								PreparedStatement eliminar = conn
										.prepareStatement("DELETE FROM Admin WHERE username='" + username + "'");
								eliminar.executeUpdate();
								Functions.mensajeinf("Eliminado cone xito", "Remove");
								modelo.setRowCount(0);
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
									age = result.getString("age");

									// añadimos datos a la tabla
									modelo.addRow(new Object[] { name, surname, DNI, username });
								}

							}

						} catch (Exception e2) {
							Functions.mensajeerror("Error eliminar", "Error");
						} finally {
							System.out.println("Deleted COmpleted");
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
			age = result.getString("age");

			// añadimos datos a la tabla
			modelo.addRow(new Object[] { name, surname, DNI, username });
			cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: " + DNI + "\nEmail: "
					+ email + "\nBirthday: " + birthday + "\nusername: " + username + "\npassword: " + password
					+ "\nage: " + age + "\n";
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

//deleteClient
	public static void deleteClient() throws Exception {
		// Cfremos una tabla para mostrar el contenido
		String columnas[] = { "name", "surname", "DNI", "idClient" };
		DefaultTableModel modelo = new DefaultTableModel();
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
		modelo.setColumnIdentifiers(columnas);
		JTable tabla = new JTable();
		tabla.setModel(modelo);
		tabla.setRowSorter(sorter);
		JScrollPane desplazamiento = new JScrollPane(tabla);
		desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFillsViewportHeight(true);
		tabla.setDefaultEditor(Object.class, null);
		desplazamiento.setPreferredSize(new Dimension(400, 400));
		Object ter[] = { desplazamiento };
		// Read
		String name = "";
		String surname = "";
		String phone = "";
		String DNI = "";
		String email = "";
		String birthday = "";
		String registro = "";
		String idclient = "";
		String cad = "";
		String age = "";
		Connection conn = DataConnection.getConnection();
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM Client");
		ResultSet result = statement.executeQuery();

		tabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int eliminate = 0;
				String name = null, surname = null, phone = null, DNI = null, email = null, birthday = null,
						registro = null, idclient = null, age = null, cad = "";
				if (e.getClickCount() == 2) {
					int row = tabla.getSelectedRow();
					if (row == -1) {
						Functions.mensajeerror("Nada que mostrar", "Error");
					} else {
						String dato = (String) tabla.getValueAt(row, 3);
						try {
							Connection read = DataConnection.getConnection();
							PreparedStatement statement2 = read
									.prepareStatement("SELECT * FROM Client WHERE idclient='" + dato + "'");
							ResultSet r = statement2.executeQuery();
							while (r.next()) {
								name = r.getString("name");
								surname = r.getString("surname");
								phone = r.getString("phone");
								DNI = r.getNString("DNI");
								email = r.getString("email");
								birthday = r.getString("birthday");
								registro = r.getString("registro");
								idclient = r.getString("idclient");
								age = r.getString("age");

								cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: "
										+ DNI + "\nEmail: " + email + "\nBirthday: " + birthday + "\nregistro: "
										+ registro + "\nidclient: " + idclient + "\nage:" + age + "\n";
							}
							eliminate = JOptionPane.showConfirmDialog(null, "Seguro de eliminar?");
							if (eliminate == 0) {
								PreparedStatement eliminar = conn
										.prepareStatement("DELETE FROM Client WHERE idclient='" + idclient + "'");
								eliminar.executeUpdate();
								Functions.mensajeinf("Eliminado cone xito", "Remove");
								modelo.setRowCount(0);
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
									age = result.getString("age");

									// añadimos datos a la tabla
									modelo.addRow(new Object[] { name, surname, DNI, idclient });
								}

							}

						} catch (Exception e2) {
							Functions.mensajeerror("Error eliminar", "Error");
						} finally {
							System.out.println("Deleted COmpleted");
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
			registro = result.getString("registro");
			idclient = result.getString("idclient");
			age = result.getString("age");

			// añadimos datos a la tabla
			modelo.addRow(new Object[] { name, surname, DNI, idclient });
			cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: " + DNI + "\nEmail: "
					+ email + "\nBirthday: " + birthday + "\nregistro: " + registro + "\nidclient: " + idclient
					+ "\nage: " + age + "\n";
			// System.out.println(result.getString("firstname"));
			// System.out.println(result.getString("lastname"));

		}
		if (cad.isEmpty()) {
			Functions.mensajeerror("No hay Clientes en la BD", "Error");

		} else {
			JOptionPane.showMessageDialog(null, ter);
			// F.setVisible(true);
		}
	}

	// updateAdmin
	public static void UpdateAdmin() throws Exception {

		// Cfremos una tabla para mostrar el contenido
		String columnas[] = { "name", "surname", "DNI", "username" };
		DefaultTableModel modelo = new DefaultTableModel();
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
		modelo.setColumnIdentifiers(columnas);
		JTable tabla = new JTable();
		tabla.setModel(modelo);
		tabla.setRowSorter(sorter);
		JScrollPane desplazamiento = new JScrollPane(tabla);
		desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFillsViewportHeight(true);
		tabla.setDefaultEditor(Object.class, null);
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
				String name = null, surname = null, phone = null, DNI = null, email = null, birthday = null,
						username = null, password = null, age = null, cad = "";
				String caderrors = "", getName = "", getSurname = "", getPhone = "", getDNI = "", getEmail = "",
						getUsername = "", getPassword = "", getBirthday = "";
				Fecha fbirthday = null;
				boolean error = false;
				String optionmenu[] = { "Create", "Return" };
				Integer option = 0;
				String mypass = "";
				JTextField namefield = new JTextField();
				JTextField surnamefield = new JTextField();
				JTextField phonefield = new JTextField();
				JTextField emailfield = new JTextField();
				JTextField usernamefield = new JTextField();
				JPasswordField passwordfield = new JPasswordField();
				JTextField dnifield = new JTextField();
				JTextField fbirthdayfield = new JTextField();
				// Creamos unos bordes para apariencia
				Border bordererror = BorderFactory.createLineBorder(Color.RED, 1);
				Border borderdefault = new JTextField().getBorder();
				if (e.getClickCount() == 2) {
					int row = tabla.getSelectedRow();
					if (row == -1) {
						Functions.mensajeerror("Nada que mostrar", "Error");
					} else {
						String dato = (String) tabla.getValueAt(row, 2);
						try {
							// Creamos el panel en un objeto para que aparezca en una ventan.
							Object[] menu = { "Update a Aministrator\n\n", "Name", namefield, "Surname", surnamefield,
									"Phone (Ex: 623456789)", phonefield, "Email (Ex: yourname@email.com)", emailfield,
									"DNI (Ex: 12345678A) ", dnifield, "Username", usernamefield, "Password",
									passwordfield, "Date Birthday", fbirthdayfield };
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
								age = r.getString("age");

								cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: "
										+ DNI + "\nEmail: " + email + "\nBirthday: " + birthday + "\nusername: "
										+ username + "\npassword: " + password + "\nage: " + age + "\n";
							}
							do {
								namefield.setText(name);
								surnamefield.setText(surname);
								phonefield.setText(phone);
								dnifield.setText(DNI);
								emailfield.setText(email);
								fbirthdayfield.setText(birthday);
								usernamefield.setText(username);
								passwordfield.setText(password);
								caderrors = "";
								error = false;
								option = JOptionPane.showInternalOptionDialog(null, menu, "Admin", 0,
										JOptionPane.QUESTION_MESSAGE, null, optionmenu, optionmenu[0]);
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
								passwordfield.setBorder(borderdefault);
								char[] p = passwordfield.getPassword();
								mypass = String.valueOf(passwordfield.getPassword());
								getPassword = p.toString();
								System.out.println("Pass> " + mypass);
								System.out.println("Password is: " + new String(p));
								// getPassword = password.getText();
								if (mypass.isEmpty()) {
									passwordfield.setBorder(bordererror);
									caderrors = caderrors + "- Password empty\n";
									error = true;
								} else {
									if (validate.validapass(mypass) == false) {
										passwordfield.setBorder(bordererror);
										caderrors = caderrors
												+ "- Password Incorrect(At least 8 chars, Contains at least one digit\n"
												+ "     Contains at least one lower alpha char and one upper alpha char\n"
												+ "     Contains at least one char within a set of special chars (@#%$^ etc.), Does not contain space, tab, etc.\n";
										error = true;
									}
								}
								// Input Fecha nacimiento
								fbirthdayfield.setBorder(borderdefault);
								if (fbirthdayfield.getText().isEmpty()) {
									fbirthdayfield.setBorder(bordererror);
									caderrors = caderrors + "- Fecha Birthday empty\n";
									error = true;
								} else {
									getBirthday = fbirthdayfield.getText();
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
										fbirthdayfield.setBorder(bordererror);
										caderrors = caderrors + "- Set a corret date\n (dd/mm/yyyy)\n";
										error = true;
									}
								}
								// Si sale un error entra en el IF y los muestra todos.
								if (error == true) {
									Functions.mensajeerror(caderrors, "Error");
								}
							} while (error == true);
						} catch (Exception e2) {
							// TODO: handle exception
						} // fintrycatch
						Admin admin = new Admin(getName, getSurname, getPhone, getDNI, getEmail, fbirthday, getUsername,
								getPassword);
						try {
							String updatesql = "UPDATE Admin SET name='" + getName + "',surname='" + getSurname
									+ "',phone='" + getPhone + "',DNI='" + getDNI + "',email='" + getEmail
									+ "',birthday='" + fbirthday.ToString() + "',password='" + mypass + "',age='"
									+ admin.getAge() + "',username='" + getUsername + "' WHERE username='" + username
									+ "'";
							PreparedStatement update = conn.prepareStatement(updatesql);
							update.executeUpdate();
							tabla.setValueAt(getName, row, 0);
							tabla.setValueAt(getSurname, row, 1);
							tabla.setValueAt(getDNI, row, 2);
							tabla.setValueAt(getUsername, row, 3);

						} catch (Exception e2) {
							Functions.mensajeerror("Username duplicado", "Error");
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
			String age = result.getString("age");

			// añadimos datos a la tabla
			modelo.addRow(new Object[] { name, surname, DNI, username });
			cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: " + DNI + "\nEmail: "
					+ email + "\nBirthday: " + birthday + "\nusername: " + username + "\npassword: " + password
					+ "\nage: " + age + "\n";
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

	public static void UpdateClient() throws Exception {
		// Cfremos una tabla para mostrar el contenido
		String columnas[] = { "name", "surname", "DNI", "idClient" };
		DefaultTableModel modelo = new DefaultTableModel();
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
		modelo.setColumnIdentifiers(columnas);
		JTable tabla = new JTable();
		tabla.setModel(modelo);
		tabla.setRowSorter(sorter);
		JScrollPane desplazamiento = new JScrollPane(tabla);
		desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFillsViewportHeight(true);
		tabla.setDefaultEditor(Object.class, null);
		desplazamiento.setPreferredSize(new Dimension(400, 400));
		Object ter[] = { desplazamiento };
		// Read
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

		tabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String name = null, surname = null, phone = null, DNI = null, email = null, birthday = null,
						registro = null, idclient = null, age = null, cad = "";
				String caderrors = "", getName = "", getSurname = "", getPhone = "", getDNI = "", getEmail = "",
						getidclient = "", getBirthday = "";
				Fecha fbirthday = null;
				boolean error = false;
				String optionmenu[] = { "Update", "Return" };
				Integer option = 0;
				JTextField namefield = new JTextField();
				JTextField surnamefield = new JTextField();
				JTextField phonefield = new JTextField();
				JTextField emailfield = new JTextField();
				JTextField dnifield = new JTextField();
				JTextField fbirthdayfield = new JTextField();
				JTextField idclientfield = new JTextField();
				// Creamos unos bordes para apariencia
				Border bordererror = BorderFactory.createLineBorder(Color.RED, 1);
				Border borderdefault = new JTextField().getBorder();
				// Creamos el panel en un objeto para que aparezca en una ventan.
				Object[] menu = { "Update a Client\n\n", "Name", namefield, "Surname", surnamefield,
						"Phone (Ex: 623456789)", phonefield, "Email (Ex: yourname@email.com)", emailfield,
						"DNI (Ex: 12345678A) ", dnifield, "Date Birthday", fbirthdayfield, "ID CLIENTE",
						idclientfield };
				if (e.getClickCount() == 2) {
					int row = tabla.getSelectedRow();
					if (row == -1) {
						Functions.mensajeerror("Nada que mostrar", "Error");
					} else {
						String dato = (String) tabla.getValueAt(row, 3);
						try {
							Connection read = DataConnection.getConnection();
							PreparedStatement statement2 = read
									.prepareStatement("SELECT * FROM Client WHERE idclient='" + dato + "'");
							ResultSet r = statement2.executeQuery();
							while (r.next()) {
								name = r.getString("name");
								surname = r.getString("surname");
								phone = r.getString("phone");
								DNI = r.getNString("DNI");
								email = r.getString("email");
								birthday = r.getString("birthday");
								registro = r.getString("registro");
								idclient = r.getString("idclient");
								age = r.getString("age");

								cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: "
										+ DNI + "\nEmail: " + email + "\nBirthday: " + birthday + "\nregistro: "
										+ registro + "\nidclient: " + idclient + "\nage:" + age + "\n";
							}
							do {
								namefield.setText(name);
								surnamefield.setText(surname);
								phonefield.setText(phone);
								dnifield.setText(DNI);
								emailfield.setText(email);
								fbirthdayfield.setText(birthday);
								idclientfield.setText(idclient);
								caderrors = "";
								error = false;
								option = JOptionPane.showInternalOptionDialog(null, menu, "Client", 0,
										JOptionPane.QUESTION_MESSAGE, null, optionmenu, optionmenu[0]);
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
								// Input Fecha nacimiento
								fbirthdayfield.setBorder(borderdefault);
								if (fbirthdayfield.getText().isEmpty()) {
									fbirthdayfield.setBorder(bordererror);
									caderrors = caderrors + "- Fecha Birthday empty\n";
									error = true;
								} else {
									getBirthday = fbirthdayfield.getText();
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
										fbirthdayfield.setBorder(bordererror);
										caderrors = caderrors + "- Set a corret date\n (dd/mm/yyyy)\n";
										error = true;
									}
								}
								// Input idclient
								idclientfield.setBorder(borderdefault);
								getidclient = idclientfield.getText();
								if (getidclient.isEmpty()) {
									idclientfield.setBorder(bordererror);
									caderrors = caderrors + "- idclient empty\n";
									error = true;
								} else {
									if (validate.validaidclient(getidclient) == false) {
										idclientfield.setBorder(bordererror);
										caderrors = caderrors + "- idclient Incorrect\n";
										error = true;
									}
								}
								// Si sale un error entra en el IF y los muestra todos.
								if (error == true) {
									Functions.mensajeerror(caderrors, "Error");
								}
							} while (error == true);
							// creamos el Cliente
							Fecha fregistro = new Fecha();
							Client client = new Client(getName, getSurname, getPhone, getDNI, getEmail, fbirthday,
									fregistro, getidclient);
							System.out.println("parte modify");
							String updatesql = "UPDATE Client SET name='" + getName + "',surname='" + getSurname
									+ "',phone='" + getPhone + "',DNI='" + getDNI + "',email='" + getEmail
									+ "',birthday='" + fbirthday.ToString() + "',registro='" + fregistro.ToString()
									+ "',idclient='" + getidclient + "',age='" + client.getAge() + "' WHERE idclient='"
									+ idclient + "'";
							PreparedStatement updateclient = conn.prepareStatement(updatesql);
							updateclient.executeUpdate();
							tabla.setValueAt(getName, row, 0);
							tabla.setValueAt(getSurname, row, 1);
							tabla.setValueAt(getDNI, row, 2);
							tabla.setValueAt(getidclient, row, 3);
						} catch (Exception e2) {
							Functions.mensajeerror("idclient duplicado", "Error");
						} finally {
							System.out.println("Update COmpleted");
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
			registro = result.getString("registro");
			idclient = result.getString("idclient");
			String age = result.getString("age");

			// añadimos datos a la tabla
			modelo.addRow(new Object[] { name, surname, DNI, idclient });
			cad = cad + "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nDNI: " + DNI + "\nEmail: "
					+ email + "\nBirthday: " + birthday + "\nregistro: " + registro + "\nidclient: " + idclient
					+ "\nage: " + age + "\n";
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
}
