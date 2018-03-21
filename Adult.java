package AP_assignment1;

import java.util.ArrayList;

public class Adult extends Person {

	Person _spouse;
	String _info;
	ArrayList<Person> _friends = new ArrayList<>();
	ArrayList<Person> _children = new ArrayList<>();

	public Adult(String name, int age, String g, String info) {
		super.setName(name);
		super.setAge(age);
		super.setGender(g);
		_info = info;
	}

	public Adult(String name, int age, String g) {
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

	public void setInfo(String info) {
		_info = info;
	}

	public void setSpouse(Person p) {
		_spouse = p;
	}

	public void addFriend(Person p) {
		_friends.add(p);
	}

	public void delFriend(Person p) {
		_friends.remove(p);
	}

	public ArrayList<Person> getFriends() {
		return _friends;
	}

	public ArrayList<Person> getChildren() {
		return _children;
	}

	public void addChild(Person p) {
		_children.add(p);
	}

	public void addConnection(Person a, String role) {

		if (role == "Friend") {

			_friends.add(a);
			a.addFriend(this);
		}

		else if (role == "!Friend") {
			_friends.remove(a);
			a.delFriend(this);
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

	public String getInfo() {
		return _info;
	}

}
