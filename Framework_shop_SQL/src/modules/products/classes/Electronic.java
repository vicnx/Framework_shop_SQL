package modules.products.classes;

import classes.Fecha;

public abstract class Electronic {
	String price;
	// Attributes
	private int time_garantia;
	private String rating;
	private String system, brand, name;
	Fecha f_inicio_garantia;
	Fecha f_final_garantia;
	long garantia;

	// Constructor
	public Electronic(String name, String price, String system, String brand, String rating, int time_garantia,
			Fecha f_inicio_garantia, Fecha f_final_garantia) {
		this.name = name;
		this.price = price;
		this.system = system;
		this.brand = brand;
		this.rating = rating;
		this.time_garantia = time_garantia;
		this.f_inicio_garantia = f_inicio_garantia;
		this.f_final_garantia = f_final_garantia;
		this.setgarantia(CalculaGarantia());

	}

	// Getters and Setters

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime_garantia() {
		return time_garantia;
	}

	public void setTime_garantia(int time_garantia) {
		this.time_garantia = time_garantia;
	}

	public Fecha getF_inicio_garantia() {
		return f_inicio_garantia;
	}

	public void setF_inicio_garantia(Fecha f_inicio_gartantia) {
		this.f_inicio_garantia = f_inicio_gartantia;
	}

	public Fecha getF_final_garantia() {
		return f_final_garantia;
	}

	public void setF_final_garantia(Fecha f_final_garantia) {
		this.f_final_garantia = f_final_garantia;
	}

	public long CalculaGarantia() {
		return garantia = f_final_garantia.diferencia();
	}

	public void setgarantia(long garantia) {
		this.garantia = this.CalculaGarantia();
	}

	public long getgarantia() {
		return garantia = CalculaGarantia();
	}

	public abstract String toString();

}
