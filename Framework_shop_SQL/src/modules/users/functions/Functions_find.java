package modules.users.functions;

import modules.users.classes.Admin;
import modules.users.classes.Client;
import modules.users.classes.Singleton;
import modules.users.classes.User;

public class Functions_find {
	// admin
	public static int find_admin(Admin admin) {
		for (int i = 0; i < Singleton.users.size(); i++) {
			User Admin = Singleton.users.get(i);
			if (Admin instanceof Admin) {
				String username1 = ((Admin) Admin).getUsername();
				String username2 = ((Admin) admin).getUsername();
				if (username1.equals(username2)) {
					return 1;
				} else {
					return -1;
				}
			}
		}
		return -1;
	}

	// Client
	public static int find_client(Client client) {
		for (int i = 0; i < Singleton.users.size(); i++) {
			User Client = Singleton.users.get(i);
			if (Client instanceof Client) {
				String idclient = ((Client) Client).getIdclient();
				String idclient2 = ((Client) client).getIdclient();
				if (idclient.equals(idclient2)) {
					return 1;
				} else {
					return -1;
				}
			}
		}
		return -1;
	}
}
