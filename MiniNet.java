package AP_assignment1;

import java.util.ArrayList;

public class MiniNet {

	public static void main(String[] args) {
		ArrayList<Person> _network = new ArrayList<>();

		Menu menu = new Menu();
		Driver driver = new Driver(_network);

		while (!menu.Exit()) {
			menu.displayMenu();
			driver.menuAction(menu.getOption(), _network);
		}
	}

}
