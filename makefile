CheckingAccount.class: CheckingAccount.java HasMenu.class
	javac -g CheckingAccount.java

SavingsAccount.class: SavingsAccount.java CheckingAccount.java
	javac -g SavingsAccount.java

HasMenu.class: HasMenu.java
	javac -g HasMenu.java

testChecking: CheckingAccount.class
	java CheckingAccount

testSavings: SavingsAccount.class
	java SavingsAccount

clean:
	rm *.class
