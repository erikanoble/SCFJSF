package edu.umt.exceptions;

public class UserInsertException extends Exception {
	public UserInsertException() {
		super();
	}

	public UserInsertException(String message) {
		super("The instance of the new user: " + message + " has failed.");
	}
}
