package edu.umt.exceptions;

public class ApplicationDeleteException extends Exception {
	public ApplicationDeleteException() {
		super();
	}

	public ApplicationDeleteException(String message) {
		super("The instance of deleting the application: " + message
				+ " has failed.");
	}
}
