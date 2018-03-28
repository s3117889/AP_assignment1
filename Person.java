package AP_assignment1;

/*
Title: RMIT Advanced Programming Assignment 1 
Developer(s): 
- Sherri McRae <s3117889@student.rmit.edu.au>
- Rudi Basiran <s3665980@student.rmit.edu.au> 
Date Created: 18 March 2018 
Description: Person class 
Notes: --
 */

public abstract class Person {
	private String _name;
	private int _age;
	private String _gender;

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

	public String getGender() {
		return _gender;
	}

	public void setGender(String g) {
		_gender = g;
	}
}
