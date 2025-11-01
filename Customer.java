import java.util.*;
import java.io.*;

public class Customer extends User implements Serializable {
	private CheckingAccount checking;
	private SavingsAccount savings;
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		Customer a = new Customer();
		a.setUserName("Alice");
		a.setPIN("1111");
		a.start();
	} // end main
	public Customer() {
		checking = new CheckingAccount();
		savings = new SavingsAccount();
	} // end constructor
	public void start() {
		if (super.login()) {
			System.out.println("Login Successful\n");
			String choice = "";
			boolean keepGoing = true;
			while (keepGoing) {
				choice = menu();
				if (choice.equals("0")) {
					keepGoing = false;
				} else if (choice.equals("1")) {
					System.out.println("Checking Account\n");
					checking.start();
				} else if (choice.equals("2")) {
					System.out.println("Savings Account\n");
					savings.start();
				} else if (choice.equals("3")) {
					System.out.println("Change your PIN\n");
					changePIN();
				} else {
					System.out.println("Invalid input, please try again");
				} // end if
				System.out.println();
			} // end while
		} // end if
	} // end start
	public String menu() {
		Scanner input = new Scanner(System.in);
		String choice = "";
		System.out.println("Customer Menu\n");
		System.out.println("0) Exit");
		System.out.println("1) Manage Checking Account");
		System.out.println("2) Manage Savings Account");
		System.out.println("3) change PIN\n");
		System.out.print("Action (0-3): ");
		choice = input.nextLine();
		return choice;
	} // end menu
	public void changePIN() {
		Scanner input = new Scanner(System.in);
		String newPIN = "";
		System.out.print("What would you like to change your PIN to? ");
		newPIN = input.nextLine();
		super.setPIN(newPIN);
	} // end changePIN
	public String getReport() {
		String report = "User name: " + super.getUserName() + "\n";
		report += "Balance of Checking Account: " + checking.getBalanceString() + "\n";
		report += "Balance of Savings Account: " + savings.getBalanceString();
		return report;
	} // end getReport
} // end Customer
