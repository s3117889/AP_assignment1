package ass1Sem2;

import java.util.ArrayList;

public abstract class Person {
	private String name;
	private int age;
	//ArrayList<Person> network = new ArrayList<>();
	ArrayList<Person> myFriends = new ArrayList<>();
	//trouble shooting add spouse
	//private Person spouse;
	public Person() {
		
	}
	
	//public Person(String name, int age) {
		//this.name = name;
		//this.age = age;
	//}
	
	//}
	//public boolean getIsChild() {
		//return isChild;
		
	//}
		
	public String getName() {
	 return name;
}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	
	public void addFriend(Person profile) {
		myFriends.add(profile);
	}
	//trouble shooting addSpouse
	public void addSpouse() {
		
	}
		//spouse = profile;
		//}
	//public String getSpouseName() {
		//if(spouse != null) {
		//return spouse.getName();
		//}else {
			//return " ";
		//}
	//}
	public void addFriend(String name, String friend) {
		
	}
	public int getIndexByProperty(String name) {
		int result = 0;
        for (int i = 0; i<network.size(); i++) {
            if (network.get(i).getName().equals(name)) {
                result +=i;
            }
            else {
            	 result += 0;
            }
        }


		//int indexProfile = getIndexByProperty(name);
		//Person profile1 = network.get(indexProfile);
		//int indexFriend = getIndexByProperty(friend);
		//Person profile2 = network.get(indexFriend);
		//profile1.addFriend(profile2);
		//profile2.addFriend(profile1);
	//}
	//public void addSpouse(Person profile) {
		//spouse = profile;
		
	//}
	//public String getSpouseName() {
		//if(spouse != null) {
		//return spouse.name;
		//}else {
			//return " ";
		//}
	//}
	

	
}
