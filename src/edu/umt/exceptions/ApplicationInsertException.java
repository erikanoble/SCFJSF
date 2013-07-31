package edu.umt.exceptions;


public class ApplicationInsertException extends Exception{
	public ApplicationInsertException(){
		super();
	}
	
	public ApplicationInsertException(String message){
		super("The instance of this new application: " + message + " has failed.");
	}
}