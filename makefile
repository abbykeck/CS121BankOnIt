testChecking: CheckingAccount.class
	java CheckingAccount

HasMenu.class: HasMenu.java
	javac -g HasMenu.java

CheckingAccount.class: CheckingAccount.java HasMenu.class
	javac -g CheckingAccount.java

clean:
	rm *.class
