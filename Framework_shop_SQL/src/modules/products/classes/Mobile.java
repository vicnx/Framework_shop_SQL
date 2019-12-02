package modules.products.classes;

import classes.Fecha;

public class Mobile extends Electronic {
	private int width;
	String batery;
	String capacity;
	private String ram;

	public Mobile(String name, String price, String system, String brand, String rating, int time_garantia,
			Fecha f_inicio_garantia, Fecha f_final_garantia, int width, String ram, String capacity, String batery) {
		super(name, price, system, brand, rating, time_garantia, f_inicio_garantia, f_final_garantia);
		this.width = width;
		this.ram = ram;
		this.capacity = capacity;
		this.batery = batery;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getBatery() {
		return batery;
	}

	public void setBatery(String batery) {
		this.batery = batery;
	}

	@Override
	public String toString() {
		return "Name=" + getName() + "\nBrand=" + getBrand() + "\nPrice=" + getPrice() + "\nSystem=" + getSystem()
				+ "\nTime_garantia=" + getTime_garantia() + "\nF_inicio_garantia=" + getF_inicio_garantia()
				+ "\nF_final_garantia=" + f_final_garantia.ToString() + "\nDias restantes de garantia= " + getgarantia()
				+ "\nRating=" + getRating() + "\nram=" + ram + "\ncapacity=" + capacity + "\nbatery=" + batery
				+ "\nwidth=" + width;
	}

}
