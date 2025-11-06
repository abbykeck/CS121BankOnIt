import java.util.*;
import java.io.*;

public class Bank implements HasMenu {
	private Admin admin;
	private ArrayList<Customer> customers;
	public static void main(String[] args) {
		Bank b = new Bank();
		b.start();
	}
	public Bank() {
		admin = new Admin();
		customers = new ArrayList<Customer>();
	} // end constructor
	public String menu() {
		Scanner input = new Scanner(System.in);
		String choice = "";
		System.out.println("Bank Menu\n");
		System.out.println("0) Exit system");
		System.out.println("1) Login as admin");
		System.out.println("2) Login as customer\n");
		System.out.print("Action: ");
		choice = input.nextLine();
		return choice;
	} // end menu
	public void start() {
		String choice = "";
		boolean keepGoing = true;
		while (keepGoing) {
			choice = menu();
			if (choice.equals("0")) {
				keepGoing = false;
			} else if (choice.equals("1")) {
				System.out.println("Logging in as admin...");
			} else if (choice.equals("2")) {
				System.out.println("Logging in as customer...");
			} else {
				System.out.println("Invalid input, please try again");
			} // end if
		} // end while
	} // end start
} // end Bank
