package modules.users.functions;

import java.util.ArrayList;

import modules.users.forms.Form_Admin;
import modules.users.forms.Form_Client;

public class functions_users_CRUD {
	// crear users
	public static void createUsers(int tipo) {
		boolean correcto = false;
		if (tipo == 0) {// Client
			do {
				Form_Client.FormClient();
				correcto = true;
			} while (correcto == false);

		} // end if client
		if (tipo == 1) {// Administrator
			do {
				Form_Admin.FormAdmin();
				correcto = true;
			} while (correcto == false);

		} // end if client
	}

	// read user
	public static void readUsers(int tipo) {
		String read = "";
		if (tipo == 0) { // Client
			try {
				Functions_sql.readAllClient();
			} catch (Exception e) {
				// TODO: handle exception
			}
		} // end if Clients
		if (tipo == 1) { // Admin
			try {
				Functions_sql.readAllAdmin();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end if Admins
	}

	// delete users
	public static void deleteUser(int tipo) {
		String read = "";
		Integer num = 0, cont = 0;
		ArrayList<Integer> positions = new ArrayList<Integer>();
		if (tipo == 0) {// Clients
			try {
				Functions_sql.deleteClient();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end if clients
		if (tipo == 1) {// Admin
			try {
				Functions_sql.deleteAdmin();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end if admin
	}

//modificar users
	public static void updateUser(int tipo) {
		if (tipo == 0) {// Client
			try {
				Functions_sql.UpdateClient();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // end if client
		if (tipo == 1) {// Admin
			try {
				Functions_sql.UpdateAdmin();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // end if Admin
	}// end update user
}
