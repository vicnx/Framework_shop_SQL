package menu;

import functions.Functions;
import modules.products.Dummies.Dummies_products;
import modules.products.functions.Read_client;
import modules.users.functions.login;

public class menu_cliente {

	public static void main(String[] args) throws Exception {
		int option_principal = 0;
		String boton_menu1[] = { "Read", "Login", "Exit", "D" };
		do {
			option_principal = Functions.menubuttons(boton_menu1, "What do you wantto do?", "Shop_Vicente", 0);
			if (option_principal == -1) {
				System.exit(0);
			}
			if (option_principal == 0) {// Read
				Read_client.main(null);
			} // end if read
			if (option_principal == 1) {// Login
				login.main(null);
			} // end if login
			if (option_principal == 3) {
				Dummies_products.main(null);
			}
		} while (option_principal != 2);
	}

}
