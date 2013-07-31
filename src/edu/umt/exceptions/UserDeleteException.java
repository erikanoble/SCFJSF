package edu.umt.exceptions;

public class UserDeleteException extends Exception {
	public UserDeleteException() {
		super();
	}

	public UserDeleteException(String message) {
		super("The instance of deleting the user: " + message + " has failed.");
	}
}
