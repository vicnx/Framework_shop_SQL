package modules.products.functions;

import javax.swing.JOptionPane;

import classes.Fecha;
import functions.Functions;
import functions.validate;

public class Datos_electronic {
	public static String pideram() {
		String tipo[] = { "1GB", "2GB", "3GB", "4GB", "6GB", "8GB" };
		String ram = Functions.menucombo(tipo, "RAM", "Select the RAM");
		return ram;

	}

	public static String pideprice() {
		boolean correcto = false;
		String price = "";
		do {
			price = JOptionPane.showInputDialog("Give me the new price");
			if (price == null) {
				return null;
			}
			if (validate.validaprecio(price) == false) {
				Functions.mensajeerror("Error, please set the correct price\n(Max 4 digits)", "Error");
				correcto = false;
			} else {
				correcto = true;
			}
		} while (correcto == false);
		return price;
	}

	public static String pidesim() {
		String tipo[] = { "Yes", "No" };
		String sim;
		sim = Functions.menucombo(tipo, "Sim", "Give me the new value of Sim?");
		return sim;
	}

	public static String piderating() {
		String tipo[] = { "☆", "☆☆", "☆☆☆", "☆☆☆☆", "☆☆☆☆☆" };
		String rating;
		rating = Functions.menucombo(tipo, "Rating", "Give me the new Rating");
		return rating;

	}

	public static String pidesmarttv() {
		String tipo[] = { "Yes", "No" };
		String smarttv;
		smarttv = Functions.menucombo(tipo, "SmartTV", "Give me the new value of Smart TV?");
		return smarttv;
	}

	public static String pideshdmis() {
		String tipo[] = { "1_HDMI", "2_HDMI", "3_HDMI", "4_HDMI" };
		String hdmi;
		hdmi = Functions.menucombo(tipo, "HDMIS", "Give me the new value of HDMIS?");
		return hdmi;
	}

	public static String pidessystem(int tipo) {
		String system = "";
		if (tipo == 0) {// YTablet
			String menu[] = { "IOS", "Android_5.0", "Android_6.0", "Android_7.0", "Android_8.0", "Android_9.0",
					"Windows" };
			system = Functions.menucombo(menu, "Tablet", "Give me the new system");
		}
		if (tipo == 1) {// Mobile
			String menu[] = { "IOS", "Android_5.0", "Android_6.0", "Android_7.0", "Android_8.0", "Android_9.0",
					"Windows" };
			system = Functions.menucombo(menu, "Mobile", "Give me the new system");
		}
		if (tipo == 2) {// Tv
			String menu[] = { "None", "Android_5.0", "Android_6.0", "Android_7.0", "Android_8.0", "Android_9.0", };
			system = Functions.menucombo(menu, "TV", "Give me the new system");
		}
		return system;

	}

	public static String pidesbrand(int tipo) {
		String brand = "";
		if (tipo == 0) {// YTablet
			String menu[] = { "Samsung", "Xiaomi", "Apple", "Windows", "Huawei" };
			brand = Functions.menucombo(menu, "Tablet", "Give me the new brand");
		}
		if (tipo == 1) {// Mobile
			String menu[] = { "Samsung", "Xiaomi", "Apple", "RealMe", "Huawei" };
			brand = Functions.menucombo(menu, "Mobile", "Give me the new brand");
		}
		if (tipo == 2) {// Tv
			String menu[] = { "Samsung", "Sharp", "Peekton", "LG" };
			brand = Functions.menucombo(menu, "TV", "Give me the new brand");
		}
		return brand;

	}

	public static Fecha pidefecha() {
		String fecha = "";
		Fecha f = null;
		boolean correcto = false;
		do {
			fecha = JOptionPane.showInputDialog("Give me the new date");
			if (fecha == null) {
				return null;
			}
			if (validate.validafecha(fecha) == false) {
				Functions.mensajeerror("Error, please set the correct date format\n(dd/mm/yyyy)", "Error");
				correcto = false;
			} else {
				f = new Fecha(fecha);
				if (f.vfecha() == true) {
					if (f.comparaFechas() == 1 || f.comparaFechas() == 3) {
						Functions.mensajeerror("Error, please set the date after today", "Error");
						correcto = false;
					} else {
						correcto = true;
					}
				} else {
					Functions.mensajeerror("Error, please set a valid date!", "Error");
					correcto = false;
				}
			} // end else validfecha
		} while (correcto == false);
		return f;
	}

}
