package modules.products.functions;

import functions.Functions;

public class Read_client {

	public static void main(String[] args) {
		int option_principal = 0;
		String boton_menu1[] = { "Tablets", "Mobiles", "Tvs", "Return" };
		do {
			option_principal = Functions.menubuttons(boton_menu1, "\r\n" + "What do you want to read?", "Shop_Vicente",
					0);
			if (option_principal == -1) {
				System.exit(0);
			}
			if (option_principal == 0) {// Tablets
				functions_Electronic_CRUD.readElectronic(0);
			} // end if tablets
			if (option_principal == 1) {// mobiles
				functions_Electronic_CRUD.readElectronic(1);
			} // end if mobiles
			if (option_principal == 2) {// Tvs
				functions_Electronic_CRUD.readElectronic(2);
			} // end if Tvs

		} while (option_principal != 3);

	}

}
