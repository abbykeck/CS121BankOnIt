import java.util.*;

public class SavingsAccount extends CheckingAccount implements HasMenu {
	private double interestRate;
	public static void main(String[] args) {
		System.out.println("Hello world!");
	} // end main
	public void calcInterest() {
		double interest = super.getBalance() * interestRate;
		super.setBalance(super.getBalance() + interest);
	}
} // end SavingsAccount
