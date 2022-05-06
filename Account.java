import java.util.Scanner;

public class Account {
	int balance;
	int previousTransaction;
	String accName;
	String accID;
	
	Account(String accName, String accID){
		this.accName=accName;
		this.accID=accID;
	}
	
	void deposit(int amount){
		if(amount!=0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount!=0) {
			balance = balance - amount;
			previousTransaction = -amount;
			}
	}
	
	void getPreviousTransaction() {
		if (previousTransaction >0) {
			System.out.println("Deposit" + previousTransaction);
		}
		else if(previousTransaction < 0 ) {
			System.out.println("Withdraw" + previousTransaction);
		}
		else {System.out.println("No transaction occured");}
	}
	
	void calcInterest(int year) {
		double interest = 1.82;
		double newBalance = (balance * interest * year) + balance;
		System.out.println("The current interest rate is "+ interest);
		System.out.println("The new balance affter "+ year + " years is "+ newBalance);
	}
	
	void showOption() {
		char option;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome " + accName);
		System.out.println("Your ID is: " + accID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("a. Deposit");
		System.out.println("b. Withdraw");
		System.out.println("c. Show previous transaction");
		System.out.println("d. Check current balance");
		System.out.println("e. Calculate interest");
		System.out.println("f. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option:");
			option = scanner.next().charAt(0);
			option = Character.toLowerCase(option);
			System.out.println();

			switch(option) {
			
			case 'a' :
				System.out.println();
				System.out.println("Enter deposit amount: ");
				System.out.println();
				int am = scanner.nextInt();
				deposit(am);
				System.out.println();	
				break;
			case 'b':
				System.out.println();
				System.out.println("Enter withdraw amount: ");
				System.out.println();
				int am1 = scanner.nextInt();
				withdraw(am1);
				System.out.println();
				break;
				
			case 'c':
				System.out.println();
				System.out.println("The previous transaction is: " + previousTransaction);
				System.out.println();
				break;
			case 'd':
				System.out.println();
				System.out.println("The current balance is: " + balance);
				System.out.println();
				break;
			case 'e':
				System.out.println();
				System.out.println("Enter year ");
				System.out.println();
				int year = scanner.nextInt();
				calcInterest(year);
				System.out.println();
				break;
			case 'f':
				System.out.println("---------------------------------------------");
				System.out.println();
				break;
				
			default:
				System.out.println("Invalid command");
				break;

			}
		}while(option!='f');
		System.out.println("Thank you for banking with us");
			
		scanner.close();
		
	}
	
	
	
}
