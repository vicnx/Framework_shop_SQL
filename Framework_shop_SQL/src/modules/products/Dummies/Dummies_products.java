package modules.products.Dummies;

import java.text.DecimalFormat;
import java.util.Random;

import classes.Fecha;
import modules.products.classes.Mobile;
import modules.products.classes.Singleton;
import modules.products.classes.Tablet;
import modules.products.classes.tv;

public class Dummies_products {

	public static void main(String[] args) {
		// Decllaramos Objetos y variables
		DecimalFormat df2 = new DecimalFormat("#.##");
		String name = "", brand = "", namemobile, nametv;
		Integer dummies = 0;
		String precio = "", rating = "";
		double first = 0.0;
		double last = 5.0;
		int precios = 0;
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
		for (int i = 1; i <= dummies; i++) {
			precios = (int) (Math.random() * (100 - 900 + 1) + 900);
			precio = Integer.toString(precios);
			double random = new Random().nextDouble();
			double result = first + (random * (last - first));
			int decimals = 2;
			name = classes.NameGenerator.generateName(0);
			namemobile = classes.NameGenerator.generateName(0);
			nametv = classes.NameGenerator.generateName(0);
			brand = classes.NameGenerator.generateName(0);
			Tablet = new Tablet(name, precio, "Android", brand, df2.format(result), 2, f_inicio_garantia,
					f_inicio_garantia, "20", "Yes", 0, "2GB", "200GB", "4000");
			Singleton.electronics.add(Tablet);
			Mobile = new Mobile(namemobile, precio, "Android", brand, df2.format(result), 2, f_inicio_garantia,
					f_inicio_garantia, 2, "2GB", "200GB", "4000");
			Singleton.electronics.add(Mobile);
			TV = new tv(nametv, precio, "Null", brand, df2.format(result), 2, f_inicio_garantia, f_inicio_garantia,
					"yes", "4");
			Singleton.electronics.add(TV);
		}
	}
}
