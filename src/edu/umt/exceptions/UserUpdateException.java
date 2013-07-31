package edu.umt.exceptions;

public class UserUpdateException extends Exception {
	public UserUpdateException() {
		super();
	}

	public UserUpdateException(String message) {
		super("The instance of updating the user: " + message + " has failed");
	}
}
