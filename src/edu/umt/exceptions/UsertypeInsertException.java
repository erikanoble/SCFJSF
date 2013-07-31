package edu.umt.exceptions;

public class UsertypeInsertException extends Exception {
	public UsertypeInsertException(){
		super();
	}
	
	public UsertypeInsertException(String message){
		super("The instance of this new usertype: " + message + " has failed.");
	}
}
