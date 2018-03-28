package AP_assignment1;

/*
Title: RMIT Advanced Programming Assignment 1 
Developer(s): 
- Rudi Basiran <s3665980@student.rmit.edu.au> 
- Sherri McRae <s3117889@student.rmit.edu.au>
Date Created: 27 March 2018 
Description: Relationship class 
Notes: How Person A is connected to Person B
 */

public class Relationship {
	private Person _personA;
	private int _connection;
	private Person _personB;

	public Relationship(Person a, int conn, Person b) {
		_personA = a;
		_connection = conn;
		_personB = b;
	}

	public Person getPersonA() {
		return _personA;
	}

	public Person getPersonB() {
		return _personB;
	}

	public int getConn() {
		return _connection;
	}
}
