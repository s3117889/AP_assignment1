package AP_assignment1;

import java.util.ArrayList;

public class MiniNet {

	public static void main(String[] args) {
		ArrayList<Person> _network = new ArrayList<>();
		// start: initial set up of network
		// creating people
		Adult rb = new Adult("Rudi Basiran", 48, "M", "Systems Analyst");
		Adult aa = new Adult("Ahysa Ahmad", 45, "F");
		Child ra = new Child("Rida Aqyda", 7, "F");

		Adult as = new Adult("Arthur Simanjuntak", 45, "M", "Wave Engineer");
		Adult sr = new Adult("Sheree Reaver", 45, "F", "Civil Engineer");
		Child rs = new Child("Rangi Simanjuntak", 7, "M");
		Child ts = new Child("Tane Simanjuntak", 5, "M");

		Adult aj = new Adult("Andrew James", 45, "M", "HR Officer");
		Adult nj = new Adult("Nat James", 45, "F");
		Adult dj = new Adult("Dianne James", 75, "F");
		Child cj = new Child("Callum James", 7, "M");

		Adult sm = new Adult("Sherri McRae", 43, "F", "Student");

		// adding people to the network
		_network.add(rb);
		_network.add(aa);
		_network.add(ra);
		_network.add(as);
		_network.add(sr);
		_network.add(rs);
		_network.add(ts);

		_network.add(aj);
		_network.add(nj);
		_network.add(cj);
		_network.add(dj);

		_network.add(sm);

		// adding connections
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

		aj.addConnection(nj, "Spouse");
		aj.addConnection(cj, "Child");

		cj.addConnection(aj, "Parent");
		cj.addConnection(nj, "Parent");

		rb.addConnection(sm, "Friend");
		rb.addConnection(as, "Friend");
		rb.addConnection(sr, "Friend");

		// end: initial set up of network

		Menu menu = new Menu();
		Driver driver = new Driver();

		while (!menu.Exit()) {
			menu.displayMenu();
			driver.menuAction(menu.getOption(), _network);
		}
	}

}
