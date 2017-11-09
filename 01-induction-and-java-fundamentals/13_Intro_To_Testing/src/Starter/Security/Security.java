package Starter.Security;

public class Security {

	SecurityStatus status;

	// returns a 'SecurityStatus' object comprising a
	// boolean representing success and a String errorMessage.
	public SecurityStatus logon(String userId, String password) {

		status = new SecurityStatus();

		// validation will happen here
		if(!checkString(userId)) {
			status.setErrMessage("userId may not be null or empty.");
		} else if(!checkString(password)) {
			status.setErrMessage("password may not be null or empty.");
		} else if(!validatePassword(password)) {
			status.setErrMessage("Password must be 8 characters or longer, with at least one number and one capital letter.");
		} else {
			status.setSuccess();
		}

		return status;
	}

	// helper method here to check password contents
	private boolean checkString(String str) {
//		Check a string to ensure it isn't empty
		if(str == null || str.trim().equals("")) {
			return false;
		}

		return true;
	}

	private boolean validatePassword(String password) {

		boolean contains8Chars = false;
		boolean containsCapitals = false;
		boolean containsNumbers = false;

		if(password.length() >= 8) {
			contains8Chars = true;
		}

		for(Character c : password.toCharArray()) {
			if(Character.isUpperCase(c)) {
				containsCapitals = true;
				break;
			}
		}

		for(Character c : password.toCharArray()) {
			if(Character.isDigit(c)) {
				containsNumbers = true;
				break;
			}
		}

		if(contains8Chars && containsCapitals && containsNumbers)
			return true;

		return false;
	}
}
