package AP_assignment1;

import java.util.Scanner;

public class Menu {
	private int _choice;
	private Boolean _quit;

	final int menuSize = 10;
	final int quitMenu = 0;
	final int addPerson = 1;
	final int findPerson = 2;
	final int displayProfile = 3;
	final int displayAllProfile = 4;
	final int updateProfile = 5;
	final int deletePerson = 6;
	final int connectPerson = 7;
	final int findFriends = 8;
	final int findFamily = 9;

	private String[] _menuItems = new String[menuSize];

	public Menu() {
		_choice = 1;
		_quit = false;
		_menuItems[quitMenu] = "Quit";
		_menuItems[addPerson] = "Add Person";
		_menuItems[findPerson] = "Find Person";
		_menuItems[displayProfile] = "Display Single Profile";
		_menuItems[displayAllProfile] = "Display All Profile(s)";
		_menuItems[updateProfile] = "Update Profile";
		_menuItems[deletePerson] = "Delete Person";
		_menuItems[connectPerson] = "Connect Person";
		_menuItems[findFriends] = "Find Friends";
		_menuItems[findFamily] = "Find Family";

	}

	public int getOption() {
		return _choice;
	}

	public void displayMenu() {

		System.out.println("MiniNet Menu");

		drawLine();

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

	public Boolean Exit() {
		return _quit;
	}

	public void drawLine() {
		for (int x = 0; x < 50; x++)
			System.out.print("-");
		System.out.println("");
	}

}
