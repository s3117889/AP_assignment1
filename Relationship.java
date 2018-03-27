package AP_assignment1;

public class Relationship {
	private Person _personA;
	private int _conn;
	private Person _personB;

	public Relationship(Person a, int conn, Person b) {
		_personA = a;
		_conn = conn;
		_personB = b;
	}

	public Person getPersonA() {
		return _personA;
	}

	public Person getPersonB() {
		return _personB;
	}

	public int getConn() {
		return _conn;
	}
}
