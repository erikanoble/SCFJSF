package edu.umt.exceptions;

public class UsertypeDetailsException extends Exception {
	public UsertypeDetailsException() {
		super();
	}

	public UsertypeDetailsException(String message) {
		super("The instance of viewing the usertype details: "+message+" has failed.");
	}
}
