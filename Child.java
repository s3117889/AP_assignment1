package AP_assignment1;

import java.util.ArrayList;

/*
Title: RMIT Advanced Programming Assignment 1 
Developer(s): 
- Sherri McRae <s3117889@student.rmit.edu.au>
- Rudi Basiran <s3665980@student.rmit.edu.au> 
Date Created: 18 March 2018 
Description: Child class 
 */

public class Child extends Person {
	Person _father;
	Person _mother;
	ArrayList<Person> _friends = new ArrayList<>();

	public Child(String name, int age, String g) {
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

	public ArrayList<Person> getFriends() {
		return _friends;
	}

	public void addConnection(Person a, String role) {

		if (role == "Friend") {
			this.addFriend(a);
			a.addFriend(this);
		}

		if (role == "Parent") {
			if (a.getGender() == "M")
				this.setFather(a);
			else
				this.setMother(a);
		}
	}

}
