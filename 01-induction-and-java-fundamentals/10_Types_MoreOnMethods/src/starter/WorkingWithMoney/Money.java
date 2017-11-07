package starter.WorkingWithMoney;

public class Money {

	private int pounds;
	private int pence;
	private boolean validMoney;

	public Money(int pennies) {
		setPence(pennies);
	}

	public String getCurrentMoney() {
		if(getValidMoney())
			return String.format("£%d.%02d", getPounds(), getPence());
		else
			return "Error";
	}

	public int getPounds() {
		return pounds;
	}

	public void setPounds(int pounds) {
		if(pounds >= 0) this.pounds = pounds;
	}

	public int getPence() {
		return pence;
	}

	public void setPence(int pence) {

//		while(pence >= 100) {
//			pounds++;
//			pence -= 100;
//		}

		if(pence >= 0 && pence < 100)
			setValidMoney();
		else
			setInvalidMoney();

		this.pence = pence;
	}

	public boolean getValidMoney() {
		return validMoney;
	}

	public void setValidMoney(boolean validMoney) {
		this.validMoney = validMoney;
	}

	public void setValidMoney() {
		setValidMoney(true);
	}

	public void setInvalidMoney() {
		setValidMoney(false);
	}
}
