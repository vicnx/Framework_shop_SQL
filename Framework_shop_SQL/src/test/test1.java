package test;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import functions.Functions;
import modules.products.classes.Electronic;
import modules.products.classes.Mobile;
import modules.products.classes.Singleton;
import modules.products.classes.Tablet;
import modules.products.classes.tv;

public class test1 {

	public static void main(int tipo) {
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

	}// endfunction
}
