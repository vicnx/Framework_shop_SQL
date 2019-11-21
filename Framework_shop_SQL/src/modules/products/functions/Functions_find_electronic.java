package modules.products.functions;

import modules.products.classes.Electronic;
import modules.products.classes.Mobile;
import modules.products.classes.Singleton;
import modules.products.classes.Tablet;
import modules.products.classes.tv;

public class Functions_find_electronic {
	// Tablet
	public static int find_tablet(Tablet t) {
		for (int i = 0; i < Singleton.electronics.size(); i++) {
			Electronic Tablet = Singleton.electronics.get(i);
			if (Tablet instanceof Tablet) {
				String name = ((Tablet) Tablet).getName();
				String name2 = ((Tablet) t).getName();
				if (name.equals(name2)) {
					return 1;
				} else {
					return -1;
				}
			}
		}
		return -1;
	}

	// Mobile
	public static int find_mobile(Mobile m) {
		for (int i = 0; i < Singleton.electronics.size(); i++) {
			Electronic Mobile = Singleton.electronics.get(i);
			if (Mobile instanceof Mobile) {
				String name = ((Mobile) Mobile).getName();
				String name2 = ((Mobile) m).getName();
				if (name.equals(name2)) {
					return 1;
				} else {
					return -1;
				}
			}
		}
		return -1;
	}

	// TV
	public static int find_tv(tv tv) {
		for (int i = 0; i < Singleton.electronics.size(); i++) {
			Electronic TV = Singleton.electronics.get(i);
			if (TV instanceof tv) {
				String name = ((tv) TV).getName();
				String name2 = ((tv) tv).getName();
				if (name.equals(name2)) {
					return 1;
				} else {
					return -1;
				}
			}
		}
		return -1;
	}
}
