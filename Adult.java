package ass1Sem2;

public class Adult extends Person {
	public boolean isChild = false;
	Person spouse;
	
	public Adult(String name, int age) {
		
		}
	
	public boolean getIsChild() {
		// TODO Auto-generated method stub
		return isChild;
	}

	@Override
	public void addFriend(String name, String friend) {
		int indexProfile = getIndexByProperty(name);
		Person profile1 = network.get(indexProfile);
		int indexFriend = getIndexByProperty(friend);
		Person profile2 = network.get(indexFriend);
		if (profile2 instanceof Child) {
			System.out.println("Sorry, you cannot be friends with a child. ");
		}
		else {
			profile1.addFriend(profile2);
			profile2.addFriend(profile1);
		}
	}
		public void addSpouse(Person profile) {
			spouse = profile;
			}
		public String getSpouseName() {
			if(spouse != null) {
			return spouse.getName();
			}else {
				return " ";
			}
		}
	public void addSpouse(String name, String partner) {
		int indexProfile = getIndexByProperty(name);
		Person profile1 = network.get(indexProfile);
		int indexPartner = getIndexByProperty(partner);
		Person profile2 = network.get(indexPartner);
		if(profile2 instanceof Adult) {
			addSpouse(profile2);
			addSpouse(profile1);
			}
		else {
			System.out.println("You can only add another Adult as a spouse.");
		}
	}
	public void printSpouse(String profile) {
		//int indexProfile = getIndexByProperty(profile);
		//Person profile1 = network.get(indexProfile);
		System.out.println("Spouse of "+getName()+ " is " + getSpouseName());
	}
}
