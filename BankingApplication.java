import java.util.Scanner;

public class BankingApplication {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter your Name:");
		String name = sc1.nextLine();
		System.out.println("Enter Customer Id:");
		int custId = sc1.nextInt();

		BankAccount b1 = new BankAccount(name, custId);
		b1.showMenu();
		sc1.close();
	}
}

class BankAccount {
	int balance;
	int previousTransaction;
	String customerName;
	int customerId;

	BankAccount(String cname, int cid){
		customerName = cname;
		customerId = cid;
	}

	void deposit(int amount) {
		if (amount != 0) {
			balance += amount;
			previousTransaction = amount;
		}
	}

	void withdraw(int amount) {
		if (amount != 0) {
			balance -= amount;
			previousTransaction = -amount;
		}
	}

	void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Deposit: " + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdraw: " + Math.abs(previousTransaction));
		} else {
			System.out.println("No Transaction");
		}
	}

	void showMenu(){
		char option = '\0';
		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome " + customerName);
		System.out.println("Your ID: " + customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Check Previous Transaction");
		System.out.println("E. Exit");

		do {
			System.out.println("=========================");
			System.out.println("Enter your Option");
			System.out.println("=========================");
			option = sc.next().charAt(0);
			option = Character.toUpperCase(option);
			System.out.println("\n");

			switch (option) {
				case 'A' -> {
					System.out.println("--------------------------");
					System.out.println("Balance: " + balance);
					System.out.println("--------------------------");
					System.out.println("\n");
				}
				case 'B' -> {
					System.out.println("--------------------------");
					System.out.println("Enter Amount to Deposit:");
					System.out.println("--------------------------");
					int amount = sc.nextInt();
					deposit(amount);
					System.out.println("");
				}
				case 'C' -> {
					System.out.println("--------------------------");
					System.out.println("Enter Amount to be Withdraw:");
					System.out.println("--------------------------");
					int amount = sc.nextInt();
					withdraw(amount);
					System.out.println("\n");
				}
				case 'D' -> {
					System.out.println("--------------------------");
					getPreviousTransaction();
					System.out.println("--------------------------");
					System.out.println("\n");
				}
				case 'E' -> {
					System.out.println("**************************");
				}
				default -> System.out.println("Invalid Option!!! Please enter again.");
			}

		} while (option != 'E');
		System.out.println("Thankyou " + customerName + " for using our services");
		sc.close();
	}
}
