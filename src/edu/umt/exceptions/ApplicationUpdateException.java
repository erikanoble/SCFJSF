package edu.umt.exceptions;

public class ApplicationUpdateException extends Exception {
	public ApplicationUpdateException() {
		super();
	}

	public ApplicationUpdateException(String message) {
		super("The instance of updating the application: " + message
				+ " has failed.");
	}
}
