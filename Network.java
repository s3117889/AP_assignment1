package ass1Sem2;

import java.util.ArrayList;

public class Network {
	ArrayList<Person> network = new ArrayList<>();
	
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
	return result;
}
public void createProfile(String name, int age) {
		
		if(age<17) {
			Person profile = new Child(name,age);
			network.add(profile);
			System.out.println("Profile " + profile.getName()+ " was added to the network.");
		}
		else {
			Person profile = new Adult(name,age);
			network.add(profile);
			System.out.println("Profile " + profile.getName()+ " was added to the network.");
		}
}
public void display() {
	
	for(Person ob: network) {
		System.out.println("Profile");
		System.out.println("Name: "+ob.getName());
		System.out.println("Age: "+ob.getAge());
		//for(Person i: i.spouse) {
		//if(ob instanceof Adult) {
			//System.out.println("Spouse: "+ob.getSpouseName());
		//}
		System.out.print("Friends list: ");
		for(Person i: ob.myFriends) {
			System.out.print(i.getName() + " ");
		}
		System.out.println();
		System.out.println("__________________________________");
	}
}
public void displayOneProfile(String name) {
	int index = getIndexByProperty(name);
	Person profile = network.get(index);
	System.out.println("Profile");
	System.out.println("Name: "+profile.getName());
	System.out.println("Age: "+profile.getAge());
	System.out.println("Spouse: "+profile.getSpouseName());
	System.out.print("Friends list: ");
	for(Person i: profile.myFriends) {
		System.out.print(i.getName() + " ");
		}
	System.out.println();
	System.out.println("__________________________________");
	
}

}
