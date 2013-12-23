package edu.umt.jsf.managedbeans;

import edu.umt.db.*;
import edu.umt.exceptions.*;

import java.util.List;

@SuppressWarnings("FieldCanBeLocal")
public class UserTypeBackingBean extends SCFBackingBean{
	private List<UserType> userTypes;
	private UserType userType;
	private String description;

	private UserType selectedUserType;
	
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

	public String newUserTypeAction() throws UsertypeInsertException {
		UserType ut = new UserType();
		ut.setDescription(this.getDescription());

		DatabaseManager.insertUsertype(ut);

		return "ok";
	}

	public String deleteUserTypeAction(UserType ut) throws UsertypeDeleteException {
		DatabaseManager.deleteUserType(ut);
		return null;

	}

	
	//Seeing if this will work
	public UserType getSelectedUserType() {
		return selectedUserType;
	}

	public void setSelectedUserType(UserType selectedUserType) {
		this.selectedUserType = selectedUserType;
	}
	
}
