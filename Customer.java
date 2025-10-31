import java.util.*;
import java.io.*;

public class Customer extends User implements Serializable {
	private CheckingAccount checking;
	private SavingsAccount savings;
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		System.out.println("Hello world!");
	}
} // end Customer
