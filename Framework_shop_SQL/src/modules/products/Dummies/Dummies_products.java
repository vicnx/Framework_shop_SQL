package modules.products.Dummies;

import classes.Fecha;
import modules.products.classes.Mobile;
import modules.products.classes.Singleton;
import modules.products.classes.Tablet;
import modules.products.classes.tv;

public class Dummies_products {

	public static void main(String[] args) {
		// Decllaramos Objetos y variables
		String name = "", brand = "";
		Integer dummies = 0;
		Tablet Tablet = null;
		Mobile Mobile = null;
		tv TV = null;
		Fecha f_inicio_garantia = new Fecha();
		int time_garantia, width;
		boolean correcto = false;
		dummies = functions.Functions.validnum("How much dummies? (por tipo de producto)", "Dummies");
		if (dummies == null) {
			return;
		}
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
	}
}
