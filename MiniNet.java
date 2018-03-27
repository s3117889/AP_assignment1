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
		ArrayList<Relationship> _relationship = new ArrayList<>();

		Menu menu = new Menu();
		Driver driver = new Driver(_network, _relationship);

		while (!menu.exitMenu()) {
			menu.displayMenu();
			driver.menuAction(menu.getOption(), _network, _relationship);
		}

		// test relationship class

		Person rb = _network.get(driver.getIndexByProperty(_network, "Rudi Basiran"));
		Person aa = _network.get(driver.getIndexByProperty(_network, "Ahysa Ahmad"));
		Person sm = _network.get(driver.getIndexByProperty(_network, "Sherri McRae"));

		Relationship r1 = new Relationship(rb, GlobalClass.Spouse, aa);
		_relationship.add(r1);

		Relationship r2 = new Relationship(rb, GlobalClass.Friend, sm);
		_relationship.add(r2);

		Relationship findRS = new Relationship(aa, GlobalClass.Friend, sm);

		// iterate through relationships to find whether relationship A to B or
		// vice-versa (B to A) exists
		Boolean found = false;
		System.out.println("Looking for: " + findRS.getPersonA().getName() + " | " + findRS.getConn() + " | "
				+ findRS.getPersonB().getName());
		for (int i = 0; i < _relationship.size(); i++) {
			if (findRS.equals(_relationship.get(i)) | (findRS.getPersonA().equals(_relationship.get(i).getPersonB())
					& findRS.getConn() == _relationship.get(i).getConn()
					& findRS.getPersonB().equals(_relationship.get(i).getPersonA()))) {
				found = true;
				System.out.println("Found: " + _relationship.get(i).getPersonA().getName() + " | "
						+ _relationship.get(i).getConn() + " | " + _relationship.get(i).getPersonB().getName());
			}
		}
		if (!found)
			System.out.println("Relationship not found");
	}

}
