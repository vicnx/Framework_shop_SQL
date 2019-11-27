package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.DataConnection;
import functions.Functions;

public class test1 {
	public static void main(String[] args) throws Exception {
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
				String name, surname, phone, DNI, email, birthday, username, password, cad = "";

				if (e.getClickCount() == 2) {
					int row = tabla.getSelectedRow();
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
									+ DNI + "\nEmail: " + email + "\nBirthday: " + birthday + "\nusername: " + username
									+ "\npassword: " + password + "\n\n";
						}
					} catch (Exception e2) {
						// TODO: handle exception
					} // fintrycatch
					System.out.println(cad);
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
}
