package ass1Sem2;

import java.util.ArrayList;
public class Person {
	String name;
	int age;
	ArrayList<Person> myFriends = new ArrayList<>();
	Person spouse;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
		
	public String getName() {
	 return name;
}
	public int getAge() {
		return age;
	}
	public void addFriend(Person profile) {
		myFriends.add(profile);
	}
	public void addSpouse(Person profile) {
		spouse = profile;
		
	}
	public String getSpouseName() {
		if(spouse != null) {
		return spouse.name;
		}else {
			return "none";
		}
	}
	
	
	
}
