package AP_assignment1;

import java.util.ArrayList;

public class Child extends Person {
	Person _father;
	Person _mother;
	ArrayList<Person> _friends = new ArrayList<>();

	public Child(String name, int age, char g) {
		super.setName(name);
		super.setAge(age);
		super.setGender(g);
	}

	public Person getFather() {
		return _father;
	}

	public void setFather(Person p) {
		_father = p;
	}

	public Person getMother() {
		return _mother;
	}

	public void setMother(Person p) {
		_mother = p;
	}

	public void addConnection(Person a, String role) {

		if (role == "Friend") {
			this.addFriend(a);
			a.addFriend(this);
		}

		if (role == "Parent") {
			if (a.getGender() == 'M')
				this.setFather(a);
			else
				this.setMother(a);
		}
	}

}
