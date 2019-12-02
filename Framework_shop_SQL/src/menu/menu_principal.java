package menu;

import functions.Functions;
import modules.products.Dummies.Dummies_products;
import modules.users.Dummies.Dummies_Users;
import modules.users.functions.profile;

public class menu_principal {
//Este es el menu de productos
	public static void main(String[] args) throws Exception {
		int option_principal = 0, optiondummies = 0;
		String boton_menu1[] = { "Users", "Products", "Profile", "Dummies", "Logout" };
		String dummies[] = { "Products", "Clients", "Return" };
		do {
			option_principal = Functions.menubuttons(boton_menu1, "\r\n" + "What do you want to manage?",
					"Shop_Vicente", 0);
			if (option_principal == -1) {
				return;
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
			if (option_principal == 3) {// Dummies
				optiondummies = Functions.menubuttons(dummies, "What type of dummies?", "Dummies", 2);
				if (optiondummies == -1 || optiondummies == 2) {
					return;
				}
				if (optiondummies == 0) {// products
					Dummies_products.main(null);
				}
				if (optiondummies == 1) {// Clients
					Dummies_Users.main(null);
				}
			}

		} while (option_principal != 4);
	}

}