package AP_assignment1;

import java.util.ArrayList;

public class Driver {

	// not_done_yet deletePerson

	// not_done_yet findFamily

	// not_done_yet: check for friends below x
	// not_done_yet: check for age difference 3 years old

	public Driver() {

	}

	public Driver(ArrayList<Person> network) {
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
	}

	public void menuAction(int menuItem, ArrayList<Person> nt) {

		if (menuItem == GlobalClass.addPerson) {
			String name = "Jack Sparrow";
			int age = 55;
			String gender = "M";

			if (findPerson(nt, name)) {
				System.out.println("[" + name + "] already exists.");
			} else {
				if (age > 16) {
					String info = "Pirate";
					Adult na = new Adult(name, age, gender, info);
					nt.add(na);
				} else {
					Child nc = new Child(name, age, gender);
					nt.add(nc);
				}
				System.out.println("[" + name + "] added to MiniNet.");
			}
			GlobalClass.drawLine();
		}

		if (menuItem == GlobalClass.findPerson) {
			Boolean found;
			String findName;

			findName = "Rudi"; // person does not exists
			found = findPerson(nt, findName);
			GlobalClass.drawLine();

			findName = "Rudi Basiran"; // person exists
			found = findPerson(nt, findName);
			GlobalClass.drawLine();
		}

		else if (menuItem == GlobalClass.displayProfile) {

			Boolean found;
			String findName;

			findName = "Rudi"; // person does not exists
			found = findPerson(nt, findName);
			GlobalClass.drawLine();

			findName = "Rudi Basiran"; // person exists
			if (findPerson(nt, findName)) {
				displayProfile(nt.get(getIndexByProperty(nt, findName)));
			}

			GlobalClass.drawLine();

		} else if (menuItem == GlobalClass.displayAllProfile) {
			GlobalClass.drawLine();

			for (int i = 0; i < nt.size(); i++) {
				displayProfile(nt.get(i));
				GlobalClass.drawLine();
			}

		} else if (menuItem == GlobalClass.updateProfile) {

			Boolean found;
			String findName;

			findName = "Rudi"; // person does not exists
			found = findPerson(nt, findName);
			GlobalClass.drawLine();

			findName = "Rudi Basiran"; // person exists

			if (findPerson(nt, findName)) {
				Person p = nt.get(getIndexByProperty(nt, findName));
				// test update basic profile
				if (p instanceof Adult) {
					Adult a = (Adult) p;
					a.setAge(47);
					a.setInfo("IT Architect");
				}
			}

			GlobalClass.drawLine();

		} else if (menuItem == GlobalClass.deletePerson) {

			GlobalClass.drawLine();

		} else if (menuItem == GlobalClass.connectPerson) {
			String findName = "Rudi Basiran";
			if (findPerson(nt, findName)) {
				Person p = nt.get(getIndexByProperty(nt, findName));

				if (p instanceof Adult) {
					Adult rb = (Adult) p;

					Adult nj = (Adult) nt.get(getIndexByProperty(nt, "Nat James"));
					Adult sm = (Adult) nt.get(getIndexByProperty(nt, "Sherri McRae"));
					Adult js = new Adult("Jon Snow", 66, "M", "Captain");
					nt.add(js); // add jon snow to the network

					// test add and drop friend

					GlobalClass.drawLine();
					displayProfile(rb);
					GlobalClass.drawLine();
					displayProfile(nj);
					GlobalClass.drawLine();
					displayProfile(sm);
					GlobalClass.drawLine();

					rb.addConnection(nj, "Friend");
					rb.addConnection(sm, "!Friend");

					GlobalClass.drawLine();
					displayProfile(rb);
					GlobalClass.drawLine();
					displayProfile(nj);
					GlobalClass.drawLine();
					displayProfile(sm);
					GlobalClass.drawLine();

					// test update spouse without child

					GlobalClass.drawLine();
					displayProfile(js);
					GlobalClass.drawLine();
					displayProfile(sm);

					js.addConnection(sm, "Spouse");

					GlobalClass.drawLine();
					displayProfile(js);
					GlobalClass.drawLine();
					displayProfile(sm);

					// test update spouse with child

				}
				// not_done_yet: test update child (assume have parents)

			}
			GlobalClass.drawLine();

		} else if (menuItem == GlobalClass.findFriends) {

			Boolean found = false;
			Boolean foundFriend = false;
			String findName, findFriend;

			findName = "Rudi"; // person does not exists
			findFriend = "Sherri "; // person does not exists
			found = findPerson(nt, findName);
			foundFriend = findPerson(nt, findFriend);
			GlobalClass.drawLine();

			findName = "Rudi Basiran"; // person exists
			findFriend = "Sherri "; // person does not exists
			found = findPerson(nt, findName);
			foundFriend = findPerson(nt, findFriend);

			GlobalClass.drawLine();

			findName = "Rudi Basiran"; // person exists and are both friends
			findFriend = "Sherri McRae"; // person exists and are both friends
			found = findPerson(nt, findName);
			foundFriend = findPerson(nt, findFriend);
			GlobalClass.drawLine();

			if (found && foundFriend) {
				Person p = nt.get(getIndexByProperty(nt, findName));
				Person q = nt.get(getIndexByProperty(nt, findFriend));

				findFriends(p, q);
				GlobalClass.drawLine();

			}

			findName = "Rudi Basiran"; // person exists and are NOT friends
			findFriend = "Andrew James"; // person exists and are NOT friends
			found = findPerson(nt, findName);
			foundFriend = findPerson(nt, findFriend);
			GlobalClass.drawLine();

			if (found && foundFriend) {
				Person p = nt.get(getIndexByProperty(nt, findName));
				Person q = nt.get(getIndexByProperty(nt, findFriend));

				findFriends(p, q);
				GlobalClass.drawLine();

			}

			else if (menuItem == GlobalClass.findFamily) {
				// not_done_yet
				GlobalClass.drawLine();
			}
		}
	}

	public void findFriends(Person p) {
		ArrayList<Person> friends = new ArrayList<>();
		if (p instanceof Adult) {
			Adult a = (Adult) p;
			friends = a.getFriends();
		} else if (p instanceof Child) {
			Child a = (Child) p;
			friends = a.getFriends();
		}

		if (friends.size() > 0) {
			System.out.println("Friends: ");
			for (int i = 0; i < friends.size(); i++) {
				System.out.println("- " + friends.get(i).getName());
			}
		} else
			System.out.println("Friends: None");

	}

	public void findFriends(Person p, Person q) {
		boolean found = false;
		ArrayList<Person> friends = new ArrayList<>();
		if (p instanceof Adult) {
			Adult a = (Adult) p;
			friends = a.getFriends();
		} else if (p instanceof Child) {
			Child a = (Child) p;
			friends = a.getFriends();
		}

		if (friends.size() > 0) {
			for (int i = 0; i < friends.size(); i++) {
				if (friends.get(i).getName() == q.getName())
					found = true;
				break;

			}
		}
		if (found)
			System.out.println(p.getName() + " and " + q.getName() + " are friends with each other.");
		else
			System.out.println(p.getName() + " and " + q.getName() + " are NOT friends of each other.");

	}

	public Boolean findPerson(ArrayList<Person> nt, String findName) {

		int index = -1;
		index = getIndexByProperty(nt, findName);

		if (index >= 0) {
			System.out.print("Found: ");
			System.out.println(
					nt.get(index).getName() + ", (" + nt.get(index).getGender() + "), " + nt.get(index).getAge());
			return true;
		} else {
			System.out.println("Not Found: " + findName);
			return false;
		}
	}

	public void displayProfile(Person p) {
		if (p != null) {
			System.out.println("Name: " + p.getName() + ", (" + p.getGender() + "), " + p.getAge());

			if (p instanceof Adult) {
				Adult a = (Adult) p;

				if (a.getInfo() != null)
					System.out.println("Information: " + a.getInfo());

				if (a.getSpouse() != null)
					System.out.println("Spouse: " + a.getSpouse().getName());

				findFriends(a);
				findChildren(a);

			}

			if (p instanceof Child) {
				Child c = (Child) p;
				findParents(c);

			}
		}
	}

	public void findChildren(Adult a) {
		ArrayList<Person> children = new ArrayList<>();
		children = a.getChildren();
		if (children.size() > 0) {
			System.out.println("Children: ");
			for (int i = 0; i < children.size(); i++) {
				System.out.println("- " + children.get(i).getName());
			}
		}
	}

	public void findParents(Child c) {
		System.out.println("Parents: ");
		System.out.println("- " + c.getFather().getName());
		System.out.println("- " + c.getMother().getName());
	}

	public int getIndexByProperty(ArrayList<Person> nt, String name) {
		int result = -1;
		for (int i = 0; i < nt.size(); i++) {
			if (nt.get(i).getName().equals(name)) {
				result = i;
				break;
			}
		}
		return result;
	}

}
