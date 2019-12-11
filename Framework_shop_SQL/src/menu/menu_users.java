package menu;

import functions.Functions;
import modules.users.functions.functions_users_CRUD;

public class menu_users {

	public static void main(String[] args) {
//Este es el menu de Usuarios
		int option_users = 0, option_users2;
		String boton_menu1[] = { "Clients", "Administrators", "Return" };
		String boton_menu2[] = { "Create", "Read", "Update", "Delete", "Return" };
		boolean continuer_user = true;
		do {
			option_users = Functions.menubuttons(boton_menu1, "What type of user?", "Users Management", 0);
			if (option_users == -1) {
				System.exit(0);
			}
			if (option_users == 0) {// Clients
				do {
					option_users2 = Functions.menubuttons(boton_menu2, "You want to do?", "Clients", 0);
					if (option_users2 == -1) {
						continuer_user = false;
					}
					switch (option_users2) {
					case 0:
						functions_users_CRUD.createUsers(0);
						continuer_user = true;
						break;
					case 1:
						functions_users_CRUD.readUsers(0);
						continuer_user = true;
						break;
					case 2:
						functions_users_CRUD.updateUser(0);
						continuer_user = true;
						break;
					case 3:
						functions_users_CRUD.deleteUser(0);
						continuer_user = true;
						break;
					case 4:
						continuer_user = false;
						break;
					}
				} while (continuer_user == true);
			} // end if clients
			if (option_users == 1) {// Administrators
				do {
					option_users2 = Functions.menubuttons(boton_menu2, "You want to do?", "Administrators", 0);
					if (option_users2 == -1) {
						continuer_user = false;
					}
					switch (option_users2) {
					case 0:
						functions_users_CRUD.createUsers(1);
						continuer_user = true;
						break;
					case 1:
						functions_users_CRUD.readUsers(1);
						continuer_user = true;
						break;
					case 2:
						functions_users_CRUD.updateUser(1);
						continuer_user = true;
						break;
					case 3:
						functions_users_CRUD.deleteUser(1);
						continuer_user = true;
						break;
					case 4:
						continuer_user = false;
						break;
					}
				} while (continuer_user == true);
			} // end if administrators
		} while (option_users != 2);
	}

}
