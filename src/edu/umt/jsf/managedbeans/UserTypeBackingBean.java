package edu.umt.jsf.managedbeans;

import edu.umt.db.*;
import java.util.List;

public class UserTypeBackingBean {
	private List<UserType> userTypes;
	private UserType userType;
	private String description;
	
	
	public List<UserType> getUserTypes() {
		return DatabaseManager.getUserTypes();
	}
	public void setUserTypes(List<UserType> userTypes) {
		this.userTypes = userTypes;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String newUserTypeAction(){
		UserType ut = new UserType();
		ut.setDescription(this.getDescription());
		try{
			DatabaseManager.insertUsertype(ut);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "ok";
	}
	
}
