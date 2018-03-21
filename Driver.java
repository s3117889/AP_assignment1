package AP_assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	final int quitMenu = 0;
	final int addPerson = 1;
	final int findPerson = 2;
	final int displayProfile = 3;
	final int displayAllProfile = 4;
	final int updateProfile = 5;
	final int deletePerson = 6;
	final int connectPerson = 7;
	final int findFriends = 8;
	final int findFamily = 9;

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
			Scanner input = new Scanner(System.in);
			System.out.print("Enter Name: ");
			String findName = input.nextLine();
			System.out.println("");

			Boolean found = findPerson(nt, findName);

			drawLine();
		}

		else if (menuItem == displayProfile) {

			Scanner input = new Scanner(System.in);
			System.out.print("Enter Name: ");
			String findName = input.nextLine();
			System.out.println("");

			if (findPerson(nt, findName)) {
				int index = -1;
				index = getIndexByProperty(nt, findName);
				if (index >= 0) {
					displayProfile(nt.get(index));
				}
			}

			drawLine();

		} else if (menuItem == displayAllProfile) {
			drawLine();

			for (int i = 0; i < nt.size(); i++) {
				displayProfile(nt.get(i));
				drawLine();
			}

		} else if (menuItem == updateProfile) {
			drawLine();

		} else if (menuItem == deletePerson) {
			drawLine();

		} else if (menuItem == connectPerson) {
			drawLine();

		} else if (menuItem == findFriends) {
			drawLine();

		} else if (menuItem == findFamily) {
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
