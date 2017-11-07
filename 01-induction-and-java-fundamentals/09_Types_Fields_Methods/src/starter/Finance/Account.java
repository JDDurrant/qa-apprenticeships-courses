package starter.Finance;

public class Account {
//	Field Variables
	private String holder;
	private double balance;
	private static double overdraftLimit = 500;

	private String accNo;
	private static int nextAccNo;

//	Constructors
	public Account(String name, double balance) {

		this.holder = name;
		this.balance = balance;
		this.accNo = String.format("SA-%04d", ++nextAccNo);
	}

	public Account(String name) {

		this(name, 0);
	}

//	Static Methods
	public static void listAccounts(Account[] accounts) {

		for(Account account : accounts) {
			System.out.println(account.getDetails());
		}
	}

	public static void processAccounts(Account[] accounts) {

		for(Account account : accounts) {
			account.deposit(10);
		}
	}

	public static boolean transfer(Account from, Account to, double amount) {

		boolean result = from.withdraw(amount);

		if(result) {
			to.deposit(amount);
		}

		System.out.printf("Transfer %s\n", result ? "successful" : "unsuccessful");
		return result;
	}

//	Setter Methods
	public boolean transfer(double amount, Account to) {

		return Account.transfer(this, to, amount);
	}

	public void deposit(double amount) {

		this.balance += amount;
	}

	public boolean withdraw(double amount) {

		boolean result = false;

		if(amount <= (this.balance + Account.overdraftLimit)) {
			this.balance -= amount; // According to the spec, this.balance should not change if overdraft is being used - why?
			result = true;
		}

		return result;
	}

//	Getter Methods
	public String getDetails() {

		return String.format("%s\t%s\t£%.2f", accNo, holder, balance);
	}

	public String getHolder() {
		return holder;
	}
	public double getBalance() {
		return balance;
	}
}
