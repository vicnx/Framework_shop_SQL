package modules.products.forms;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import classes.Fecha;
import functions.Functions;
import functions.validate;

public class Form_mobile {
	// Formulario para crear un Mobile
	public static ArrayList<Object> FormMobile() {
		// Declaramos las variables necesarias.
		String getName = "", getRam = "", getPrice = "", getSystem = "", getBrand = "", getRating = "",
				getCapacity = "", getBatery = "", caderrors = "", getFfinal = "";
		Fecha fechafinal = null;
		boolean error = false;
		String optionmenu[] = { "Create", "Return" };
		String tiporam[] = { "1GB", "2GB", "3GB", "4GB", "6GB", "8GB" };
		String tiposystem[] = { "IOS", "Android_5.0", "Android_6.0", "Android_7.0", "Android_8.0", "Android_9.0",
				"Windows" };
		String tiposbrand[] = { "Samsung", "Xiaomi", "Apple", "RealMe", "Huawei" };
		String tipocapacity[] = { "32GB", "64GB", "128GB", "256GB", "500GB", "1000GB" };
		String tiposrating[] = { "☆", "☆☆", "☆☆☆", "☆☆☆☆", "☆☆☆☆☆" };
		Integer option = 0;
		JTextField name = new JTextField();
		JTextField price = new JTextField();
		JTextField batery = new JTextField();
		JTextField ffinal = new JTextField();
		JComboBox<String> ram = new JComboBox<>(tiporam);
		JComboBox<String> system = new JComboBox<>(tiposystem);
		JComboBox<String> brand = new JComboBox<>(tiposbrand);
		JComboBox<String> capacity = new JComboBox<>(tipocapacity);
		JComboBox<String> rating = new JComboBox<>(tiposrating);
		// Creamos unos bordes para apariencia
		Border bordererror = BorderFactory.createLineBorder(Color.RED, 1);
		Border borderdefault = new JTextField().getBorder();
		// Creamos jun Array List de tipo objeto donde guardaremos el resultado final
		ArrayList<Object> resultMobile = new ArrayList<Object>();
		// Creamos el panel en un objeto para que aparezca en una ventan.
		Object[] menu = { "Create a new Mobile\n\n", "Name", name, "Price", price, "System", system, "Brand", brand,
				"Ram", ram, "Capacity", capacity, "Batery", batery, "Rating", rating, "Fecha Final Garantia", ffinal };
		do {
			name.setText("MOBILE");
			price.setText("200");
			batery.setText("3500");
			ffinal.setText("20/11/2020");
			caderrors = "";
			error = false;
			option = JOptionPane.showInternalOptionDialog(null, menu, "Mobile", 0, JOptionPane.QUESTION_MESSAGE, null,
					optionmenu, optionmenu[0]);
			if (option == -1 || option == 1) {
				return null;
			}
			/// Input Name
			name.setBorder(borderdefault);
			getName = name.getText();// Guardamos el texto en getXXX
			if (getName.isEmpty()) {// Si esta vacio entra en el error.
				name.setBorder(bordererror);
				caderrors = caderrors + "- Name empty\n";
				error = true;
			}
			/// Input Price
			price.setBorder(borderdefault);
			getPrice = price.getText();
			if (getPrice.isEmpty()) {
				price.setBorder(bordererror);
				caderrors = caderrors + "- Price empty\n";
				error = true;
			} else {
				if (validate.validaprecio(getPrice) == false) {// Si no sige el patron de precio, salta el error
					price.setBorder(bordererror);
					caderrors = caderrors + "- Set the correct price\n (Max 4 digits)\n";
					error = true;
				}
			}
			// Combo System
			Object objsystem = system.getSelectedItem(); // Guardamos el item seleccionado en un Object
			getSystem = String.valueOf(objsystem); // Lo convertimos en String
			// Combo Brand
			Object objbrand = brand.getSelectedItem();
			getBrand = String.valueOf(objbrand);
			// Combo Ram
			Object objram = ram.getSelectedItem();
			getRam = String.valueOf(objram);
			// Combo capacity
			Object objcapacity = capacity.getSelectedItem();
			getCapacity = String.valueOf(objcapacity);
			// Input Bateria
			batery.setBorder(borderdefault);
			getBatery = batery.getText();
			if (getBatery.isEmpty()) {
				batery.setBorder(bordererror);
				caderrors = caderrors + "- Batery empty\n";
				error = true;
			} else {
				if (validate.validbatery(getBatery) == false) {
					batery.setBorder(bordererror);
					caderrors = caderrors + "- Set the correct batery\n(ex: 3600,)\n";
					error = true;
				}
			}
			// Combo Rating
			Object objrating = rating.getSelectedItem();
			getRating = String.valueOf(objrating);
			// Pedimos solo la fecha final de la garantia
			ffinal.setBorder(borderdefault);
			if (ffinal.getText().isEmpty()) {
				ffinal.setBorder(bordererror);
				caderrors = caderrors + "- Fecha final garantia empty\n";
				error = true;
			} else {
				getFfinal = ffinal.getText();
				if (validate.validafecha(getFfinal) == true) {
					fechafinal = new Fecha(getFfinal);
					if (fechafinal.vfecha() == true) {
						if ((fechafinal.comparaFechas() == 1) || (fechafinal.comparaFechas() == 3)) {
							caderrors = caderrors + "- Ser a date after today\n";
							error = true;
						}
					} else {
						caderrors = caderrors + "- Insert a valid date!\n";
						error = true;
					}
				} else {
					ffinal.setBorder(bordererror);
					caderrors = caderrors + "- Set the corret date\n (dd/mm/yyyy)\n";
					error = true;
				}
			}
			// Si sale un error entra en el IF y los muestra todos.
			if (error == true) {
				Functions.mensajeerror(caderrors, "Error");
			}
		} while (error == true);
		// Creamos una lista para guardar todos los atributos.
		List<Object> list = Arrays.asList(getName, getPrice, getSystem, getBrand, getRating, fechafinal, getRam,
				getCapacity, getBatery);
		// Añadimos la lista al ArrayList del resultado(creado anteriormente)
		resultMobile.addAll(list);
		// Retornamos el ArrayList de resultado
		return resultMobile;
	}
}
