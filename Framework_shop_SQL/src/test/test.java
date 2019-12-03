package test;

import modules.products.Dummies.Dummies_products;

public class test {
	public static void main(String[] args) {
		Dummies_products.main(null);
		try {
			test1.deleteAdmin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
