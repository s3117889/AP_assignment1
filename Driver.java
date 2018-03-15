package ass1Sem2;
import java.util.ArrayList;


public class Driver {
	ArrayList<Person> network = new ArrayList<>();
	int index;
	
	public void addProfile(String name, int age) {
		if(age<16) {
			Person profile = new Person(name, age);
			network.add(profile);
			System.out.println("Profile " + profile.name + " was added to the network.");
		}
		else { 
		Person profile = new Person(name, age);
		network.add(profile);
		System.out.println("Profile " + profile.name + " was added to the network.");
		}
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
       return result;
    }
		
	
	public void display() {
		
		for(Person ob: network) {
			System.out.println("Profile");
			System.out.println("Name: "+ob.name);
			System.out.println("Age: "+ob.age);
			System.out.println("Spouse: "+ob.getSpouseName());
			System.out.print("Friends list: ");
			for(Person i: ob.myFriends) {
				System.out.print(i.name + " ");
			}
			System.out.println();
			System.out.println("__________________________________");
		}
	}
	public void displayOneProfile(String name) {
		int index = getIndexByProperty(name);
		Person profile = network.get(index);
		System.out.println("Profile");
		System.out.println("Name: "+profile.name);
		System.out.println("Age: "+profile.age);
		System.out.println("Spouse: "+profile.getSpouseName());
		System.out.print("Friends list: ");
		for(Person i: profile.myFriends) {
			System.out.print(i.name + " ");
			}
		System.out.println();
		System.out.println("__________________________________");
		
	}
	public void addFriend(String name, String friend) {
		int indexProfile = getIndexByProperty(name);
		Person profile1 = network.get(indexProfile);
		int indexFriend = getIndexByProperty(friend);
		Person profile2 = network.get(indexFriend);
		profile1.addFriend(profile2);
		profile2.addFriend(profile1);
		
		
	}
	public void addSpouse(String name, String partner) {
		int indexProfile = getIndexByProperty(name);
		Person profile1 = network.get(indexProfile);
		int indexPartner = getIndexByProperty(partner);
		Person profile2 = network.get(indexPartner);
		profile1.addSpouse(profile2);
		profile2.addSpouse(profile1);
	}
	public void printSpouse(String profile) {
		int indexProfile = getIndexByProperty(profile);
		Person profile1 = network.get(indexProfile);
		System.out.println("Spouse of "+profile1.name+ " is " + profile1.getSpouseName());
	}
}
