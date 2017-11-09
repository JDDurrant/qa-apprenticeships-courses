package Starter.Security;

import static org.junit.Assert.*;

import org.junit.Test;

public class SecurityTester {

	public void testLogon(String user, String pass, boolean expected) {

		Security security = new Security();

		SecurityStatus status = security.logon(user, pass);

		boolean actual = status.isSuccess();

		assertEquals(status.getErrMessage(), expected, actual);
	}

	@Test
	public void testLogonEmptyUserId() {
		testLogon("", "Fred34", false);
	}

	@Test
	public void testLogonNullUserId() {
		testLogon(null, "Fred34", false);
	}

	@Test
	public void testLogonUserIdAllSpaces() {
		testLogon(" ", "Fred34", false);
	}

	@Test
	public void testLogonEmptyPassword() {
		testLogon("Fred", "", false);
	}

	@Test
	public void testLogonNullPassword() {
		testLogon("Fred", null, false);
	}

	@Test
	public void testLogonPasswordAllSpaces() {
		testLogon("Fred", " ", false);
	}

	@Test
	public void testLogonPasswordTooShort() {
		testLogon("Fred", "Fred34", false);
	}

	@Test
	public void testLogonPasswordNoUpper() {
		testLogon("Fred", "freddie34", false);
	}

	@Test
	public void testLogonPasswordNoDigit() {
		testLogon("Fred", "Frederic", false);
	}

	@Test
	public void testLogonGoodCombination() {
		testLogon("Fred", "Frederic34", true);
	}
}
