package functions;

import javax.swing.JOptionPane;

public class Functions {
///////VALIDAR NUM (PUEDEN SER NEGATIVOS)
	public static Integer validnum(String ventana, String titulo) {
		int num = 0;
		String cad = "";
		boolean interruptor = true;

		do {
			try {
				if (ventana == null)
					ventana = "Number";// Si la variable VENTANA esta en null ingresa esto.
				if (titulo == null)
					titulo = "Write a Number";// Si la variable TITULO esta en null ingresa esto.
				cad = JOptionPane.showInputDialog(null, ventana, titulo, JOptionPane.QUESTION_MESSAGE);
				if (cad == null) {
					return null;// si se cierra la ventana de pedir numero no se cierra la ventana entera
				} else {
					num = Integer.parseInt(cad);
					interruptor = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "You have not entered an integer", "Error",
						JOptionPane.ERROR_MESSAGE);
				interruptor = false;
			}
		} while (interruptor == false);
		return num;
	}

///////FIN VALIDAR NUMERO
//// Validar double
	public static String validdouble(String ventana, String titulo) {
		@SuppressWarnings("unused")
		double num = 0;
		String cad = "";
		String caddouble = "";
		boolean interruptor = true;

		do {
			try {
				if (ventana == null)
					ventana = "Number";// Si la variable VENTANA esta en null ingresa esto.
				if (titulo == null)
					titulo = "Write a Number";// Si la variable TITULO esta en null ingresa esto.
				cad = JOptionPane.showInputDialog(null, ventana, titulo, JOptionPane.QUESTION_MESSAGE);
				if (cad == null) {
					return null;// si se cierra la ventana de pedir numero no se cierra la ventana entera
				} else {
					num = Double.parseDouble(cad);
					caddouble = cad;
					interruptor = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "You have not entered an double", "Error",
						JOptionPane.ERROR_MESSAGE);
				interruptor = false;
			}
		} while (interruptor == false);
		return caddouble;
	}// Al usar esta funcion devuelve String(para poder retornar NULL), hay que
		// transformarlo en double con:
		// x=Double.parseDouble(cad)

	//// FIN VALIDAR DOUBLE
///Validar String
	public static String validString(String mensaje, String titulo) {
		String cad = "";
		boolean correcto = true;
		if (mensaje == null) {
			mensaje = "Give me a String";
		}
		if (titulo == null) {
			titulo = "Valid String";
		}
		do {
			try {
				cad = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
				correcto = true;
				if (cad == null) {
					JOptionPane.showMessageDialog(null, "You don't put a valid string", "Error",
							JOptionPane.ERROR_MESSAGE);
					correcto = false;
				}
				if (cad.equals("")) {
					JOptionPane.showMessageDialog(null, "Error of entered data", "Error", JOptionPane.ERROR_MESSAGE);
					correcto = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "You don't put a string value", "Error", JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);
		return cad;

	}

	//// FIN VALIDAR STRING
/////////////////////VALIDAR LETRA
	public static char validletra(String titulo, String ventana) {
		char letra = 0;
		String cad = "";
		boolean correcto = true;

		do {
			try {
				if (ventana == null)
					ventana = "Char";// Si la variable VENTANA esta en null ingresa esto.
				if (titulo == null)
					titulo = "Write only one char";// Si la variable TITULO esta en null ingresa esto.
				cad = JOptionPane.showInputDialog(null, titulo, ventana, JOptionPane.QUESTION_MESSAGE);
				if (cad == null) {
					JOptionPane.showMessageDialog(null, "Leaveing the app...", "Exit", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);// al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la
									// ejecución
				} else if (cad.length() != 1) {// Comprueba si has introducido SOLO un caracter. Si has introducido más
												// de uno salta error.
					JOptionPane.showMessageDialog(null, "ERROR!\nOnly put one char", "Error",
							JOptionPane.ERROR_MESSAGE);
					correcto = false;
				} else {
					letra = cad.charAt(0); // coje la primera letra o numero o simbolo(o la unica)
					correcto = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "You have not entered a valid char", "Error",
						JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);
		return letra;
	}

///////FIN VALIDAR LETRA
////// ENTERO POSITIVO
	public static Integer validpositive(String ventana, String mensaje) {
		int num = 0;
		String cad = "";
		boolean interruptor = true;

		do {
			try {
				if (ventana == null)
					ventana = "Positive Number";// Si la variable VENTANA esta en null ingresa esto.
				if (mensaje == null)
					mensaje = "Write a  Positive Number";// Si la variable TITULO esta en null ingresa esto.
				cad = JOptionPane.showInputDialog(null, mensaje, ventana, JOptionPane.QUESTION_MESSAGE);
				if (cad == null) {
					return null;// ESTO ES PARA SI SE CIERRA LA VENTANA DE PEDIR NUMERO NO SE CIERRE EL PROGRAMA
								// ENTERO
				} else {
					num = Integer.parseInt(cad);
					if (num > 0) {
						interruptor = true;
					} else {
						Functions.mensajeerror(num + "Not is a positive number", "Error");
						interruptor = false;
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "You have not entered an positive integer", "Error",
						JOptionPane.ERROR_MESSAGE);
				interruptor = false;
			}
		} while (interruptor == false);
		return num;
	}

//////FIN ENTERO POSITIVO
//////ES NUMERO?
	public static boolean isnumeric(String num) {
		boolean result = false;
		try {
			Integer.parseInt(num);
			result = true;
		} catch (Exception e) {
			result = false;
		}
		return result;

	}

///// FIN ES NUMERO?
//// ELIMINAR ULTIMO CARACTER
	public static String remove_last_char(String cad) {
		if (cad != "") {
			cad = cad.substring(0, cad.length() - 1);
		} else {
			cad = "Nothing";
		}
		return cad;
	}

//////FIN  ELIMINAR ULTIMO CARACTER
///// MENU
	public static int menubuttons(String[] option, String mensaje, String ventana, int posoption) {
		int optionnum = 0;
		optionnum = JOptionPane.showOptionDialog(null, mensaje, ventana, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, option, option[posoption]);
		return optionnum;
	}

//// FIN MEN
//// COMBObox
	public static String menucombo(Object[] options, String ventana, String mensaje) {
		Object option = JOptionPane.showInputDialog(null, mensaje, ventana, JOptionPane.QUESTION_MESSAGE, null, options,
				options[0]);
		if (option == null) {
			return null;
		} else {
			return option.toString();

		}
	}
//FIN Combobox
/////////////////////////////////////////////////////////
///////////////////////MENSAJES/////////////////////////
///////////////////////////////////////////////////////
/// Mensaje Inf

	public static void mensajeinf(String mensaje, String ventana) {
		if (mensaje == null) {
			mensaje = "you have not entered any message";
		}
		if (ventana == null) {
			ventana = "Message";
		}
		JOptionPane.showMessageDialog(null, mensaje, ventana, JOptionPane.INFORMATION_MESSAGE);
	}

/// End mensaje inf
/// Mensaje error

	public static void mensajeerror(String mensaje, String ventana) {
		if (mensaje == null) {
			mensaje = "you have not entered any message";
		}
		if (ventana == null) {
			ventana = "Error";
		}
		JOptionPane.showMessageDialog(null, mensaje, ventana, JOptionPane.ERROR_MESSAGE);
	}

/// Fin mensaje error
}