package AP_assignment1;

import java.util.ArrayList;

public class Adult extends Person {

	Person _spouse;
	String _interest;
	ArrayList<Person> _friends = new ArrayList<>();
	ArrayList<Person> _children = new ArrayList<>();

	public Adult(String name, int age, char g, String interest) {
		super.setName(name);
		super.setAge(age);
		super.setGender(g);
		_interest = interest;
	}

	public Adult(String name, int age, char g) {
		super.setName(name);
		super.setAge(age);
		super.setGender(g);

	}

	public Adult(String name, int age) {
		super.setName(name);
		super.setAge(age);
	}

	public Person getSpouse() {
		return _spouse;
	}

	public void setSpouse(Person p) {
		_spouse = p;
	}

	public void addFriend(Person p) {
		_friends.add(p);
	}

	public ArrayList<Person> getFriends(Person p) {
		return _friends;
	}

	public ArrayList<Person> getChildren(Person p) {
		return _children;
	}

	public void addChild(Person p) {
		_children.add(p);
	}

	public void addConnection(Person a, String role) {

		if (role == "Friend") {
			// System.out.println(this.getName() + ";" + a.getName());
			_friends.add(a);
			a.addFriend(this);
		}

		else if (role == "Spouse") {
			_spouse = a;
			a.setSpouse(this);

			if (_children != null) {
				for (int i = 0; i < _children.size(); i++) {
					a.addChild(_children.get(i));
				}
			}
		}

		else if (role == "Child") {
			this.addChild(a);

			if (_spouse != null) {
				_spouse.addChild(a);
			}
		}
	}

	public String getInterest() {
		return _interest;
	}

}
