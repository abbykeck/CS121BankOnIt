import java.util.*;

public class SavingsAccount extends CheckingAccount implements HasMenu {
	private double interestRate;
	public static void main(String[] args) {
		SavingsAccount s = new SavingsAccount();
		s.start();
	} // end main
	public void calcInterest() {
		double interest = super.getBalance() * interestRate;
		super.setBalance(super.getBalance() + interest);
	} // end calcInterest
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	} // end setInterestRate
	public double getInterestRate() {
		return interestRate;
	} // end getInterestRate
} // end SavingsAccount
