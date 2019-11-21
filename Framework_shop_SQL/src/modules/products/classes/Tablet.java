package modules.products.classes;

import classes.Fecha;

public class Tablet extends Electronic {
	private String total_size;
	private int width;
	String sim;
	String batery;
	String capacity;
	private String ram;

	public Tablet(String name, String price, String system, String brand, String rating, int time_garantia,
			Fecha f_inicio_garantia, Fecha f_final_garantia, String total_size, String sim, int width, String ram,
			String capacity, String batery) {
		super(name, price, system, brand, rating, time_garantia, f_inicio_garantia, f_final_garantia);
		this.total_size = total_size;
		this.sim = sim;
		this.width = width;
		this.ram = ram;
		this.capacity = capacity;
		this.batery = batery;
	}

	public String getTotal_size() {
		return total_size;
	}

	public void setTotal_size(String total_size) {
		this.total_size = total_size;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
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
		return "Tablet [" + "name=" + getName() + ", brand=" + getBrand() + ", price=" + getPrice() + ", time_garantia="
				+ getTime_garantia() + ", system=" + getSystem() + ", f_inicio_garantia=" + f_inicio_garantia.ToString()
				+ ", f_final_garantia=" + f_final_garantia.ToString() + ", Dias restantes de garantia= " + getgarantia()
				+ ", rating=" + getRating() + ", total_size=" + total_size + ", sim=" + sim + ", width=" + width
				+ ", ram=" + ram + ", capacity=" + capacity + ", batery=" + batery + "]";
	}

}
