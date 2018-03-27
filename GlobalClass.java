package AP_assignment1;

import java.util.Scanner;

/*
Title: RMIT Advanced Programming Assignment 1 
Developer(s): 
- Rudi Basiran <s3665980@student.rmit.edu.au> 
- Sherri McRae <s3117889@student.rmit.edu.au>
Date Created: 22 March 2018 
Description: GlobalClass
 */

public class GlobalClass {

	public static int menuSize = 10;
	public static int quitMenu = 0;
	public static int addPerson = 1;
	public static int findPerson = 2;
	public static int displayProfile = 3;
	public static int displayAllProfile = 4;
	public static int updateProfile = 5;
	public static int deletePerson = 6;
	public static int connectPerson = 7;
	public static int findFriends = 8;
	public static int findFamily = 9;

	public static int Friend = 0;
	public static int Spouse = 1;
	public static int Father = 2;
	public static int Mother = 3;

	public static String roleDesc[] = { "Friend", "Spouse", "Father", "Mother" };

	public static String getStringInput(String message) {
		System.out.println("");
		System.out.print(message + ": ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}

	public static int getIntegerInput(String message) {
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		int input;

		do {
			System.out.println(message);
			while (!sc.hasNextInt()) {
				sc.next();
			}
			input = sc.nextInt();
		} while (input < 0);

		return input;

	}

	public static void drawLine() {
		for (int x = 0; x < 50; x++)
			System.out.print("-");
		System.out.println("");
	}

}