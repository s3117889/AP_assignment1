package AP_assignment1;

/*
Title: RMIT Advanced Programming Assignment 1 
Developer(s): 
- Sherri McRae <s3117889@student.rmit.edu.au>
- Rudi Basiran <s3665980@student.rmit.edu.au> 
Date Created: 18 March 2018 
Description: Adult class 
 */

public class Adult extends Person {

	String _info;

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

	public void setInfo(String info) {
		_info = info;
	}

	public String getInfo() {
		return _info;
	}

}
