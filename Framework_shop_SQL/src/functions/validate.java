package functions;

public class validate {
	private static final String plantilla_fecha = "\\d{1,2}/\\d{1,2}/\\d{4}";
	private static final String plantilla_precio = "^[0-9]{1,4}$";
	private static final String plantilla_double = "\\d{1,2}.\\d{1,3}";
	private static final String plantilla_bateria = "\\d{1,5}";
	private static final String plantilla_phone = "^[0-9]{9}$";
	private static final String plantilla_email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String plantilla_name = "^[a-zA-Z\\s]*$";
	private static final String plantilla_surname = "^[a-zA-Z\\s]*$";
	private static final String plantilla_DNI = "^[0-9]{8}[A-Z]$";
	private static final String plantilla_idclient = "^[0-9]{8}[A-Z]{3}$";
	private static final String plantilla_username = "^[a-zA-Z0-9]{4,}$";
	private static final String plantilla_password = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

////////idclient
	public static boolean validaidclient(String idclient) {
		if (idclient == null) {
			return false;
		}
		return idclient.matches(plantilla_idclient);
	}

	//////// Password
	public static boolean validapass(String pass) {
		if (pass == null) {
			return false;
		}
		return pass.matches(plantilla_password);
	}

////////Username
	public static boolean validausername(String user) {
		if (user == null) {
			return false;
		}
		return user.matches(plantilla_username);
	}

////////DNI
	public static boolean validadni(String dni) {
		if (dni == null) {
			return false;
		}
		return dni.matches(plantilla_DNI);
	}

////////SurName
	public static boolean validasurname(String surname) {
		if (surname == null) {
			return false;
		}
		return surname.matches(plantilla_surname);
	}

////////Name
	public static boolean validaname(String name) {
		if (name == null) {
			return false;
		}
		return name.matches(plantilla_name);
	}

////////Email
	public static boolean validaemail(String email) {
		if (email == null) {
			return false;
		}
		return email.matches(plantilla_email);
	}

////////Phone
	public static boolean validaphone(String phone) {
		if (phone == null) {
			return false;
		}
		return phone.matches(plantilla_phone);
	}

////////FECHA
	public static boolean validafecha(String fecha) {
		if (fecha == null) {
			return false;
		}
		return fecha.matches(plantilla_fecha);

	}

//////////DINERO
	public static boolean validaprecio(String dinero) {
		if (dinero == null) {
			return false;
		}
		return dinero.matches(plantilla_precio);
	}

////////Double
	public static boolean validdouble(String vdouble) {
		if (vdouble == null) {
			return false;
		}
		return vdouble.matches(plantilla_double);
	}

////////Bateria
	public static boolean validbatery(String batery) {
		if (batery == null) {
			return false;
		}
		return batery.matches(plantilla_bateria);
	}
}
