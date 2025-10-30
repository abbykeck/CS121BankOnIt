# Algorithm for Bank On It project
## Mermaid diagram
```mermaid
classDiagram
class HasMenu["HasMenu (interface)"] {
    + String menu()
    + void start()
}
class CheckingAccount {
    - double balance
    + CheckingAccount()
    + CheckingAccount(double balance)
    + void main()
    + String menu()
    + void start()
    + double getBalance()
    + String getBalanceString()
    + void setBalance(double balance)
    + void checkBalance()
    - double getDouble()
    + void makeDeposit()
    + void makeWithdrawal()
}
class SavingsAccount {
    - double interestRate
    + main(*)
    + void calcInterest()
    + void setInterestRate()
    + void getInterestRate()
}
class User["User (abstract)"] {
    - String userName
    - String PIN
    + boolean login()
    + boolean login(String userName, String PIN)
    + void setUserName(String userName)
    + String getUserName()
    + void setPIN(String PIN)
    + String getPIN()
    + abstract String getReport()
}
class Customer {
    - CheckingAccount checking
    - SavingsAccount savings
    + void main()
    + Customer()
    + void start()
    + String menu()
    + void changePIN()
    + String getReport()
}
CheckingAccount <|-- SavingsAccount
HasMenu <.. CheckingAccount
HasMenu <.. User
User <|-- Customer
```
## Algorithm for CheckingAccount
### CheckingAccount()
1. set balance to 0.0
### CheckingAccount(double balance)
1. set this.balance to balance
### void main()
1. start();
### void start()
1. String choice = "";
1. boolean keepGoing = true;
1. while (keepGoing)
	1. choice = menu();
	1. if (choice.equals("0"))
		1. keepGoing = false;
	1. else if (choice.equals("1"))
		1. print "Checking balance..."
		1. checkBalance();
	1. else if (choice.equals("2"))
		1. print "Making a deposit..."
		1. print "How much to deposit?"
		1. setBalance(balance + getDouble());
		