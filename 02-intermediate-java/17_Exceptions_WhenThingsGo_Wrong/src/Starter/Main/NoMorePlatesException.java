package Starter.Main;

public class NoMorePlatesException extends Exception {

	public String getMessage() {
		return "No more registration plates.";
	}
}
