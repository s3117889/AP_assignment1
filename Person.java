package AP_assignment1;

public abstract class Person {
	private String _name;
	private int _age;
	private char _gender;

	public Person() {
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getAge() {
		return _age;
	}

	public void setAge(int age) {
		_age = age;
	}

	public char getGender() {
		return _gender;
	}

	public void setGender(char g) {
		_gender = g;
	}

	public void addConnection(Person a, String role) {

	}

	public void setSpouse(Person p) {

	}

	public void setMother(Person p) {

	}

	public void setFather(Person p) {

	}

	public void addFriend(Person p) {

	}

	public void addChild(Person p) {

	}

}
