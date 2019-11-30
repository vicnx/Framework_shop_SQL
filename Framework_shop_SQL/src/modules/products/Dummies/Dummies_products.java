package modules.products.Dummies;

import java.util.ArrayList;

import classes.Fecha;
import functions.Functions;
import modules.products.classes.Mobile;
import modules.products.classes.Singleton;
import modules.products.classes.Tablet;
import modules.products.classes.tv;
import modules.products.forms.Form_mobile;
import modules.products.forms.Form_tv;
import modules.products.functions.Functions_find_electronic;
import modules.products.functions.Read_client;

public class Dummies_products {

	public static void main(String[] args) {
		// Decllaramos Objetos y variables
		String name = "", brand = "";
		int dummies = 0;
		Tablet Tablet = null;
		Mobile Mobile = null;
		tv TV = null;
		Fecha f_inicio_garantia = new Fecha();
		int time_garantia, width;
		boolean correcto = false;
		dummies = functions.Functions.validnum("Dummies", "How much dummies? (por tipo de producto)");
		for (int i = 0; i < dummies - 1; i++) {
			name = NameGenerator.generateName();
			brand = NameGenerator.generateName();
			Tablet = new Tablet(name, "100", "Android", brand, "5", 2, f_inicio_garantia, f_inicio_garantia, "20",
					"Yes", 0, "2GB", "200GB", "4000");
			Singleton.electronics.add(Tablet);
			Mobile = new Mobile(name, "100", "Android", brand, "5", 2, f_inicio_garantia, f_inicio_garantia, 2, "2GB",
					"200GB", "4000");
			Singleton.electronics.add(Mobile);
			TV = new tv(name, "200", "Null", brand, "5", 2, f_inicio_garantia, f_inicio_garantia, "yes", "4");
			Singleton.electronics.add(TV);
		}

		Read_client.main(null);

		do {
			time_garantia = 2;// Functions.validpositive("Time", "Give me the time garantia");
			f_inicio_garantia = null;// JOptionPane.showInputDialog("Start garanty?");
			// f_final_garantia = "1/2/2022";// JOptionPane.showInputDialog("Finish
			// garanty?");
			width = 8;// Functions.validpositive("width", "Give me the width");
			ArrayList<Object> arraymobiles = new ArrayList<Object>();
			arraymobiles = Form_mobile.FormMobile();
			if (arraymobiles == null) {
				return;
			}
			Mobile = null;
			Mobile = new Mobile((String) arraymobiles.get(0), (String) arraymobiles.get(1),
					(String) arraymobiles.get(2), (String) arraymobiles.get(3), (String) arraymobiles.get(4),
					time_garantia, f_inicio_garantia, (Fecha) arraymobiles.get(5), width, (String) arraymobiles.get(6),
					(String) arraymobiles.get(7), (String) arraymobiles.get(8));
			if (Functions_find_electronic.find_mobile(Mobile) == -1) {
				Singleton.electronics.add(Mobile);
				correcto = true;

			} else {
				Functions.mensajeerror("A mobile with that name already exist", "Error");
				correcto = false;
			}
		} while (correcto == false);

		do {
			time_garantia = 2;// Functions.validpositive("Time", "Give me the time garantia");
			f_inicio_garantia = null;// JOptionPane.showInputDialog("Start garanty?");
			// f_final_garantia = "1/2/2022";// JOptionPane.showInputDialog("Finish
			// garanty?");
			ArrayList<Object> arraytvs = new ArrayList<Object>();
			arraytvs = Form_tv.FormTv();
			if (arraytvs == null) {
				return;
			}
			TV = null;
			TV = new tv((String) arraytvs.get(0), (String) arraytvs.get(1), (String) arraytvs.get(2),
					(String) arraytvs.get(3), (String) arraytvs.get(4), time_garantia, f_inicio_garantia,
					(Fecha) arraytvs.get(5), (String) arraytvs.get(6), (String) arraytvs.get(7));
			if (Functions_find_electronic.find_tv(TV) == -1) {
				Singleton.electronics.add(TV);
				correcto = true;
			} else {
				Functions.mensajeerror("A tv with that name already exist", "Error");
				correcto = false;
			}
		} while (correcto == false);
	}
}
