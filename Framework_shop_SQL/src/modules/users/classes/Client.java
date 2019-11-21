package modules.users.classes;

import classes.Fecha;

public class Client extends User {
	private Fecha registro;
	private String idclient;

	public Client(String name, String surname, String phone, String DNI, String email, Fecha birthday, Fecha registro,
			String idclient) {
		super(name, surname, phone, DNI, email, birthday);
		this.registro = registro;
		this.idclient = idclient;
	}

	public Fecha getRegistro() {
		return registro;
	}

	public void setRegistro(Fecha registro) {
		this.registro = registro;
	}

	public String getIdclient() {
		return idclient;
	}

	public void setIdclient(String idclient) {
		this.idclient = idclient;
	}

	@Override
	public String toString() {
		return "Client [getName()=" + getName() + ", getPhone()=" + getPhone() + ", getDNI()=" + getDNI()
				+ ", getEmail()=" + getEmail() + ", getBirthday()=" + birthday.ToString() + ", getAge()=" + getAge()
				+ ", registro=" + registro + ", idclient=" + idclient + "]";
	};

}
