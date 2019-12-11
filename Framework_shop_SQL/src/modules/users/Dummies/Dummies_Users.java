package modules.users.Dummies;

import java.sql.Connection;
import java.sql.PreparedStatement;

import classes.DataConnection;
import classes.Fecha;
import modules.users.classes.Client;

public class Dummies_Users {

	public static void main(String[] args) {
		Integer dummies = 0;
		dummies = functions.Functions.validnum("How much CLIENT dummies?", "Dummies Client");
		if (dummies == null) {
			return;
		}
		for (int i = 1; i <= dummies; i++) {
			String getName = classes.NameGenerator.generateName(1);
			String getSurname = classes.NameGenerator.generateName(2);
			int intphone = (int) (Math.random() * (600000000 - 789999999 + 1) + 789999999);
			String getPhone = Integer.toString(intphone);
			int numDNI = (int) (Math.random() * (11111111 - 88888888 + 1) + 88888888);
			String letrasDNI = classes.NameGenerator.generateName(3);
			String getDNI = numDNI + letrasDNI;
			String getEmail = getName + "@email.com";
			Fecha birthday = new Fecha("10/04/2000");
			Fecha registro = new Fecha();
			String getidclient = (int) (Math.random() * (11111111 - 9999999) + 9999999)
					+ classes.NameGenerator.generateName(3) + classes.NameGenerator.generateName(3)
					+ classes.NameGenerator.generateName(3);
			Client client = new Client(getName, getSurname, getPhone, getDNI, getEmail, birthday, registro,
					getidclient);
			try {
				Connection conn = DataConnection.getConnection();
				PreparedStatement posted = conn.prepareStatement(
						"INSERT INTO Client (name,surname,phone,DNI,email,birthday,registro,idclient,age) VALUES ('"
								+ getName + "','" + getSurname + "','" + getPhone + "','" + getDNI + "','" + getEmail
								+ "','" + birthday.ToString() + "','" + registro.ToString() + "','" + getidclient
								+ "','" + client.getAge() + "')");
				posted.executeUpdate();
			} catch (Exception e) {
				System.out.println("idclient dubplicado (IGNORAR)");
			}
		}

	}

}
