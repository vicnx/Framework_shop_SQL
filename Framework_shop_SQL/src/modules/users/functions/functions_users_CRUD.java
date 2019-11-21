package modules.users.functions;

import java.util.ArrayList;

import classes.Fecha;
import functions.Functions;
import modules.users.classes.Admin;
import modules.users.classes.Client;
import modules.users.classes.Singleton;
import modules.users.classes.User;
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
		Client client;
		Admin admin;
		int age;
		String[] optionclient = { "Update_name", "Update_surname", "Update_phone", "Update_DNI", "Update_email",
				"Update_birthday", "Update_idclient" };
		String[] optionadmin = { "Update_name", "Update_surname", "Update_phone", "Update_DNI", "Update_email",
				"Update_birthday", "Update_username", "Update_password" };
		String option = "", name = "", read = "", surname = "", phone = "", DNI = "", email = "", idclient = "",
				username = "", password = "";
		Fecha birthday;
		Integer num = 0, cont = 0, positionReal = 0;
		ArrayList<Integer> positions = new ArrayList<Integer>();
		if (tipo == 0) {// Client
			for (int i = 0; i < Singleton.users.size(); i++) {
				User User = (Client) Singleton.users.get(i);
				if (User instanceof Client) {
					positions.add(i);
					cont++;
					read = read + (cont) + "- " + User.getName() + "\n";
				} // end instanceof Clients
			} // end for Clients
			if (read == "") {
				Functions.mensajeinf("Nothing to modify, please create a Client", "Update Client");
			} else {
				num = Functions.validnum(read, "Update Client");
				if (num == null) {
					return;
				}
				if (num > Singleton.users.size()) {
					Functions.mensajeerror("Insert a valid Client", "Error");
				} else {
					positionReal = positions.get(num - 1);
					client = (Client) Singleton.users.get(positionReal);
					option = Functions.menucombo(optionclient, "Client", "Modify?");
					if (option == null) {
						return;
					}
					switch (option) {
					case "Update_name":
						name = Datos_users.pidename();
						if (name == null) {
							return;
						} else {
							client.setName(name);
						}
						break;
					case "Update_surname":
						surname = Datos_users.pidesurname();
						if (surname == null) {
							return;
						} else {
							client.setSurname(surname);
						}
						break;
					case "Update_phone":
						phone = Datos_users.pidephone();
						if (phone == null) {
							return;
						} else {
							client.setPhone(phone);
						}
						break;
					case "Update_DNI":
						DNI = Datos_users.pidedni();
						if (DNI == null) {
							return;
						} else {
							client.setDNI(DNI);
						}
						break;
					case "Update_email":
						email = Datos_users.pideemail();
						if (email == null) {
							return;
						} else {
							client.setEmail(email);
						}
						break;
					case "Update_birthday":
						birthday = Datos_users.pidebirthday();
						if (birthday == null) {
							return;
						} else {
							client.setBirthday(birthday);
							age = client.calculateAge();
							client.setAge(age);
						}
						break;
					case "Update_idclient":
						idclient = Datos_users.pideidcliente();
						if (idclient == null) {
							return;
						} else {
							client.setIdclient(idclient);
						}
						break;
					}// fincase

				} // finelse
			}
		} // end if client
		if (tipo == 1) {// Admin
			for (int i = 0; i < Singleton.users.size(); i++) {
				User Admin = (Admin) Singleton.users.get(i);
				if (Admin instanceof Admin) {
					positions.add(i);
					cont++;
					read = read + (cont) + "- " + Admin.getName() + "\n";
				} // end instanceof Admin
			} // end for Admin
			if (read == "") {
				Functions.mensajeinf("Nothing to modify, please create a Admin", "Update Admin");
			} else {
				num = Functions.validnum(read, "Update Admin");
				if (num == null) {
					return;
				}
				if (num > Singleton.users.size()) {
					Functions.mensajeerror("Insert a valid Admin", "Error");
				} else {
					positionReal = positions.get(num - 1);
					admin = (Admin) Singleton.users.get(positionReal);
					option = Functions.menucombo(optionadmin, "Admin", "Modify?");
					if (option == null) {
						return;
					}
					switch (option) {
					case "Update_name":
						name = Datos_users.pidename();
						if (name == null) {
							return;
						} else {
							admin.setName(name);
						}
						break;
					case "Update_surname":
						surname = Datos_users.pidesurname();
						if (surname == null) {
							return;
						} else {
							admin.setSurname(surname);
						}
						break;
					case "Update_phone":
						phone = Datos_users.pidephone();
						if (phone == null) {
							return;
						} else {
							admin.setPhone(phone);
						}
						break;
					case "Update_DNI":
						DNI = Datos_users.pidedni();
						if (DNI == null) {
							return;
						} else {
							admin.setDNI(DNI);
						}
						break;
					case "Update_email":
						email = Datos_users.pideemail();
						if (email == null) {
							return;
						} else {
							admin.setEmail(email);
						}
						break;
					case "Update_birthday":
						birthday = Datos_users.pidebirthday();
						if (birthday == null) {
							return;
						} else {
							admin.setBirthday(birthday);
							age = admin.calculateAge();
							admin.setAge(age);
						}
						break;
					case "Update_username":
						username = Datos_users.pideusername();
						if (username == null) {
							return;
						} else {
							admin.setUsername(username);
							;
						}
						break;
					case "Update_password":
						password = Datos_users.pidepassword();
						if (password == null) {
							return;
						} else {
							admin.setPassword(password);
						}
					}// fincase

				} // finelse
			}
		} // end if Admin
	}// end update user
}
