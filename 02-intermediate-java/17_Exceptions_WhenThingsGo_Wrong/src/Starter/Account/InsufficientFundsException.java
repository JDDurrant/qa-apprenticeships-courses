package Starter.Account;

public class InsufficientFundsException extends RuntimeException
{
	private Account account;
	private double amount;

	public InsufficientFundsException(Account account, double amount)
	{
		this.account = account;
		this.amount = amount;
	}

	public String getMessage() {

		return String.format("Can't withdraw £%.02f from account with only £%.02f", amount, account.getBalance());
	}
}
