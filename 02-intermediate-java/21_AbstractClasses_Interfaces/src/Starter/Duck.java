package Starter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Duck extends Bird implements Insurable {

	public Duck(String name) {
		super(name);
	}

	@Override
	public String getPremium() {
		return String.format("%s: No premium", getName());
	}

	@Override
	public String expires() {

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		return String.format("%s: expires %s", getName(), format.format(date));
	}
}
