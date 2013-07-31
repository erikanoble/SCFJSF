package edu.umt.exceptions;

//example of custom exception, may use in program

public class ApplicationDetailsException extends Exception {
	public ApplicationDetailsException() {
		super();
	}

	public ApplicationDetailsException(String message) {
		super("The instance of viewing the application details: "
				+ message + " has failed.");

	}
}
