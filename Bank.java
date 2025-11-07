import java.util.*;
import java.io.*;

public class Bank implements HasMenu {
	private Admin admin;
	private CustomerList customers;
	public static void main(String[] args) {
		new Bank();
	}
	public Bank() {
		admin = new Admin();
		customers = new CustomerList();
		loadCustomers();
		//loadSampleCustomers();
		start();
		saveCustomers();
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
				if (admin.login()) {
					startAdmin();
				} else {
					System.out.println("Invalid login, try again\n");
				} // end if
			} else if (choice.equals("2")) {
				loginAsCustomer();
			} else {
				System.out.println("Invalid input, please try again\n");
			} // end if
		} // end while
	} // end start
	public void loadSampleCustomers() {
		customers.add(new Customer("Alice", "1111"));
		customers.add(new Customer("Bob", "2222"));
		customers.add(new Customer("Cindy", "3333"));
		customers.get(0).getChecking().setBalance(1000.0);
		customers.get(0).getSavings().setBalance(1000.0);
	} // end loadSampleCustomers
	public void loadCustomers() {
		try {
			FileInputStream inFile = new FileInputStream("customers.dat");
			ObjectInputStream input = new ObjectInputStream(inFile);
			customers = (CustomerList)input.readObject();
			input.close();
			inFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // end try
	} // end loadCustomers
	public void saveCustomers() {
		try {
			FileOutputStream outFile = new FileOutputStream("customers.dat");
			ObjectOutputStream output = new ObjectOutputStream(outFile);
			output.writeObject(customers);
			output.close();
			outFile.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} // end try
	} // end saveCustomers
	public void fullCustomerReport() {
		for (Customer customer : customers) {
			System.out.println(customer.getReport());
		} // end for
		System.out.println();
	} // end fullCustomerReport
	public void addUser() {
		Scanner input = new Scanner(System.in);
		String username = "";
		String pin = "";
		System.out.print("Name: ");
		username = input.nextLine();
		System.out.print("PIN: ");
		pin = input.nextLine();
		customers.add(new Customer(username, pin));
	} // end addUser
	public void applyInterest() {
		for (Customer customer : customers) {
			customer.getSavings().calcInterest();
			System.out.println("New balance: " + customer.getSavings().getBalanceString());
		} // end for
		System.out.println();
	} // end applyInterest
	public void loginAsCustomer() {
		Scanner input = new Scanner(System.in);
		String username = "";
		String pin = "";
		System.out.print("User name: ");
		username = input.nextLine();
		System.out.print("PIN: ");
		pin = input.nextLine();
		Customer currentCustomer = null;
		for (Customer customer : customers) {
			if (customer.login(username, pin)) {
				currentCustomer = customer;
			} // end if
		} // end for
		if (currentCustomer != null) {
			currentCustomer.start();
		} else {
			System.out.println("User not found, please double check spelling and try again\n");
		} // end if
	} // end loginAsCustomer
	public void startAdmin() {
		String choice = "";
		boolean keepGoing = true;
		while (keepGoing) {
			choice = admin.menu();
			if (choice.equals("0")) {
				keepGoing = false;
			} else if (choice.equals("1")) {
				fullCustomerReport();
			} else if (choice.equals("2")) {
				addUser();
			} else if (choice.equals("3")) {
				applyInterest();
			} else {
				System.out.println("Invalid input, please try again\n");
			} // end if
		} // end while
	} // end startAdmin
} // end Bank

class CustomerList extends ArrayList<Customer> {} // end CustomerList
