package edu.umt.exceptions;

public class UserDetailsException extends Exception{
	public UserDetailsException(){
		super();
	}
	
	public UserDetailsException(String message){
		super("The instance of viewing the user details: "+message+" has failed.");
	}
}
