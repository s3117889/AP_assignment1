package AP_assignment1;

import java.util.ArrayList;

/*
Title: RMIT Advanced Programming Assignment 1 
Developer(s): 
- Rudi Basiran <s3665980@student.rmit.edu.au> 
- Sherri McRae <s3117889@student.rmit.edu.au>
Date Created: 21 March 2018 
Description: Driver class 
 */

public class Driver {

	public Driver() {
	}

	public Driver(ArrayList<Person> network, ArrayList<Relationship> connection) {

		// start: initial set up of network for demo
		// otherwise constructor is normally empty

		// creating people
		Adult rb = new Adult("Rudi Basiran", 48, "M", "Systems Analyst");
		Adult aa = new Adult("Ahysa Ahmad", 45, "F");
		Child ra = new Child("Rida Aqyda", 7, "F");

		Adult as = new Adult("Arthur Simanjuntak", 45, "M", "Wave Engineer");
		Adult sr = new Adult("Sheree Reaver", 45, "F", "Civil Engineer");
		Child rs = new Child("Rangi Simanjuntak", 8, "M");
		Child ts = new Child("Tane Simanjuntak", 6, "M");

		Adult aj = new Adult("Andrew James", 45, "M", "HR Officer");
		Adult nj = new Adult("Nat James", 45, "F");
		Child cj = new Child("Callum James", 8, "M");
		Adult dj = new Adult("Dianne James", 75, "F");

		Adult sm = new Adult("Sherri McRae", 43, "F", "Student");
		Adult hn = new Adult("Huani Neupane", 28, "F", "Student");
		Adult cl = new Adult("Chloe Loh", 25, "F", "Student");
		Adult ah = new Adult("Ahmed Abdullah", 28, "M", "Student");

		// adding people to the network
		network.add(rb);
		network.add(aa);
		network.add(ra);
		network.add(as);
		network.add(sr);
		network.add(rs);
		network.add(ts);

		network.add(aj);
		network.add(nj);
		network.add(cj);
		network.add(dj);

		network.add(sm);
		network.add(hn);
		network.add(cl);
		network.add(ah);

		// adding connections
		connection.add(new Relationship(rb, GlobalClass.Spouse, aa));
		connection.add(new Relationship(rb, GlobalClass.Father, ra));
		connection.add(new Relationship(aa, GlobalClass.Mother, ra));

		connection.add(new Relationship(as, GlobalClass.Spouse, sr));
		connection.add(new Relationship(as, GlobalClass.Father, rs));
		connection.add(new Relationship(sr, GlobalClass.Mother, rs));

		connection.add(new Relationship(as, GlobalClass.Father, ts));
		connection.add(new Relationship(sr, GlobalClass.Mother, ts));

		connection.add(new Relationship(aj, GlobalClass.Spouse, nj));
		connection.add(new Relationship(aj, GlobalClass.Father, cj));
		connection.add(new Relationship(nj, GlobalClass.Mother, cj));

		connection.add(new Relationship(rb, GlobalClass.Friend, sm));
		connection.add(new Relationship(rb, GlobalClass.Friend, hn));
		connection.add(new Relationship(rb, GlobalClass.Friend, cl));

		connection.add(new Relationship(ra, GlobalClass.Friend, rs));

		// end: initial set up of network
	}

	public void menuAction(int menuItem, ArrayList<Person> network, ArrayList<Relationship> connection) {

		if (menuItem == GlobalClass.addPerson)
			addPerson(network);

		else if (menuItem == GlobalClass.findPerson)
			findPerson(network);

		else if (menuItem == GlobalClass.displayProfile) {
			String name = GlobalClass.getStringInput("Enter Name: ");
			if (findPerson(network, name)) {
				Person p = network.get(getIndexByProperty(network, name));
				displayProfile(p, connection);
			} else
				System.out.println("[" + name + "] not found");
		}

		else if (menuItem == GlobalClass.displayAllProfile) {
			for (int i = 0; i < network.size(); i++) {
				displayProfile(network.get(i), connection);
				GlobalClass.drawLine();
			}

		} else if (menuItem == GlobalClass.updateProfile) {
			String name = GlobalClass.getStringInput("Enter Name: ");
			if (findPerson(network, name)) {
				Person p = network.get(getIndexByProperty(network, name));
				updateProfile(p);
			} else
				System.out.println("[" + name + "] not found");

		} else if (menuItem == GlobalClass.deletePerson) {
			String name = GlobalClass.getStringInput("Enter Name: ");
			if (findPerson(network, name)) {
				Person p = network.get(getIndexByProperty(network, name));
				deletePerson(p, network, connection);
			} else
				System.out.println("[" + name + "] not found");

		} else if (menuItem == GlobalClass.connectPerson) {
			String input = GlobalClass.getStringInput("Enter Name of First Person (Friend or Parent): ");
			if (findPerson(network, input)) {
				Person p = network.get(getIndexByProperty(network, input));
				input = GlobalClass.getStringInput("Enter Name of Second Person (Friend or Child: ");
				if (findPerson(network, input)) {
					Person q = network.get(getIndexByProperty(network, input));
					int conn = -1;
					do {
						System.out.println(GlobalClass.Friend + ". Friend");
						System.out.println(GlobalClass.Spouse + ". Spouse");
						System.out.println(GlobalClass.Father + ". Father");
						System.out.println(GlobalClass.Mother + ". Mother");
						conn = GlobalClass.getIntegerInput("Choose Relationship: ");
					} while (conn > 3 | conn < 0);

					connectPerson(p, q, conn, connection);
				} else
					System.out.println("[" + input + "] not found");
			} else
				System.out.println("[" + input + "] not found");
		}

		else if (menuItem == GlobalClass.findFriends) {
			String input = GlobalClass.getStringInput("Enter Name of First Person (Friend): ");
			if (findPerson(network, input)) {
				Person p = network.get(getIndexByProperty(network, input));
				input = GlobalClass.getStringInput("Enter Name of Second Person (Friend) ");
				if (findPerson(network, input)) {
					Person q = network.get(getIndexByProperty(network, input));
					if (findFriends(p, q, connection))
						System.out.println(p.getName() + " is a friend of " + q.getName());
					else
						System.out.println(p.getName() + " is NOT a friend of " + q.getName());
				} else
					System.out.println("[" + input + "] not found");
			} else
				System.out.println("[" + input + "] not found");
		}

		else if (menuItem == GlobalClass.findFamily) {
			String name = GlobalClass.getStringInput("Enter Name: ");
			if (findPerson(network, name)) {
				Person p = network.get(getIndexByProperty(network, name));
				findFamily(p, connection);
			}
		}
	}

	public void updateProfile(Person p) {

		Adult a = (Adult) p;
		int newAge = GlobalClass.getIntegerInput("Enter New Age: ");
		a.setAge(newAge);
		String newInfo = GlobalClass.getStringInput("Enter New Info: ");
		a.setInfo(newInfo);

	}

	public void deletePerson(Person p, ArrayList<Person> nt, ArrayList<Relationship> connection) {

		for (int i = connection.size() - 1; i >= 0; i--) {
			if (connection.get(i).getPersonA().getName().equals(p.getName()))
				connection.remove(i);
		}

		for (int i = connection.size() - 1; i >= 0; i--) {
			if (connection.get(i).getPersonB().getName().equals(p.getName()))
				connection.remove(i);
		}

		nt.remove(p);

	}

	public void connectPerson(Person p, Person q, int conn, ArrayList<Relationship> connection) {
		connection.add(new Relationship(p, conn, q));
	}

	public Boolean findFriends(Person p, Person q, ArrayList<Relationship> connection) {

		Boolean found = false;

		for (int i = 0; i < connection.size(); i++) {
			if (connection.get(i).getPersonA().getName().equals(p.getName())
					& connection.get(i).getConn() == GlobalClass.Friend
					& connection.get(i).getPersonB().getName().equals(q.getName()))
				found = true;

			if (connection.get(i).getPersonA().getName().equals(q.getName())
					& connection.get(i).getConn() == GlobalClass.Friend
					& connection.get(i).getPersonB().getName().equals(p.getName()))
				found = true;
		}
		return found;
	}

	public void findFamily(Person p, ArrayList<Relationship> connection) {
		if (p instanceof Adult) {
			Adult a = (Adult) p;
			findSpouse(p, connection);
			findChildren(p, connection);
		}
		if (p instanceof Child) {
			Child c = (Child) p;
			findParents(c, connection);
		}
	}

	public void displayProfile(Person p, ArrayList<Relationship> connection) {
		System.out.println("Name: " + p.getName() + ", (" + p.getGender() + "), " + p.getAge());
		if (p instanceof Adult) {
			Adult a = (Adult) p;
			if (a.getInfo() != null)
				System.out.println("About: " + a.getInfo());

			findSpouse(p, connection);
			findChildren(p, connection);
			findFriends(p, connection);
		}
		if (p instanceof Child) {
			Child c = (Child) p;
			findParents(c, connection);
			findFriends(c, connection);
		}
	}

	public void findParents(Person p, ArrayList<Relationship> connection) {

		for (int i = 0; i < connection.size(); i++) {
			if (connection.get(i).getPersonB().getName().equals(p.getName())
					& connection.get(i).getConn() == GlobalClass.Father)
				System.out.println("Father: " + connection.get(i).getPersonA().getName());

			if (connection.get(i).getPersonB().getName().equals(p.getName())
					& connection.get(i).getConn() == GlobalClass.Mother)
				System.out.println("Mother: " + connection.get(i).getPersonA().getName());
		}
	}

	public void findFriends(Person p, ArrayList<Relationship> connection) {
		int count = 0;

		for (int i = 0; i < connection.size(); i++) {
			if (connection.get(i).getPersonA().getName().equals(p.getName())
					& connection.get(i).getConn() == GlobalClass.Friend) {
				count++;
				System.out.println(((count == 1) ? "Friends :\n-" : "-") + connection.get(i).getPersonB().getName());
			}
			if (connection.get(i).getPersonB().getName().equals(p.getName())
					& connection.get(i).getConn() == GlobalClass.Friend) {
				count++;
				System.out.println(((count == 1) ? "Friends :\n-" : "-") + connection.get(i).getPersonA().getName());
			}
		}
	}

	public void findChildren(Person p, ArrayList<Relationship> connection) {
		int count = 0;
		for (int i = 0; i < connection.size(); i++) {
			if (connection.get(i).getPersonA().getName().equals(p.getName()) & connection.get(i)
					.getConn() == ((p.getGender() == "M") ? GlobalClass.Father : GlobalClass.Mother)) {
				count++;
				System.out.println(((count == 1) ? "Children :\n-" : "-") + connection.get(i).getPersonB().getName());
			}
		}
	}

	public void findSpouse(Person p, ArrayList<Relationship> connection) {

		for (int i = 0; i < connection.size(); i++) {
			if (connection.get(i).getPersonA().getName().equals(p.getName())
					& connection.get(i).getConn() == GlobalClass.Spouse) {
				System.out.println("Spouse: " + connection.get(i).getPersonB().getName());

			} else if (connection.get(i).getPersonB().getName().equals(p.getName())
					& connection.get(i).getConn() == GlobalClass.Spouse) {
				System.out.println("Spouse: " + connection.get(i).getPersonA().getName());

			}
		}
	}

	public void addPerson(ArrayList<Person> nt) {

		String name = GlobalClass.getStringInput("Enter Name: ");
		if (findPerson(nt, name))
			System.out.println("[" + nt.get(getIndexByProperty(nt, name)).getName() + "] already exists.");
		else {
			int age = GlobalClass.getIntegerInput("Enter Age: ");

			String gender = GlobalClass.getStringInput("Enter Gender (M/F): ");

			if (age > 16) {
				String info = GlobalClass.getStringInput("Enter Info: ");
				Adult na = new Adult(name, age, gender, info);
				nt.add(na);
			} else {
				Child nc = new Child(name, age, gender);
				nt.add(nc);
			}
			System.out.println("[" + name + "] added to MiniNet.");
		}
	}

	public Boolean findPerson(ArrayList<Person> nt, String name) {
		if (getIndexByProperty(nt, name) >= 0)
			return true;
		else
			return false;
	}

	public void findPerson(ArrayList<Person> nt) {
		String name = GlobalClass.getStringInput("Enter Person's Name: ");
		if (findPerson(nt, name))
			System.out.println("[" + nt.get(getIndexByProperty(nt, name)).getName() + "] found");
		else
			System.out.println("[" + name + "] not found");
	}

	public int getIndexByProperty(ArrayList<Person> nt, String name) {
		int result = -1;
		for (int i = 0; i < nt.size(); i++) {
			if (nt.get(i).getName().toUpperCase().equals(name.toUpperCase())) {
				result = i;
				break;
			}
		}
		return result;
	}

}
