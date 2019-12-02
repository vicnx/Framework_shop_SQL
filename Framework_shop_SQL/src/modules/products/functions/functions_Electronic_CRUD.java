package modules.products.functions;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import classes.Fecha;
import functions.Functions;
import modules.products.classes.Electronic;
import modules.products.classes.Mobile;
import modules.products.classes.Singleton;
import modules.products.classes.Tablet;
import modules.products.classes.tv;
import modules.products.forms.Form_mobile;
import modules.products.forms.Form_tablet;
import modules.products.forms.Form_tv;

public class functions_Electronic_CRUD {
	// Crear electronico
	public static void createElectronic(int tipo) {
		// Decllaramos Objetos y variables
		Tablet Tablet = null;
		Mobile Mobile = null;
		tv TV = null;
		Fecha f_inicio_garantia = new Fecha();
		int time_garantia, width;
		boolean correcto = false;
		if (tipo == 0) {// Tablet
			do {
				time_garantia = 2;// Functions.validpositive("Time", "Give me the time garantia");
				width = 8;// Functions.validpositive("width", "Give me the width");
				// Creamos el Array de Objetos donde se guardaran los datos del formulario
				ArrayList<Object> arraytablets = new ArrayList<Object>();
				arraytablets = Form_tablet.FormTablet();// Guardamos los datos del form en el array
				if (arraytablets == null) {// Si se cierra de la X vuelve al menu anterior
					return;
				}
				Tablet = null;
				Tablet = new Tablet((String) arraytablets.get(0), (String) arraytablets.get(1),
						(String) arraytablets.get(2), (String) arraytablets.get(3), (String) arraytablets.get(4),
						time_garantia, f_inicio_garantia, (Fecha) arraytablets.get(5), (String) arraytablets.get(6),
						(String) arraytablets.get(7), width, (String) arraytablets.get(8), (String) arraytablets.get(9),
						(String) arraytablets.get(10));// Añadimos cada una de las posiciones del Array con su
														// respectivo
														// Atributo
				if (Functions_find_electronic.find_tablet(Tablet) == -1) {
					Singleton.electronics.add(Tablet);// Añadimos el Objeto a la clase Electronics.
					correcto = true;
				} else {
					Functions.mensajeerror("A tablet with that name already exist", "Error");
					correcto = false;
				}
			} while (correcto == false);

		}
		if (tipo == 1) {// Mobile
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
						time_garantia, f_inicio_garantia, (Fecha) arraymobiles.get(5), width,
						(String) arraymobiles.get(6), (String) arraymobiles.get(7), (String) arraymobiles.get(8));
				if (Functions_find_electronic.find_mobile(Mobile) == -1) {
					Singleton.electronics.add(Mobile);
					correcto = true;

				} else {
					Functions.mensajeerror("A mobile with that name already exist", "Error");
					correcto = false;
				}
			} while (correcto == false);

		}
		if (tipo == 2) {// tv
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

	// read electronico
	public static void readElectronic(int tipo) {
		String columnas[] = { "name", "price", "rating" };
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(columnas);
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(modelo);
		JTable tabla = new JTable();
		tabla.setModel(modelo);
		tabla.setRowSorter(sorter);
		JScrollPane desplazamiento = new JScrollPane(tabla);
		desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFillsViewportHeight(true);
		tabla.setDefaultEditor(Object.class, null);
		desplazamiento.setPreferredSize(new Dimension(400, 400));
		Object ter[] = { desplazamiento };
		String read = "";
		// order
		if (tipo == 0) {
			tabla.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					String cad = "";
					if (e.getClickCount() == 2) {
						int row = tabla.getSelectedRow();
						if (row == -1) {
							Functions.mensajeerror("Nada que mostrar", "Error");
						} else {
							String dato = (String) tabla.getValueAt(row, 0);
							for (int i = 0; i < Singleton.electronics.size(); i++) {
								Electronic Electronic2 = Singleton.electronics.get(i);
								if (Electronic2 instanceof Tablet) {
									if (dato == Electronic2.getName()) {
										cad = dato + ": \n" + Electronic2;
									} // end if dato==
								}

							}
						}
						Functions.mensajeinf(cad, "Read Tablet");
					} // endif count ==2
				}// endvoidmouse
			});
			for (int i = 0; i < Singleton.electronics.size(); i++) {
				Electronic Electronic = Singleton.electronics.get(i);
				if (Electronic instanceof Tablet) {
					modelo.addRow(new Object[] { Electronic.getName(), Electronic.getPrice(), Electronic.getRating() });
					read = read + Electronic + "\n";
				}
			}
			if (read == "") {
				Functions.mensajeinf("Nothing", "Read");
			} else {
				JOptionPane.showMessageDialog(null, ter);
			}
		} // endif tablet
		if (tipo == 1) {// mobile
			tabla.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					String cad = "";
					if (e.getClickCount() == 2) {
						int row = tabla.getSelectedRow();
						if (row == -1) {
							Functions.mensajeerror("Nada que mostrar", "Error");
						} else {
							String dato = (String) tabla.getValueAt(row, 0);
							for (int i = 0; i < Singleton.electronics.size(); i++) {
								Electronic Electronic2 = Singleton.electronics.get(i);
								if (Electronic2 instanceof Mobile) {
									if (dato == Electronic2.getName()) {
										cad = dato + ": \n" + Electronic2;
									} // end if dato==
								}

							}
						}
						Functions.mensajeinf(cad, "Read Mobile");
					} // endif count ==2
				}// endvoidmouse
			});
			for (int i = 0; i < Singleton.electronics.size(); i++) {
				Electronic Electronic = Singleton.electronics.get(i);
				if (Electronic instanceof Mobile) {
					modelo.addRow(new Object[] { Electronic.getName(), Electronic.getPrice(), Electronic.getRating() });
					read = read + Electronic + "\n";
				}
			}
			if (read == "") {
				Functions.mensajeinf("Nothing", "Read");
			} else {
				JOptionPane.showMessageDialog(null, ter);
			}
		} // end if mobile
		if (tipo == 2) {// TV
			tabla.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					String cad = "";
					if (e.getClickCount() == 2) {
						int row = tabla.getSelectedRow();
						if (row == -1) {
							Functions.mensajeerror("Nada que mostrar", "Error");
						} else {
							String dato = (String) tabla.getValueAt(row, 0);
							for (int i = 0; i < Singleton.electronics.size(); i++) {
								Electronic Electronic2 = Singleton.electronics.get(i);
								if (Electronic2 instanceof tv) {
									if (dato == Electronic2.getName()) {
										cad = dato + ": \n" + Electronic2;
									} // end if dato==
								}

							}
						}
						Functions.mensajeinf(cad, "Read TV");
					} // endif count ==2
				}// endvoidmouse
			});
			for (int i = 0; i < Singleton.electronics.size(); i++) {
				Electronic Electronic = Singleton.electronics.get(i);
				if (Electronic instanceof tv) {
					modelo.addRow(new Object[] { Electronic.getName(), Electronic.getPrice(), Electronic.getRating() });
					read = read + Electronic + "\n";
				}
			}
			if (read == "") {
				Functions.mensajeinf("Nothing", "Read");
			} else {
				JOptionPane.showMessageDialog(null, ter);
			}
		} // eniftv

	}// endfunction

	// Delete
	public static void deleteElectronic(int tipo) {
		String read = "";
		Integer num = 0, cont = 0;
		ArrayList<Integer> positions = new ArrayList<Integer>();
		if (tipo == 0) { // tablets
			for (int i = 0; i < Singleton.electronics.size(); i++) {
				Electronic Electronic = Singleton.electronics.get(i);
				if (Electronic instanceof Tablet) {
					positions.add(i);
					cont++;
					read = read + (cont) + "- " + Electronic.getName() + "\n";
				}
			}
			if (read == "") {
				Functions.mensajeinf("Nothing to delete, please create a Tablet", "Delete Tablet");
			} else {
				num = Functions.validnum(read, "Remove Tablet");
				if (num == null) {
					return;
				}
				if (num > Singleton.electronics.size()) {
					Functions.mensajeerror("Insert a valid Tablet", "Error");
				} else {
					int pos = positions.get(num - 1);
					Singleton.electronics.remove(pos);
				}
			}
		} // end if 1
		if (tipo == 1) { // Mobile
			for (int i = 0; i < Singleton.electronics.size(); i++) {
				Electronic mobile = Singleton.electronics.get(i);
				if (mobile instanceof Mobile) {
					positions.add(i);
					cont++;
					read = read + (cont) + "- " + mobile.getName() + "\n";
				}
			}
			if (read == "") {
				Functions.mensajeinf("Nothing to delete, please create a Mobile", "Delete Mobile");
			} else {
				num = Functions.validnum(read, "Remove Mobile");
				if (num == null) {
					return;
				}
				if (num > Singleton.electronics.size() || (num > positions.size())) {
					Functions.mensajeerror("Insert a valid Mobile", "Error");
				} else {
					int pos = positions.get(num - 1);
					Singleton.electronics.remove(pos);
				}
			}
		} // end if mobile
		if (tipo == 2) {// tv
			for (int i = 0; i < Singleton.electronics.size(); i++) {
				Electronic TV = Singleton.electronics.get(i);
				if (TV instanceof tv) {
					positions.add(i);
					cont++;
					read = read + (cont) + "- " + TV.getName() + "\n";
				}
			}
			if (read == "") {
				Functions.mensajeinf("Nothing to delete, please create a TV", "Delete TV");
			} else {
				num = Functions.validnum(read, "Remove TV");
				if (num == null) {
					return;
				}
				if (num > Singleton.electronics.size() || (num > positions.size())) {
					Functions.mensajeerror("Insert a valid TV", "Error");
				} else {
					int pos = positions.get(num - 1);
					Singleton.electronics.remove(pos);
				}
			}
		} // end if TVs
	}

	public static void updateElectronic(int tipo) {
		Tablet tablet;
		Mobile mobile;
		tv TV;
		String[] optiontablet = { "Update_name", "Update_price", "Update_system", "Update_brand", "Update_rating",
				"Update_sim", "Update_fecha_final", "Update_width(NO)", "Update_ram(NO)", "Update_capacity(NO)",
				"Update_batery(NO)" };
		String[] optionmobile = { "Update_name", "Update_price", "Update_system", "Update_brand", "Update_rating",
				"Update_fecha_final", "Update_width(NO)", "Update_ram(NO)", "Update_capacity(NO)", "Update_batery(NO)",
				"Update_rear_camera(NO)", "Update_front_camera(NO)" };
		String[] optiontv = { "Update_name", "Update_price", "Update_system", "Update_brand", "Update_rating",
				"Update_smarttv", "Update_Hdmis", "Update_fecha_final" };
		String option = "", name = "", read = "";
		Fecha fechafinal = null;
		Integer num = 0, cont = 0, positionReal = 0;
		ArrayList<Integer> positions = new ArrayList<Integer>();// Creamos un array de posiciones para guardar la
																// posicion real
		if (tipo == 0) {// Tablet
			for (int i = 0; i < Singleton.electronics.size(); i++) {
				Electronic Tablet = Singleton.electronics.get(i);
				if (Tablet instanceof Tablet) {
					cont++;
					read = read + (cont) + "- " + Tablet.getName() + "\n";
					positions.add(i);// SI es tablet guardamos la posicion real en un arraay
				}
			}
			if (read == "") {
				Functions.mensajeinf("Nothing to modify, please create a Tablet", "Update Tablet");
			} else {
				num = Functions.validnum(read, "Update Tablet");
				if (num == null) {
					return;
				}
				if (num > Singleton.electronics.size()) {
					Functions.mensajeerror("Insert a valid Tablet", "Error");
				} else {
					positionReal = positions.get(num - 1);// Guardamos la posicion real del NUM seleccionado en un
															// Integer
					tablet = (Tablet) Singleton.electronics.get(positionReal);// Cojemos el objeto de la posicion real
					option = Functions.menucombo(optiontablet, "Tablet", "Modify?");
					if (option == null) {
						return;
					}
					switch (option) {
					case "Update_name":
						name = JOptionPane
								.showInputDialog("Retype the name of the tablet\n\nName: " + tablet.getName());
						tablet.setName(name);
						break;
					case "Update_price":
						String price = "";
						price = Datos_electronic.pideprice();
						if (price == null) {
							return;
						} else {
							tablet.setPrice(price);
						}
						break;
					case "Update_system":
						String system = Datos_electronic.pidessystem(0);
						if (system == null) {
							return;
						} else {
							tablet.setPrice(system);
						}
						break;
					case "Update_brand":
						String brand = Datos_electronic.pidesbrand(0);
						if (brand == null) {
							return;
						} else {
							tablet.setPrice(brand);
						}
						break;
					case "Update_rating":
						String rating = Datos_electronic.piderating();
						if (rating == null) {
							return;
						} else {
							tablet.setPrice(rating);
						}
						break;
					case "Update_sim":
						String sim = Datos_electronic.pidesim();
						tablet.setSim(sim);
						break;
					case "Update_fecha_final":
						fechafinal = Datos_electronic.pidefecha();
						tablet.setF_final_garantia(fechafinal);
						break;
					}// end case
				} // end else2
			} // end else1

		} // end tablet
		if (tipo == 1) {// Mobile
			for (int i = 0; i < Singleton.electronics.size(); i++) {
				Electronic Mobile = Singleton.electronics.get(i);
				if (Mobile instanceof Mobile) {
					cont++;
					read = read + (cont) + "- " + Mobile.getName() + "\n";
					positions.add(i);
				}
			}
			if (read == "") {
				Functions.mensajeinf("Nothing to modify, please create a Mobile", "Update Mobile");
			} else {
				num = Functions.validnum(read, "Update Mobile");
				if (num == null) {
					return;
				}
				if (num > Singleton.electronics.size()) {
					Functions.mensajeerror("Insert a valid Mobile", "Error");
				} else {
					positionReal = positions.get(num - 1);
					mobile = (Mobile) Singleton.electronics.get(positionReal);
					option = Functions.menucombo(optionmobile, "Mobile", "Modify?");
					if (option == null) {
						return;
					}
					switch (option) {
					case "Update_name":
						name = JOptionPane
								.showInputDialog("Retype the name of the tablet\n\nName: " + mobile.getName());
						mobile.setName(name);
						break;
					case "Update_price":
						String price = "";
						price = Datos_electronic.pideprice();
						if (price == null) {
							return;
						} else {
							mobile.setPrice(price);
						}
						break;
					case "Update_system":
						String system = Datos_electronic.pidessystem(1);
						if (system == null) {
							return;
						} else {
							mobile.setSystem(system);
						}
						break;
					case "Update_brand":
						String brand = Datos_electronic.pidesbrand(1);
						if (brand == null) {
							return;
						} else {
							mobile.setBrand(brand);
						}
						break;
					case "Update_rating":
						String rating = Datos_electronic.piderating();
						if (rating == null) {
							return;
						} else {
							mobile.setRating(rating);
						}
						break;
					case "Update_fecha_final":
						fechafinal = Datos_electronic.pidefecha();
						mobile.setF_final_garantia(fechafinal);
						break;
					}// end case
				} // end else2
			} // end else1
		} // end MObile
		if (tipo == 2) {// Tv
			for (int i = 0; i < Singleton.electronics.size(); i++) {
				Electronic tv = Singleton.electronics.get(i);
				if (tv instanceof tv) {
					cont++;
					read = read + (cont) + "- " + tv.getName() + "\n";
					positions.add(i);
				}
			}
			if (read == "") {
				Functions.mensajeinf("Nothing to modify, please create a TV", "Update TV");
			} else {
				num = Functions.validnum(read, "Update TV");
				if (num == null) {
					return;
				}
				if (num > Singleton.electronics.size()) {
					Functions.mensajeerror("Insert a valid TV", "Error");
				} else {
					positionReal = positions.get(num - 1);
					TV = (tv) Singleton.electronics.get(positionReal);
					option = Functions.menucombo(optiontv, "TV", "Modify?");
					if (option == null) {
						return;
					}
					switch (option) {
					case "Update_name":
						name = JOptionPane.showInputDialog("Retype the name of the TV\n\nName: " + TV.getName());
						TV.setName(name);
						break;
					case "Update_price":
						String price = "";
						price = Datos_electronic.pideprice();
						if (price == null) {
							return;
						} else {
							TV.setPrice(price);
						}
						break;
					case "Update_system":
						String system = Datos_electronic.pidessystem(2);
						if (system == null) {
							return;
						} else {
							TV.setSystem(system);
						}
						break;
					case "Update_brand":
						String brand = Datos_electronic.pidesbrand(2);
						if (brand == null) {
							return;
						} else {
							TV.setBrand(brand);
						}
						break;
					case "Update_rating":
						String rating = Datos_electronic.piderating();
						if (rating == null) {
							return;
						} else {
							TV.setRating(rating);
						}
						break;
					case "Update_smarttv":
						String smarttv = Datos_electronic.pidesmarttv();
						if (smarttv == null) {
							return;
						} else {
							TV.setSmarttv(smarttv);
						}
						break;
					case "Update_Hdmis":
						String Hdmis = Datos_electronic.pideshdmis();
						if (Hdmis == null) {
							return;
						} else {
							TV.setHdmis(Hdmis);

						}
						break;
					case "Update_fecha_final":
						fechafinal = Datos_electronic.pidefecha();
						TV.setF_final_garantia(fechafinal);
						break;
					}// end case
				} // end else2
			} // end else1

		} // end tv
	}
}