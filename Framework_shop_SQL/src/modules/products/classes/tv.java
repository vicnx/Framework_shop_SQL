package modules.products.classes;

import classes.Fecha;

public class tv extends Electronic {
	String smarttv = "";
	String hdmis = "";

	public tv(String name, String price, String system, String brand, String rating, int time_garantia,
			Fecha f_inicio_garantia, Fecha f_final_garantia, String smarttv, String hdmis) {
		super(name, price, system, brand, rating, time_garantia, f_inicio_garantia, f_final_garantia);
		this.smarttv = smarttv;
		this.hdmis = hdmis;
	}

	public String getSmarttv() {
		return smarttv;
	}

	public void setSmarttv(String smarttv) {
		this.smarttv = smarttv;
	}

	public String getHdmis() {
		return hdmis;
	}

	public void setHdmis(String hdmis) {
		this.hdmis = hdmis;
	}

	@Override
	public String toString() {
		return "Name=" + getName() + "\nBrand=" + getBrand() + "\nPrice=" + getPrice() + "\nSystem=" + getSystem()
				+ "\nTime_garantia=" + getTime_garantia() + "\nF_inicio_garantia=" + getF_inicio_garantia().ToString()
				+ "\nF_final_garantia=" + f_final_garantia.ToString() + "\nDias restantes de garantia= " + getgarantia()
				+ "\nRating=" + getRating() + "\nsmarttv=" + smarttv + "\nhdmis=" + hdmis;
	}

}
