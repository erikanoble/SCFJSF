package edu.umt.exceptions;

public class UsertypeDeleteException extends Exception {
	public UsertypeDeleteException(){
		super();
	}
	
	public UsertypeDeleteException(String message){
		super("The instance of deleting the usertype: " + message + " has failed.");
	}
}
