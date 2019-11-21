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

public class Form_tv {
	// Formulario para crear una tv
	public static ArrayList<Object> FormTv() {
		// Declaramos las variables necesarias.
		String getName = "", getPrice = "", getSystem = "", getBrand = "", getRating = "", getHdmis = "",
				getSmartTv = "", caderrors = "", getFfinal;
		boolean error = false;
		Fecha fechafinal = null;
		String optionmenu[] = { "Create", "Return" };
		String tiposystem[] = { "None", "Android_5.0", "Android_6.0", "Android_7.0", "Android_8.0", "Android_9.0", };
		String tiposbrand[] = { "Samsung", "Sharp", "Peekton", "LG" };
		String tipohdmis[] = { "1_HDMI", "2_HDMI", "3_HDMI", "4_HDMI" };
		String tiposrating[] = { "☆", "☆☆", "☆☆☆", "☆☆☆☆", "☆☆☆☆☆" };
		String tiposmarttv[] = { "Yes", "No" };
		Integer option = 0;
		JTextField name = new JTextField();
		JTextField price = new JTextField();
		JTextField ffinal = new JTextField();
		JComboBox<String> smarttv = new JComboBox<>(tiposmarttv);
		JComboBox<String> system = new JComboBox<>(tiposystem);
		JComboBox<String> brand = new JComboBox<>(tiposbrand);
		JComboBox<String> hdmis = new JComboBox<>(tipohdmis);
		JComboBox<String> rating = new JComboBox<>(tiposrating);
		// Creamos unos bordes para apariencia
		Border bordererror = BorderFactory.createLineBorder(Color.RED, 1);
		Border borderdefault = new JTextField().getBorder();
		// Creamos jun Array List de tipo objeto donde guardaremos el resultado final
		ArrayList<Object> resultTv = new ArrayList<Object>();
		// Creamos el panel en un objeto para que aparezca en una ventan.
		Object[] menu = { "Create a new TV\n\n", "Name", name, "Price", price, "System", system, "Brand", brand,
				"HDMIS", hdmis, "SmartTV", smarttv, "Rating", rating, "Fecha Final Garantia", ffinal };
		do {
			name.setText("TV");
			price.setText("2000");
			ffinal.setText("20/11/2020");
			caderrors = "";
			error = false;
			option = JOptionPane.showInternalOptionDialog(null, menu, "TV", 0, JOptionPane.QUESTION_MESSAGE, null,
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
			// Combo HDMIS
			Object objhdmis = hdmis.getSelectedItem();
			getHdmis = String.valueOf(objhdmis);
			// Combo Smarttv
			Object objsmarttv = smarttv.getSelectedItem();
			getSmartTv = String.valueOf(objsmarttv);
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
		List<Object> list = Arrays.asList(getName, getPrice, getSystem, getBrand, getRating, fechafinal, getSmartTv,
				getHdmis);
		// Añadimos la lista al ArrayList del resultado(creado anteriormente)
		resultTv.addAll(list);
		// Retornamos el ArrayList de resultado
		return resultTv;
	}

}
