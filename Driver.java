package AP_assignment1;

import java.util.ArrayList;

public class Driver {

	public void displayProfile(Person p) {
		if (p != null) {

			System.out.println("Name: " + p.getName() + ", (" + p.getGender() + "), " + p.getAge());

			if (p instanceof Adult) {
				Adult a = (Adult) p;

				if (a.getInterest() != null)
					System.out.println("Interests: " + a.getInterest());

				if (a.getSpouse() != null)
					System.out.println("Spouse: " + a.getSpouse().getName());

				ArrayList<Person> friends = new ArrayList<>();
				friends = a.getFriends(p);
				if (friends != null) {
					System.out.println("Friends: ");
					for (int i = 0; i < friends.size(); i++) {
						System.out.println("- " + friends.get(i).getName());
					}
				}

				ArrayList<Person> children = new ArrayList<>();
				children = a.getChildren(p);
				if (children != null) {
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

}
