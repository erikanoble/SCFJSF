package edu.umt.jsf.managedbeans;

import edu.umt.db.*;
import edu.umt.exceptions.*;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.RowEditEvent;

public class UserBackingBean {
	private List<User> users;
	private User user;
	private User userView;
	private int user_id;
	private String fname;
	private String lname;
	private String netid;
	private String department;
	private BigInteger phone;
	private String email;
	private String school;
	private int usertype;
	private String phoneAsString;

	public List<User> getUsers() {
		return DatabaseManager.getUsers();
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUserView() {
		return userView;
	}

	public void setUserView(User userView) {
		this.userView = userView;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getNetid() {
		return netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public BigInteger getPhone() {
		return phone;
	}

	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	public String getPhoneAsString() {
		return phoneAsString;
	}

	public void setPhoneAsString(String phoneAsString) {
		this.phoneAsString = phoneAsString;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getUsertype() {
		return usertype;
	}

	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}

	public String newUserAction() throws UserInsertException {
		User u = new User();
		u.setFname(this.fname);
		u.setLname(this.lname);
		u.setSchool(this.school);
		u.setDepartment(this.department);
		u.setEmail(this.email);
		u.setPhone(this.phone);
		u.setNetid(this.netid);
		u.setUsertype(DatabaseManager.getUserType(this.usertype));
		try {
			DatabaseManager.insertUser(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "new-user-created";
	}

	public String updateUserAction() throws UserUpdateException {
		try {
			DatabaseManager.updateUser(userView);
		} catch (Exception e) {

		}

		return "user-updated";
	}

	public String deleteUserAction(User u) throws UserDeleteException {
		DatabaseManager.deleteUser(u);
		return "delete-applications";
	}

	public String userDetailAction() throws UserDetailsException {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		try {
			userView = DatabaseManager.getUser(new Integer(request
					.getParameter("userId")));
		} catch (Exception e) {
			if (userView == null)
				throw new UserDetailsException("Could not retrieve user.");
		}
		return "user-details";
	}


	public void onEdit(RowEditEvent event) {

		DatabaseManager.updateUser(userView);

		FacesMessage m = new FacesMessage("User Edited");
		FacesContext.getCurrentInstance().addMessage(null, m);

	}

	 public void onCancel(RowEditEvent event) {
	 FacesMessage m = new FacesMessage("User Edit Cancelled");
	 FacesContext.getCurrentInstance().addMessage(null, m);
	 }

}
