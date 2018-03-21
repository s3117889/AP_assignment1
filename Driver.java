package AP_assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public Driver() {

	}

	public void menuAction(String menuItem, ArrayList<Person> nt) {

		if (menuItem == "Add Person") {
			String name = "Jack Sparrow";
			int age = 55;
			String gender = "M";

			int index = -1;
			index = getIndexByProperty(nt, name);
			if (index >= 0) {
				System.out.println("[" + name + "] already exists.");
			}

			if (age > 16) {
				String info = "Pirate";
				Adult na = new Adult(name, age, gender, info);
				nt.add(na);
			} else {
				Child nc = new Child(name, age, gender);
				nt.add(nc);
			}
		}

		if (menuItem == "Find Person") {
			Scanner input = new Scanner(System.in);
			System.out.print("Enter Name: ");
			String findName = input.nextLine();
			System.out.println("");

			int index = -1;
			index = getIndexByProperty(nt, findName);

			if (index >= 0) {
				System.out.println("Found:");
				System.out.println("- " + nt.get(index).getName() + ", (" + nt.get(index).getGender() + "), "
						+ nt.get(index).getAge());
			} else
				System.out.println("Not Found - " + findName);
			drawLine();
		}

		else if (menuItem == "Display Single Profile") {

			Scanner input = new Scanner(System.in);
			System.out.print("Enter Name: ");
			String findName = input.nextLine();
			System.out.println("");

			int index = -1;
			index = getIndexByProperty(nt, findName);
			if (index >= 0) {
				displayProfile(nt.get(index));
			} else
				System.out.println("Not Found - " + findName);
			drawLine();

		} else if (menuItem == "Display All Profile(s)") {
			drawLine();

			for (int i = 0; i < nt.size(); i++) {
				displayProfile(nt.get(i));
				drawLine();
			}
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
