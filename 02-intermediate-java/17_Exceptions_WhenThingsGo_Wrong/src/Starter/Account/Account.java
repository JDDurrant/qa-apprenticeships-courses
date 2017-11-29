package Starter.Account;

public class Account
{
	private double balance;
	private String holder;
	private String number;

	public double getBalance()
	{
		return balance;
	}

	public String getHolder()
	{
		return holder;
	}

	public String getNumber()
	{
		return number;
	}

	public Account(double balance, String holder, String number)
	{
		if (balance < 0) throw new IllegalArgumentException("You can't open an account with a negative balance.");

		this.balance = balance;
		this.holder = holder;
		this.number = number;
	}

	public void deposit(double amount)
	{
		if(amount < 0) throw new IllegalArgumentException("You can't deposit a negative amount.");
		balance += amount;
	}

//	public boolean withdraw(double amount) {
//		boolean result = false;
//
//		if(amount < 0) throw new IllegalArgumentException("You can't withdraw a negative amount.");
//
//		if (amount < balance) {
//			balance -= amount;
//			result = true;
//		}
//		return result;
//	}

	 public void withdraw(double amount)
	 {
		 if (amount < 0) {
			 throw new IllegalArgumentException("Can't withdraw -ve amounts");
		 }

		 if (amount > balance) {
			 throw new InsufficientFundsException(this, amount);
		 }

		 balance -= amount;
	 }

	public static void transfer(double amount, Account from, Account to)
	{
		boolean result = false;

		try {
			from.withdraw(amount);
			to.deposit(amount);

			result = true;
		}
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("You can't transfer a negative amount.");
		}
		catch (InsufficientFundsException e) {
			throw e;
		}
		finally {
			from.audit("Transfer attempt to " + to.number + ". Completion Status: " + result);
		}
	}

	public String getDetails()
	{
		return number + " " + holder + " " + balance;
	}

	public void audit(String message)
	{
		System.out.println(number + ": " + message);
	}

}
