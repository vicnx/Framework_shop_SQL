package menu;

import functions.Functions;

public class menu_principal {
//Este es el menu de productos
	public static void main(String[] args) {
		int option_principal = 0;
		String boton_menu1[] = { "Users", "Products", "Exit" };
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

		} while (option_principal != 2);
	}

}