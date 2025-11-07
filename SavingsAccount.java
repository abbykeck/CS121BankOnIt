import java.util.*;
import java.io.*;

public class SavingsAccount extends CheckingAccount implements HasMenu, Serializable {
	private double interestRate;
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		SavingsAccount s = new SavingsAccount();
		s.start();
	} // end main
	public SavingsAccount() {
		super();
		interestRate = 0.05;
	} // end constructor
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
