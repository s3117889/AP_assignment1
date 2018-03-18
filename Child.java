package ass1Sem2;

public class Child extends Person {
	private boolean isChild = true;
	private Person[] myParents = new Person[2];
	
	public Child(String name, int age) {
		
		}
	
	public boolean getIsChild() {
		// TODO Auto-generated method stub
		return isChild;
	}
	
	@Override
	public void addFriend(Person profile) {
		myFriends.add(profile);

}
	@Override
	public void addFriend(String name, String friend) {
		int indexProfile = getIndexByProperty(name);
		Person profile1 = network.get(indexProfile);
		int indexFriend = getIndexByProperty(friend);
		Person profile2 = network.get(indexFriend);
		if (profile2 instanceof Adult) {
			System.out.println("Sorry, you cannot be friends with an adult. ");
		}
		else if (profile2.getAge()<3) {
			System.out.println("Sorry, you cannot be friends with a baby under 2 years. ");
		}
		else if(profile1.getAge()-profile2.getAge()>3) {
			System.out.println("Sorry, you cannot be friends someone more than 3 years younger. ");
		}
		else if(profile2.getAge()-profile1.getAge()>3) {
			System.out.println("Sorry, you cannot be friends someone more than 3 years older. ");
		}
		else if (profile2 instanceof Adult) {
			System.out.println("Sorry, you cannot be friends with an adult. ");
		}
		else {
			profile1.addFriend(profile2);
			profile2.addFriend(profile1);
		}
	}
}
