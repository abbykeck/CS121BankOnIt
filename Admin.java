import java.util.*;

public class Admin extends User implements HasMenu {
	public static void main(String[] args) {
		Admin a = new Admin();
		if (a.login()) {
			System.out.println("Login successful");
			String m = a.menu();
			System.out.println("Menu choice: " + m + "\n");
			System.out.println(a.getReport());
		} else {
			System.out.println("Login unsuccessful, please try again");
		} // end if
	} // end main
	public Admin() {
		super.setUserName("admin");
		super.setPIN("0000");
	} // end constructor
	public String menu() {
		Scanner input = new Scanner(System.in);
		String choice = "";
		System.out.println("Admin Menu\n");
		System.out.println("0) Exit this menu");
		System.out.println("1) Full customer report");
		System.out.println("2) Add user");
		System.out.println("3) Apply interest to savings accounts\n");
		System.out.print("Action: ");
		choice = input.nextLine();
		return choice;
	} // end menu
	public void start() {} // end start
	public String getReport() {
		String report = "";
		report += "Admin report\n";
		report += "Username: " + super.getUserName() + ", PIN: " + super.getPIN();
		return report;
	} // end getReport
} // end Admin
