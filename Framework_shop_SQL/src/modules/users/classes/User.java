package modules.users.classes;

import classes.Fecha;

public abstract class User {
	private String name;
	private String surname;
	private String phone;
	private String DNI;
	private String email;
	Fecha birthday;
	private int age;

	// Constructor
	public User(String name, String surname, String phone, String DNI, String email, Fecha birthday) {
		super();
		this.name = name;
		this.phone = phone;
		this.DNI = DNI;
		this.email = email;
		this.birthday = birthday;
		this.setAge(calculateAge());
	}

	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Fecha getBirthday() {
		return birthday;
	}

	public void setBirthday(Fecha birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int calculateAge() {
		int x = 0;
		x = this.getBirthday().RestaAnos();
		return x;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
