package AP_assignment1;

import java.util.ArrayList;

/*
Title: RMIT Advanced Programming Assignment 1 
Developer(s): 
- Rudi Basiran <s3665980@student.rmit.edu.au> 
- Sherri McRae <s3117889@student.rmit.edu.au>
Date Created: 21 March 2018 
Description: MiniNet Class which is basically the main starting class
Notes: --
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
	}

}
