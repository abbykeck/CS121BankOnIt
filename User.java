import java.util.*;
import java.io.*;

public abstract class User implements HasMenu, Serializable {
	private String userName;
	private String PIN;
	private static final long serialVersionUID = 1L;
	public boolean login() {
		Scanner input = new Scanner(System.in);
		String inputName = "";
		String inputPIN = "";
		System.out.print("User name: ");
		inputName = input.nextLine();
		System.out.print("PIN: ");
		inputPIN = input.nextLine();
		if (userName.equals(inputName) && PIN.equals(inputPIN)) {
			return true;
		} else {
			return false;
		} // end if
	} // end null parameter login
	public boolean login(String userName, String PIN) {
		if (this.userName.equals(userName) && this.PIN.equals(PIN)) {
			return true;
		} else {
			return false;
		} // end if
	} // end two parameter login
	public void setUserName(String userName) {
		this.userName = userName;
	} // end setUserName
	public String getUserName() {
		return userName;
	} // end getUserName
	public void setPIN(String PIN) {
		this.PIN = PIN;
	} // end setPIN
	public String getPIN() {
		return PIN;
	} // end getPIN
	public abstract String getReport();
} // end User
