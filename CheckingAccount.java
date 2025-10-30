import java.util.*;

public class CheckingAccount implements HasMenu {
	private double balance;
	public static void main(String[] args) {
		//System.out.println("Hello world!");
		CheckingAccount c = new CheckingAccount();
		c.start();
	} // end main
	public CheckingAccount() {
		balance = 0.0;
	} // end no-argument constructor
	public CheckingAccount(double balance) {
		this.balance = balance;
	} // end single-argument constructor
	public void start() {
		String choice = "";
		boolean keepGoing = true;
		while (keepGoing) {
			choice = menu();
			if (choice.equals("0")) {
				keepGoing = false;
			} else if (choice.equals("1")) {
				checkBalance();
			} else if (choice.equals("2")) {
				makeDeposit();
			} else if (choice.equals("3")) {
				makeWithdrawal();
			} else {
				System.out.println("Invalid input, please try again");
			} // end if
		} // end while
	} // end start
	public String menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("Account menu\n");
		System.out.println("0) quit");
		System.out.println("1) check balance");
		System.out.println("2) make a deposit");
		System.out.println("3) make a withdrawal\n");
		System.out.print("Please enter 0-3: ");
		String userInput = input.nextLine();
		return userInput;
	} // end menu
	public double getBalance() {
		return balance;
	} // end balance
	public String getBalanceString() {
		return String.format("$%.2f", balance);
	} // end getBalanceString
	public void setBalance(double balance) {
		this.balance = balance;
	} // end setBalance
	public void checkBalance() {
		System.out.println("Checking balance...");
		System.out.println("Current balance: " + getBalanceString() + "\n");
	} // end checkBalance
	private double getDouble() {
		try {
			Scanner input = new Scanner(System.in);
			String stringInput = input.nextLine();
			double userInput = Double.parseDouble(stringInput);
			return userInput;
		} catch (Exception e) {
			System.out.println("Invalid input, please try again");
			return 0.0;
		}
	} // end getDouble
	public void makeDeposit() {
		System.out.println("Making a deposit...");
		System.out.print("How much to deposit? ");
		balance += getDouble();
		System.out.println("New balance: " + getBalanceString() + "\n");
	} // end makeDeposit
	public void makeWithdrawal() {
		System.out.println("Making a withdrawal...");
		System.out.println("How much to withdraw?");
		balance -= getDouble();
		System.out.println("New balance: " + getBalanceString() + "\n");
	} // end makeWithdrawal
} // end CheckingAccount
