package AP_assignment1;

import java.util.ArrayList;

public class Driver {

	final int quitMenu = 0;
	final int addPerson = 1;
	final int findPerson = 2;
	final int displayProfile = 3;
	final int displayAllProfile = 4;
	final int updateProfile = 5;
	final int deletePerson = 6; // not_done_yet
	final int connectPerson = 7;
	final int findFriends = 8; // not_done_yet
	final int findFamily = 9; // not_done_yet

	// not_done_yet: check for friends below x
	// not_done_yet: check for age difference 3 years old

	public Driver() {

	}

	public void menuAction(int menuItem, ArrayList<Person> nt) {

		if (menuItem == addPerson) {
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
			drawLine();
		}

		if (menuItem == findPerson) {
			Boolean found;
			String findName;

			findName = "Rudi"; // person does not exists
			found = findPerson(nt, findName);
			drawLine();

			findName = "Rudi Basiran"; // person exists
			found = findPerson(nt, findName);
			drawLine();
		}

		else if (menuItem == displayProfile) {

			Boolean found;
			String findName;

			findName = "Rudi"; // person does not exists
			found = findPerson(nt, findName);
			drawLine();

			findName = "Rudi Basiran"; // person exists
			if (findPerson(nt, findName)) {
				displayProfile(nt.get(getIndexByProperty(nt, findName)));
			}

			drawLine();

		} else if (menuItem == displayAllProfile) {
			drawLine();

			for (int i = 0; i < nt.size(); i++) {
				displayProfile(nt.get(i));
				drawLine();
			}

		} else if (menuItem == updateProfile) {

			Boolean found;
			String findName;

			findName = "Rudi"; // person does not exists
			found = findPerson(nt, findName);
			drawLine();

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

			drawLine();

		} else if (menuItem == deletePerson) {
			// not_done_yet
			drawLine();

		} else if (menuItem == connectPerson) {
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

					drawLine();
					displayProfile(rb);
					drawLine();
					displayProfile(nj);
					drawLine();
					displayProfile(sm);
					drawLine();

					rb.addConnection(nj, "Friend");
					rb.addConnection(sm, "!Friend");

					drawLine();
					displayProfile(rb);
					drawLine();
					displayProfile(nj);
					drawLine();
					displayProfile(sm);
					drawLine();

					// test update spouse without child

					drawLine();
					displayProfile(js);
					drawLine();
					displayProfile(sm);

					js.addConnection(sm, "Spouse");

					drawLine();
					displayProfile(js);
					drawLine();
					displayProfile(sm);

					// test update spouse with child

				}
				// not_done_yet: test update child (assume have parents)

			}
			drawLine();

		} else if (menuItem == findFriends) {
			// not_done_yet
			drawLine();

		} else if (menuItem == findFamily) {
			// not_done_yet
			drawLine();

		}
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

				ArrayList<Person> friends = new ArrayList<>();
				friends = a.getFriends();
				if (friends.size() > 0) {
					System.out.println("Friends: ");
					for (int i = 0; i < friends.size(); i++) {
						System.out.println("- " + friends.get(i).getName());
					}
				}

				ArrayList<Person> children = new ArrayList<>();
				children = a.getChildren();
				if (children.size() > 0) {
					System.out.println("Children: ");
					for (int i = 0; i < children.size(); i++) {
						System.out.println("- " + children.get(i).getName());
					}
				}
			}

			if (p instanceof Child) {
				Child c = (Child) p;
				System.out.println("Parents: ");
				System.out.println("- " + c.getFather().getName());
				System.out.println("- " + c.getMother().getName());
			}
		}
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

	public void drawLine() {
		for (int x = 0; x < 50; x++)
			System.out.print("-");
		System.out.println("");
	}
}
