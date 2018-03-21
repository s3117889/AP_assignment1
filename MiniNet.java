package AP_assignment1;

import java.util.ArrayList;

public class MiniNet {

	public static void main(String[] args) {
		ArrayList<Person> _network = new ArrayList<>();
		Menu menu = new Menu();

		// start: initial set up of network
		System.out.println("Creating People:");
		Adult rb = new Adult("Rudi Basiran", 48, 'M', "Systems Analyst");
		Adult aa = new Adult("Ahysa Ahmad", 45, 'F');
		Child ra = new Child("Rida Aqyda", 7, 'F');

		Adult as = new Adult("Arthur Simanjuntak", 45, 'M', "Wave Engineer");
		Adult sr = new Adult("Sheree Reaver", 45, 'F', "Civil Engineer");
		Child rs = new Child("Rangi Simanjuntak", 7, 'M');
		Child ts = new Child("Tane Simanjuntak", 5, 'M');

		Adult sm = new Adult("Sherri McRae", 43, 'F', "Student");

		System.out.println("Adding People to Network:");
		_network.add(rb);
		_network.add(aa);
		_network.add(ra);
		_network.add(as);
		_network.add(sr);
		_network.add(rs);
		_network.add(ts);
		_network.add(sm);

		System.out.println("Adding Connections:");
		rb.addConnection(aa, "Spouse");
		rb.addConnection(ra, "Child");
		ra.addConnection(rb, "Parent");
		ra.addConnection(aa, "Parent");

		as.addConnection(sr, "Spouse");
		as.addConnection(rs, "Child");
		as.addConnection(ts, "Child");

		rs.addConnection(as, "Parent");
		rs.addConnection(sr, "Parent");

		ts.addConnection(as, "Parent");
		ts.addConnection(sr, "Parent");

		rb.addConnection(sm, "Friend");
		rb.addConnection(as, "Friend");
		rb.addConnection(sr, "Friend");

		// end: initial set up of network

		// start: test network
		System.out.println("Displaying All Profiles:");
		Driver driver = new Driver();

		for (int i = 0; i < _network.size(); i++) {

			System.out.println("[Profile (" + (i + 1) + ")]");
			driver.displayProfile(_network.get(i));
			System.out.println("--------------------------------------");
		}

		// end: test network

		while (!menu.notExit())

		{
			menu.displayMenu();
			menu.menuSelect();
		}
	}

}
