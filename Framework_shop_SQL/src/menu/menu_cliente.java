package menu;

import functions.Functions;
import modules.products.functions.Read_client;
import modules.users.functions.login;

public class menu_cliente {

	public static void main(String[] args) {
		int option_principal = 0;
		String boton_menu1[] = { "Read", "Login", "Exit" };
		do {
			option_principal = Functions.menubuttons(boton_menu1, "\r\n" + "What do you wantto do?", "Shop_Vicente", 0);
			if (option_principal == -1) {
				System.exit(0);
			}
			if (option_principal == 0) {// Read
				Read_client.main(null);
			} // end if read
			if (option_principal == 1) {// Login
				login.main(null);
			} // end if login

		} while (option_principal != 2);
	}

}
