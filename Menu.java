package AP_assignment1;

import java.util.Scanner;

public class Menu {
	private int _choice;
	private Boolean _quit;
	private String[] _menuItems = new String[10];

	public Menu() {
		_choice = 1;
		_quit = false;
		_menuItems[0] = "Quit";
		_menuItems[1] = "Add Person";
		_menuItems[2] = "Find Person";
		_menuItems[3] = "Display Single Profile";
		_menuItems[4] = "Display All Profile(s)";
		_menuItems[5] = "Update Profile";
		_menuItems[6] = "Delete Person";
		_menuItems[7] = "Connect Person";
		_menuItems[8] = "Find Friends";
		_menuItems[9] = "Find Family";

	}

	public String getOption() {
		return _menuItems[_choice];
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
