package AP_assignment1;

public class Relationship {
	private Person _main;
	private String _conn;
	private Person _ally;

	public Relationship(Person primary, String conn, Person secondary) {
		_main = primary;
		_conn = conn;
		_ally = secondary;

	}

	public Person getMain() {
		return _main;
	}

	public Person getAlly() {
		return _ally;
	}

	public String getConn() {
		return _conn;
	}

}
