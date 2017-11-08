package starter.WorkingWithMoney;

public class Money {
//	instance variables
	private int pounds;
	private int pence;

//	constructor methods
	public Money(int pounds, int pennies) {
		setPounds(pounds);
		setPence(pennies);
	}

	public Money(int pennies) {
		this(0, pennies);
	}

//	custom methods
	public boolean testValidMoney() {

		if(pounds >= 0 && pence >= 0)
			return true;
		else
			return false;
	}

//	setter methods
	public void addPennies(int amt) {

		Money money = new Money(amt);

		if(testValidMoney() && money.testValidMoney())
			setPence(getPence() + amt);
	}

	public void addPounds(int amt) {

		Money money = new Money(amt, 0);

		if(testValidMoney() && money.testValidMoney())
			setPounds(getPounds() + amt);
	}

	public void setPence(int pence) {

		while(pence >= 100) {
			pounds++;
			pence -= 100;
		}

		this.pence = pence;
	}

	public void setPounds(int pounds) {
		if(pounds >= 0) this.pounds = pounds;
	}

	//	getter methods
	public String getCurrentMoney() {
		if(testValidMoney())
			return String.format("£%d.%02d", getPounds(), getPence());
		else
			return "Error";
	}

	public int getPence() {
		return pence;
	}

	public int getPounds() {
		return pounds;
	}
}
