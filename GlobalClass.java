package AP_assignment1;

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

	public static void drawLine() {
		for (int x = 0; x < 50; x++)
			System.out.print("-");
		System.out.println("");
	}

}