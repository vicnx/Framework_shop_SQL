package menu;

import functions.Functions;
import modules.products.functions.functions_Electronic_CRUD;

public class menu_products {
//Este es el menu de productos
	public static void main(String[] args) {
		int option_product = 0, option_product2 = 0;
		String boton_menu1[] = { "Tablet", "Mobile", "TV", "Return" };
		String boton_menu2[] = { "Create", "Read", "Update", "Delete", "Return" };
		boolean continuer = true;
		do {
			option_product = Functions.menubuttons(boton_menu1, "What type of electronic?", "ViceExpress", 0);
			if (option_product == -1) {
				System.exit(0);
			}
			if (option_product == 0) {// Tablet
				do {
					option_product2 = Functions.menubuttons(boton_menu2, "You want to do?", "Tablet", 0);
					if (option_product2 == -1) {
						continuer = false;
					}
					switch (option_product2) {
					case 0:
						functions_Electronic_CRUD.createElectronic(0);
						continuer = true;
						break;
					case 1:
						functions_Electronic_CRUD.readElectronic(0);
						continuer = true;
						break;
					case 2:
						functions_Electronic_CRUD.updateElectronic(0);
						continuer = true;
						break;
					case 3:
						functions_Electronic_CRUD.deleteElectronic(0);
						continuer = true;
						break;
					case 4:
						continuer = false;
						break;
					}
				} while (continuer == true);
			} // end if tablet
			if (option_product == 1) {// Mobile
				do {
					option_product2 = Functions.menubuttons(boton_menu2, "You want to do?", "Mobile", 0);
					if (option_product2 == -1) {
						continuer = false;
					}
					switch (option_product2) {
					case 0:
						functions_Electronic_CRUD.createElectronic(1);
						continuer = true;
						break;
					case 1:
						functions_Electronic_CRUD.readElectronic(1);
						continuer = true;
						break;
					case 2:
						functions_Electronic_CRUD.updateElectronic(1);
						continuer = true;
						break;
					case 3:
						functions_Electronic_CRUD.deleteElectronic(1);
						continuer = true;
						break;
					case 4:
						continuer = false;
						break;
					}
				} while (continuer == true);
			} // end if mobile
			if (option_product == 2) {// TV
				do {
					option_product2 = Functions.menubuttons(boton_menu2, "You want to do?", "TV", 0);
					if (option_product2 == -1) {
						continuer = false;
					}
					switch (option_product2) {
					case 0:
						functions_Electronic_CRUD.createElectronic(2);
						continuer = true;
						break;
					case 1:
						functions_Electronic_CRUD.readElectronic(2);
						continuer = true;
						break;
					case 2:
						functions_Electronic_CRUD.updateElectronic(2);
						continuer = true;
						break;
					case 3:
						functions_Electronic_CRUD.deleteElectronic(2);
						continuer = true;
						break;
					case 4:
						continuer = false;
						break;
					}
				} while (continuer == true);

			}
		} while (option_product != 3);
	}

}
