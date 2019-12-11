package modules.users.classes;

import classes.Fecha;

public class Admin extends User {
	private String username;
	private String password;

	public Admin(String name, String surname, String phone, String DNI, String email, Fecha birthday, String username,
			String password) {
		super(name, surname, phone, DNI, email, birthday);
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [getName()=" + getName() + ", getPhone()=" + getPhone() + ", getDNI()=" + getDNI()
				+ ", getEmail()=" + getEmail() + ", getBirthday()=" + birthday.ToString() + ", getAge()=" + getAge()
				+ ", username=" + username + ", password=" + password + "]";
	}

}
