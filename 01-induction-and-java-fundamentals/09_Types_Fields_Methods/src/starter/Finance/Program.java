package starter.Finance;


public class Program {

	public static void main(String[] args) {
//		Challenge 1
		Account[] accounts = {
			new Account("Fred", 100),
			new Account("Susy")
		};

		Account.processAccounts(accounts);

		Account.listAccounts(accounts);

		System.out.println();

//		Challenge 2
		String[] names = {"Ann", "Anne", "Annie", "Anneka", "Annabel"};
		Account[] studentAccounts = new Account[names.length];

		for (int i = 0; i < studentAccounts.length; i++) {
			double balance = Math.round(Math.random() * 100 + 1);
			studentAccounts[i] = new Account(names[i], balance);
		}

		Account.listAccounts(studentAccounts);

		System.out.println();

		for (int i = 0; i < studentAccounts.length; i++) {
			Account
				from = studentAccounts[i],
				to = studentAccounts[0];
			double amount = from.getHolder().length();

			if(i < studentAccounts.length - 1) to = studentAccounts[i + 1];

			Account.transfer(from, to, amount);
		}

		System.out.println();
		Account.listAccounts(studentAccounts);
	} // main(String[] args)
}
