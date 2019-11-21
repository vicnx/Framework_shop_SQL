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
		return "tv [getName()=" + getName() + ", getBrand()=" + getBrand() + ", getPrice()=" + getPrice()
				+ ", getSystem()=" + getSystem() + ", getTime_garantia()=" + getTime_garantia()
				+ ", getF_inicio_garantia()=" + getF_inicio_garantia() + ", getF_final_garantia()="
				+ f_final_garantia.ToString() + ", Dias restantes de garantia= " + getgarantia() + ", getRating()="
				+ getRating() + ", smarttv=" + smarttv + ", hdmis=" + hdmis + "]";
	}

}
