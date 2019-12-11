package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {
// declaramos variables
	private String fecha;
	private int dia;
	private int mes;
	private int ano;

// creamos un nuevo formato
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

//Dividimos la fecha en dd/mm/yyyy y guardamos la originall
	public Fecha(String fecha) {
		String SplitArray[] = null;
		SplitArray = fecha.split("/");
		this.fecha = fecha;
		this.dia = Integer.parseInt(SplitArray[0]);
		this.mes = Integer.parseInt(SplitArray[1]);
		this.ano = Integer.parseInt(SplitArray[2]);
	}

	// Convertimos la String a Calendar.
	public Calendar stringToCalendar(String fecha) {
		Date fechaDate = new Date();
		Calendar fechaCalendar = new GregorianCalendar();
		try {
			fechaDate = formato.parse(fecha);
			fechaCalendar.setTime(fechaDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaCalendar;
	}

	// Convertimos de Calendar a String
	public String ToString() {
		String f = "";
		try {
			f = fecha.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	// Resta fecha anos sistema con fecha
	public int RestaAnos() {
		int diferencia, ano, anosistema;
		Calendar cal = new GregorianCalendar();// creamos un nuevo calendar para guardar la fecha
		cal = (stringToCalendar(fecha)); // convertimos la fecha que es string a Calendar para poder utilizarla
		ano = cal.get(Calendar.YEAR);// guardamos en una variable el ano de la fecha
		anosistema = this.anoactual();// guardamos en otra variable el ano actual (con una funcion)
		diferencia = anosistema - ano;// restamos el ano y el ano del sistema
		return diferencia;// retornamos la diferencia en tipo INT
	}

//conseguir año actual
	public int anoactual() {
		Calendar fechaactual = new GregorianCalendar();// creamos un calendar nuevo
		int anyo = fechaactual.get(Calendar.YEAR);// cojemos la fecha creada y de ella cojemos el ano.
		return anyo;// retornamos el ano
	}

	public Fecha fechaactual() {
		String fs = "";// declaramos una String para convertirla a String y seguidamente
		Calendar fechaactual = new GregorianCalendar();// creamos un nuevo calendar
		fs = fechaactual.toString();// convertimos Calendar to string
		Fecha f = new Fecha(fs);// creamos un objeto de tipo fecha con la string
		return f;// retornamos la fecha

	}

	public Fecha() {// esto coje la fecha del sistema
		Calendar f = new GregorianCalendar();// creamos un calendar
		this.ano = f.get(Calendar.YEAR);// guardamos el ano del calendar
		this.dia = f.get(Calendar.DAY_OF_MONTH);// guardamos el dia
		this.mes = f.get(Calendar.MONTH + 1);// guardamos el mes y le sumamos 1
		this.fecha = formato.format(f.getTime());// guardamos la fecha entera con el formato creado dd/MM/yyyy

	}

	public int comparaFechas() {
		Calendar c1 = this.stringToCalendar(fecha);// creamos un calendar con la fecha que se le indica
		Calendar c2 = Calendar.getInstance();// creamos otro calendar con la fecha del sistema
		if (c1.before(c2)) {// si la fecha indicada es anterior que la fecha del sistema retorna 1
			return 1;
		} else if (c1.after(c2)) {// si la fehca indicada es posterior a la del sistema retorna 2
			return 2;
		} else {// si son iguales retorna 3
			return 3;
		}
	}

	public boolean comparaNacimiento() {
		Calendar c1 = this.stringToCalendar(fecha);// creamos un calendar con la fecha que se le indica
		Calendar c2 = new GregorianCalendar(2008, 01, 01);
		if (c1.after(c2)) {
			return false;
		} else {
			return true;
		}
	}

	public long diferencia() {
		int diaz;
		// int bisiestos = 0, diasbi;

		GregorianCalendar fecha1 = new GregorianCalendar(this.ano, this.mes - 1, this.dia + 1);// se le suma uno porque
																								// al pasarlo a ms da un
																								// dia menos siempre
																								// (mejor que el cliente
																								// tenga 1 dia mas)
		GregorianCalendar fecha2;

		fecha2 = CaltoGregCal(Calendar.getInstance());

		long ms = fecha1.getTimeInMillis() - fecha2.getTimeInMillis();// diferencia
		// en milisegundos

		diaz = (int) ((ms) / (86400000));// Convertimos los milisegundos en dias
//		for (int i = fecha2.get(Calendar.YEAR) + 1; i <= fecha1.get(Calendar.YEAR); i++) {
//			if (fecha1.isLeapYear(i)) {
//				bisiestos++;
//			}
//		}
//		diasbi = bisiestos * 366;
//		diaz = diaz - diasbi;

		return diaz;
	}

	public static GregorianCalendar CaltoGregCal(Calendar fecha) {
		GregorianCalendar f = new GregorianCalendar();

		f.set(fecha.get(Calendar.YEAR), fecha.get(Calendar.MONTH), fecha.get(Calendar.DATE));

		return f;
	}

	public boolean vfecha() {
		boolean r = true;
		GregorianCalendar f = new GregorianCalendar();
		int dias_mes[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((this.mes < 1) || (this.mes > 12)) {
			r = false;
		}
		if (r == true) {
			f.set(this.ano, this.mes, this.dia);
			if (f.isLeapYear(this.ano)) {
				dias_mes[2] = 29;
			}
			if ((this.dia < 1) || (this.dia > dias_mes[this.mes])) {
				r = false;
			}
		}
		return r;
	}

}
