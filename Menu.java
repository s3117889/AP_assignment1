package AP_assignment1;

import java.util.Scanner;

public class Menu {
	private int _choice;
	private Boolean _quit;

	private String[] _menuItems = new String[GlobalClass.menuSize];

	public Menu() {
		_choice = 1;
		_quit = false;
		_menuItems[GlobalClass.quitMenu] = "Quit";
		_menuItems[GlobalClass.addPerson] = "Add Person";
		_menuItems[GlobalClass.findPerson] = "Find Person";
		_menuItems[GlobalClass.displayProfile] = "Display Single Profile";
		_menuItems[GlobalClass.displayAllProfile] = "Display All Profile(s)";
		_menuItems[GlobalClass.updateProfile] = "Update Profile";
		_menuItems[GlobalClass.deletePerson] = "Delete Person";
		_menuItems[GlobalClass.connectPerson] = "Connect Person";
		_menuItems[GlobalClass.findFriends] = "Find Friends";
		_menuItems[GlobalClass.findFamily] = "Find Family";

	}

	public int getOption() {
		return _choice;
	}

	public void displayMenu() {

		System.out.println("MiniNet Menu");

		GlobalClass.drawLine();

		for (int i = 1; i < _menuItems.length; i++)
			System.out.println((i) + ": " + _menuItems[i]);

		System.out.println((0) + ": " + _menuItems[0]);

		System.out.println("");
		System.out.print("Enter Option: ");
		Scanner input = new Scanner(System.in);
		_choice = input.nextInt();

		if (_choice == 0)
			_quit = true;
		else if (_choice < 0 || _choice > _menuItems.length)
			System.out.println("Invalid Option");

	}

	public Boolean exitMenu() {
		return _quit;
	}

}
