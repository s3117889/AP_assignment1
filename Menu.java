package AP_assignment1;

import java.util.Scanner;

public class Menu {
	int _choice;
	Boolean _quit = false;

	public void displayMenu() {
		System.out.println("Menu Options:");
		System.out.println("1. Add Person");
		System.out.println("2. Find Person");
		System.out.println("3. Display Profile");
		System.out.println("4. Update Profile");
		System.out.println("5. Delete Person");
		System.out.println("6. Connect Person");
		System.out.println("7. Find Friends");
		System.out.println("8. Find Family");
		System.out.println("9. Update Person");
		System.out.println("0. Quit");
		System.out.print("Enter Option: ");

	}

	public int getChoice() {
		return _choice;
	}

	public Boolean notExit() {
		return _quit;
	}

	public void menuSelect() {
		Scanner input = new Scanner(System.in);
		_choice = input.nextInt();

		switch (_choice) {
		case 1:

		case 2:

		case 3:

		case 4:

		case 5:

		case 6:

		case 7:

		case 8:

		case 9:
			_quit = false;
			break;
		case 0:
			_quit = true;
			break;
		default:
			_quit = false;
			break;
		}

	}
}
