package ass1Sem2;
import java.util.Scanner;
public class Menu {
	
	public Menu() {
			
	}
	Scanner input = new Scanner(System.in);
	Network openNetwork = new Network();
	
	public void displayMenu() {
		System.out.println("Menu Options");
		System.out.println("1. Create profile");
		System.out.println("2. Add Friends");
		System.out.println("3. Add Spouse");
		System.out.println("4. Print all profiles");
		System.out.println("5. Print one profile");
		System.out.println("Enter 0 to quit");
		menuSelect();
	}
		
		public void menuSelect() {
			System.out.println("Enter choice");
			int choice = input.nextInt();
			String blank = input.nextLine();
				if (choice == 1) {
					int age = 0;
					System.out.println("Enter your name and age. (hit return after each entry) ");
					String name = input.nextLine();
					try {
					age = Integer.parseInt(input.nextLine());
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
					System.out.println("name entered: " + name + " age entered: "+ age);
					openNetwork.createProfile(name, age);
					openNetwork.display();
					displayMenu();
				}
				else if(choice == 2) {
					System.out.println("Enter your name and your friend's (hit return after each entry) ");
					//String[] parameters = input.nextLine().split(" ");
					String yourName = input.nextLine();
					String friendsName = input.nextLine();
					System.out.println("your name is " +yourName+ " and your friend's name is "+friendsName);
					int currentIndex = openNetwork.getIndexByProperty(yourName);
					if (openNetwork[currentIndex].getIsChild() == true) {
					openNetwork.addFriend(yourName, friendsName);
					}
				openNetwork.display();
				displayMenu();
				}
				else if (choice == 4) {
				openNetwork.display();
				displayMenu();
				}else {
					System.out.println("Methods not completed");
					displayMenu();
		    }
			
	
	}
}
	
	
