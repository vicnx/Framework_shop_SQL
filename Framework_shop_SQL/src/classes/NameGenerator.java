package classes;

import java.util.Random;

public class NameGenerator {
	private static String[] Nombre = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry",
			"Bartolo", "Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
			"Caritina", "Carlota", "Baltazar" };
	private static String[] Apellido = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga",
			"Carillo", "Carion", "Castiyo", "Castorena", "Castro", "Grande", "Grangenal", "Grano", "Grasia", "Griego",
			"Grigalva" };
	private static String[] Principio = { "Xiaomi", "Samsung", "Honor", "IPad", "huawei", "Realme", "Cubot", "Oppo",
			"Xtrem", "Windows" };
	private static String[] Final = { " air", " mi", " plus", " note", " pad", " tab", " M", "Z", " A", " B", " C",
			" D", " F", " G", " H", " I", " J", " Version", " P", " R" };
	private static String[] letras = { "X", "V", "Y", "Z", "J" };
	private static Random r1 = new Random(900);
	private static Random rand = new Random();

	public static String generateName(int tipo) {
		int number = (int) (Math.random() * (1 - 10 + 1) + 10);
		String cad = "";
		if (tipo == 0) {// electronic
			cad = Principio[rand.nextInt(Principio.length)] + Final[rand.nextInt(Final.length)] + number;
		}
		if (tipo == 1) { // nombrepersonas
			cad = Nombre[rand.nextInt(Nombre.length)];
		}
		if (tipo == 2) {
			cad = Apellido[rand.nextInt(Apellido.length)];
		}
		if (tipo == 3) {// letra DNI
			cad = letras[rand.nextInt(letras.length)];
		}
		return cad;
	}

}
