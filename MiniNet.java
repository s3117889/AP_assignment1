package AP_assignment1;

import java.util.ArrayList;

/*
Title: RMIT Advanced Programming Assignment 1 
Developer(s): 
- Rudi Basiran <s3665980@student.rmit.edu.au> 
- Sherri McRae <s3117889@student.rmit.edu.au>
Date Created: 21 March 2018 
Description: MiniNet
 */

public class MiniNet {

	public static void main(String[] args) {
		ArrayList<Person> _network = new ArrayList<>();

		Menu menu = new Menu();
		Driver driver = new Driver(_network);

		while (!menu.exitMenu()) {
			menu.displayMenu();
			driver.menuAction(menu.getOption(), _network);
		}

		ArrayList<Relationship> _relationship = new ArrayList<>();

		Person rb = _network.get(driver.getIndexByProperty(_network, "Rudi Basiran"));
		Person aa = _network.get(driver.getIndexByProperty(_network, "Ahysa Ahmad"));
		Person sm = _network.get(driver.getIndexByProperty(_network, "Sherri McRae"));

		Relationship r1 = new Relationship(rb, "Spouse", aa);
		_relationship.add(r1);

		Relationship r2 = new Relationship(rb, "Friend", sm);
		_relationship.add(r2);

		Relationship r3 = new Relationship(rb, "Spouse", sm);
		// r3 is not added so it does not "exist" even though it has been created

		for (int i = 0; i < _relationship.size(); i++) {
			if (r1.equals(_relationship.get(i))) {
				System.out.println("R1 True");
			}
			if (r2.equals(_relationship.get(i))) {
				System.out.println("R2 True");
			}
			if (r3.equals(_relationship.get(i))) {
				System.out.println("R3 True");
			}

		}

	}

}
