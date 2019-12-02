package modules.products.functions;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import classes.Fecha;
import functions.Functions;
import functions.validate;
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
					int cont = 0;
					int eliminate = 0;
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
										eliminate = JOptionPane.showConfirmDialog(null, "Seguro de eliminar?");
										if (eliminate == 0) {
											for (int x = 0; x < Singleton.electronics.size(); x++) {
												Electronic Tablet = Singleton.electronics.get(x);
												cont++;
												if (Tablet instanceof Tablet) {
													String name = ((Tablet) Tablet).getName();
													String name2 = ((Tablet) Electronic2).getName();
													if (name.equals(name2)) {
														System.out.println(Singleton.electronics.size());
														System.out.println("pso:" + cont);
														Singleton.electronics.remove(cont - 1);
														modelo.setRowCount(0);
														for (int j = 0; j < Singleton.electronics.size(); j++) {
															Electronic Electronic = Singleton.electronics.get(j);
															if (Electronic instanceof Tablet) {
																modelo.addRow(new Object[] { Electronic.getName(),
																		Electronic.getPrice(),
																		Electronic.getRating() });
															}
														}

													}
												}
											}
										}
									} // end if dato==
								}

							}
						}
						Functions.mensajeinf("Eliminado con exito", "Delete Tablet");
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
							int eliminate = 0;
							int cont = 0;
							for (int i = 0; i < Singleton.electronics.size(); i++) {
								Electronic Electronic2 = Singleton.electronics.get(i);
								if (Electronic2 instanceof Mobile) {
									if (dato == Electronic2.getName()) {
										eliminate = JOptionPane.showConfirmDialog(null, "Seguro de eliminar?");
										if (eliminate == 0) {
											for (int x = 0; x < Singleton.electronics.size(); x++) {
												Electronic Mobile = Singleton.electronics.get(x);
												cont++;
												if (Mobile instanceof Mobile) {
													String name = ((Mobile) Mobile).getName();
													String name2 = ((Mobile) Electronic2).getName();
													if (name.equals(name2)) {
														System.out.println(Singleton.electronics.size());
														System.out.println("pso:" + cont);
														Singleton.electronics.remove(cont - 1);
														modelo.setRowCount(0);
														for (int j = 0; j < Singleton.electronics.size(); j++) {
															Electronic Electronic = Singleton.electronics.get(j);
															if (Electronic instanceof Mobile) {
																modelo.addRow(new Object[] { Electronic.getName(),
																		Electronic.getPrice(),
																		Electronic.getRating() });
															}
														}

													}
												}
											}
										}
									} // end if dato==
								}

							}
						}
						Functions.mensajeinf("Eliminado Correcteamente", "Remove tv");
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
										int eliminate = 0, cont = 0;
										eliminate = JOptionPane.showConfirmDialog(null, "Seguro de eliminar?");
										if (eliminate == 0) {
											for (int x = 0; x < Singleton.electronics.size(); x++) {
												Electronic tv = Singleton.electronics.get(x);
												cont++;
												if (tv instanceof tv) {
													String name = ((tv) tv).getName();
													String name2 = ((tv) Electronic2).getName();
													if (name.equals(name2)) {
														System.out.println(Singleton.electronics.size());
														System.out.println("pso:" + cont);
														Singleton.electronics.remove(cont - 1);
														modelo.setRowCount(0);
														for (int j = 0; j < Singleton.electronics.size(); j++) {
															Electronic Electronic = Singleton.electronics.get(j);
															if (Electronic instanceof tv) {
																modelo.addRow(new Object[] { Electronic.getName(),
																		Electronic.getPrice(),
																		Electronic.getRating() });
															}
														}

													}
												}
											}
										}
									} // end if dato==
								}

							}
						}
						Functions.mensajeinf("Eliminado correctamente", "Remove TV");
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
	}

	public static void updateElectronic(int tipo) {
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
										// Declaramos las variables necesarias.
										String getName = "", getRam = "", getPrice = "", getSystem = "", getBrand = "",
												getRating = "", getTotalsize = "", getCapacity = "", getBatery = "",
												getSim = "", caderrors = "", getFfinal;
										boolean error = false;
										Fecha fechafinal = null;
										String optionmenu[] = { "Update", "Return" };
										String tiporam[] = { "1GB", "2GB", "3GB", "4GB", "6GB", "8GB" };
										String tiposystem[] = { "IOS", "Android_5.0", "Android_6.0", "Android_7.0",
												"Android_8.0", "Android_9.0", "Windows" };
										String tiposbrand[] = { "Samsung", "Xiaomi", "Apple", "Windows", "Huawei" };
										String tipocapacity[] = { "32GB", "64GB", "128GB", "256GB", "500GB", "1000GB" };
										String tiposim[] = { "Yes", "No" };
										String tiposrating[] = { "☆", "☆☆", "☆☆☆", "☆☆☆☆", "☆☆☆☆☆" };
										Integer option = 0;
										JTextField name = new JTextField();
										JTextField price = new JTextField();
										JTextField total_size = new JTextField();
										JTextField batery = new JTextField();
										JTextField ffinal = new JTextField();
										JComboBox<String> ram = new JComboBox<>(tiporam);
										JComboBox<String> system = new JComboBox<>(tiposystem);
										JComboBox<String> brand = new JComboBox<>(tiposbrand);
										JComboBox<String> capacity = new JComboBox<>(tipocapacity);
										JComboBox<String> sim = new JComboBox<>(tiposim);
										JComboBox<String> rating = new JComboBox<>(tiposrating);
										// Creamos unos bordes para apariencia
										Border bordererror = BorderFactory.createLineBorder(Color.RED, 1);
										Border borderdefault = new JTextField().getBorder();
										// Creamos jun Array List de tipo objeto donde guardaremos el resultado final
										ArrayList<Object> resultTablet = new ArrayList<Object>();
										// Creamos el panel en un objeto para que aparezca en una ventan.
										Object[] menu = { "Update Tablet\n\n", "Name", name, "Price", price, "System",
												system, "Brand", brand, "Ram", ram, "Total Size", total_size,
												"Capacity", capacity, "Batery", batery, "Sim", sim, "Rating", rating,
												"Fecha Final Garantia", ffinal };
										do {
											name.setText(Electronic2.getName());
											price.setText(Electronic2.getPrice());
											total_size.setText("20.0");
											batery.setText(((Tablet) Electronic2).getBatery());
											ffinal.setText(Electronic2.getF_final_garantia().ToString());

											caderrors = "";
											error = false;
											option = JOptionPane.showInternalOptionDialog(null, menu, "Tablet", 0,
													JOptionPane.QUESTION_MESSAGE, null, optionmenu, optionmenu[0]);
											if (option == -1 || option == 1) {
												return;
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
												if (validate.validaprecio(getPrice) == false) {// Si no sige el patron
																								// de precio, salta el
																								// error
													price.setBorder(bordererror);
													caderrors = caderrors
															+ "- Set the correct price\n (Max 4 digits)\n";
													error = true;
												}
											}

											// Combo System
											Object objsystem = system.getSelectedItem(); // Guardamos el item
																							// seleccionado en un Object
											getSystem = String.valueOf(objsystem); // Lo convertimos en String
											// Combo Brand
											Object objbrand = brand.getSelectedItem();
											getBrand = String.valueOf(objbrand);
											// Combo Ram
											Object objram = ram.getSelectedItem();
											getRam = String.valueOf(objram);
											// Input Total_Size
											total_size.setBorder(borderdefault);
											getTotalsize = total_size.getText();
											if (getTotalsize.isEmpty()) {
												total_size.setBorder(bordererror);
												caderrors = caderrors + "- total_size empty\n";
												error = true;
											} else {
												if (validate.validdouble(getTotalsize) == false) {
													total_size.setBorder(bordererror);
													caderrors = caderrors + "- Set the correct size\n(ex: 5.0,)\n";
													error = true;
												}
											}
											// Combo capacity
											Object objcapacity = capacity.getSelectedItem();
											getCapacity = String.valueOf(objcapacity);
											// Input Bateria
											batery.setBorder(borderdefault);
											getBatery = batery.getText();
											if (getBatery.isEmpty()) {
												batery.setBorder(bordererror);
												caderrors = caderrors + "-Batery empty\n";
												error = true;
											} else {
												if (validate.validbatery(getBatery) == false) {
													batery.setBorder(bordererror);
													caderrors = caderrors + "- Set the correct batery\n(ex: 3600,)\n";
													error = true;
												}
											}

											// COmbo Sim
											Object objsim = sim.getSelectedItem();
											getSim = String.valueOf(objsim);
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
														if ((fechafinal.comparaFechas() == 1)
																|| (fechafinal.comparaFechas() == 3)) {
															caderrors = caderrors + "- Ser a date after today\n";
															ffinal.setBorder(bordererror);
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
										tabla.setValueAt(getName, row, 0);
										tabla.setValueAt(getPrice, row, 1);
										tabla.setValueAt(getRating, row, 2);
										Electronic2.setBrand(getBrand);
										Electronic2.setF_final_garantia(fechafinal);
										Electronic2.setName(getName);
										Electronic2.setPrice(getPrice);
										Electronic2.setRating(getRating);
										Electronic2.setSystem(getSystem);
										((Tablet) Electronic2).setBatery(getBatery);
										((Tablet) Electronic2).setCapacity(getCapacity);
										((Tablet) Electronic2).setRam(getRam);
										((Tablet) Electronic2).setSim(getSim);
										((Tablet) Electronic2).setTotal_size(getTotalsize);
									} // end if dato==
								} // endifinstanceof

							}
						}
						Functions.mensajeinf("Modificado con exito", "Update Tablet");
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
										// Declaramos las variables necesarias.
										String getName = "", getRam = "", getPrice = "", getSystem = "", getBrand = "",
												getRating = "", getCapacity = "", getBatery = "", caderrors = "",
												getFfinal = "";
										Fecha fechafinal = null;
										boolean error = false;
										String optionmenu[] = { "Update", "Return" };
										String tiporam[] = { "1GB", "2GB", "3GB", "4GB", "6GB", "8GB" };
										String tiposystem[] = { "IOS", "Android_5.0", "Android_6.0", "Android_7.0",
												"Android_8.0", "Android_9.0", "Windows" };
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
										Object[] menu = { "Update Mobile\n\n", "Name", name, "Price", price, "System",
												system, "Brand", brand, "Ram", ram, "Capacity", capacity, "Batery",
												batery, "Rating", rating, "Fecha Final Garantia", ffinal };
										do {
											name.setText(Electronic2.getName());
											price.setText(Electronic2.getPrice());
											batery.setText(((Mobile) Electronic2).getBatery());
											ffinal.setText(Electronic2.getF_final_garantia().ToString());
											caderrors = "";
											error = false;
											option = JOptionPane.showInternalOptionDialog(null, menu, "Mobile", 0,
													JOptionPane.QUESTION_MESSAGE, null, optionmenu, optionmenu[0]);
											if (option == -1 || option == 1) {
												return;
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
												if (validate.validaprecio(getPrice) == false) {// Si no sige el patron
																								// de precio, salta el
																								// error
													price.setBorder(bordererror);
													caderrors = caderrors
															+ "- Set the correct price\n (Max 4 digits)\n";
													error = true;
												}
											}
											// Combo System
											Object objsystem = system.getSelectedItem(); // Guardamos el item
																							// seleccionado en un Object
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
														if ((fechafinal.comparaFechas() == 1)
																|| (fechafinal.comparaFechas() == 3)) {
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
										tabla.setValueAt(getName, row, 0);
										tabla.setValueAt(getPrice, row, 1);
										tabla.setValueAt(getRating, row, 2);
										Electronic2.setBrand(getBrand);
										Electronic2.setF_final_garantia(fechafinal);
										Electronic2.setName(getName);
										Electronic2.setPrice(getPrice);
										Electronic2.setRating(getRating);
										Electronic2.setSystem(getSystem);
										((Mobile) Electronic2).setBatery(getBatery);
										((Mobile) Electronic2).setCapacity(getCapacity);
										((Mobile) Electronic2).setRam(getRam);
									} // end if dato==
								}

							}
						}
						Functions.mensajeinf("Modificado con exito", "Update Tablet");
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
										// Declaramos las variables necesarias.
										String getName = "", getPrice = "", getSystem = "", getBrand = "",
												getRating = "", getHdmis = "", getSmartTv = "", caderrors = "",
												getFfinal;
										boolean error = false;
										Fecha fechafinal = null;
										String optionmenu[] = { "Update", "Return" };
										String tiposystem[] = { "None", "Android_5.0", "Android_6.0", "Android_7.0",
												"Android_8.0", "Android_9.0", };
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
										Object[] menu = { "Update a TV\n\n", "Name", name, "Price", price, "System",
												system, "Brand", brand, "HDMIS", hdmis, "SmartTV", smarttv, "Rating",
												rating, "Fecha Final Garantia", ffinal };
										do {
											name.setText(Electronic2.getName());
											price.setText(Electronic2.getPrice());
											ffinal.setText(Electronic2.getF_final_garantia().ToString());
											caderrors = "";
											error = false;
											option = JOptionPane.showInternalOptionDialog(null, menu, "TV", 0,
													JOptionPane.QUESTION_MESSAGE, null, optionmenu, optionmenu[0]);
											if (option == -1 || option == 1) {
												return;
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
												if (validate.validaprecio(getPrice) == false) {// Si no sige el patron
																								// de precio, salta el
																								// error
													price.setBorder(bordererror);
													caderrors = caderrors
															+ "- Set the correct price\n (Max 4 digits)\n";
													error = true;
												}
											}
											// Combo System
											Object objsystem = system.getSelectedItem(); // Guardamos el item
																							// seleccionado en un Object
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
														if ((fechafinal.comparaFechas() == 1)
																|| (fechafinal.comparaFechas() == 3)) {
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
										tabla.setValueAt(getName, row, 0);
										tabla.setValueAt(getPrice, row, 1);
										tabla.setValueAt(getRating, row, 2);
										Electronic2.setBrand(getBrand);
										Electronic2.setF_final_garantia(fechafinal);
										Electronic2.setName(getName);
										Electronic2.setPrice(getPrice);
										Electronic2.setRating(getRating);
										Electronic2.setSystem(getSystem);
										((tv) Electronic2).setHdmis(getHdmis);
										((tv) Electronic2).setSmarttv(getSmartTv);
									} // end if dato==
								}

							}
						}
						Functions.mensajeinf("Modificado con exito", "Update Tablet");
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
	}
}