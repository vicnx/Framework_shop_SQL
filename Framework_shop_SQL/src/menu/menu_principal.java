package menu;

import functions.Functions;
import modules.users.functions.profile;

public class menu_principal {
//Este es el menu de productos
	public static void main(String[] args) throws Exception {
		int option_principal = 0;
		String boton_menu1[] = { "Users", "Products", "Profile", "Logout" };
		do {
			option_principal = Functions.menubuttons(boton_menu1, "\r\n" + "What do you want to manage?",
					"Shop_Vicente", 0);
			if (option_principal == -1) {
				System.exit(0);
			}
			if (option_principal == 0) {// Users
				menu_users.main(null);
			} // end if users
			if (option_principal == 1) {// Products
				menu_products.main(null);
			} // end if products
			if (option_principal == 2) {// Profile
				profile.main(null);
			}

		} while (option_principal != 3);
	}

}