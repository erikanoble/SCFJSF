package edu.umt.jsf.managedbeans;

import edu.umt.db.*;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.math.BigInteger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

public class UserBackingBean {
	private List<User> users;
	private User user;
	private int user_id;
	private String fname;
	private String lname;
	private String netid;
	private String department;
	private Integer phone;
	private String email;
	private String school;
	private int usertype;

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

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
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

	public String newUserAction() throws Exception {
		User u = new User();
		u.setFname(this.fname);
		u.setLname(this.lname);
		u.setSchool(this.school);
		u.setDepartment(this.department);
		u.setEmail(this.email);
		u.setPhone(new BigInteger(this.phone.toString()));
		u.setNetid(this.netid);
		u.setUsertype(DatabaseManager.getUserType(this.usertype));
		try {
			DatabaseManager.insertUser(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "new-user-created";
	}

	public String deleteUserAction(User u) throws Exception {
		DatabaseManager.deleteUser(u);
		return "delete-applications";
	}

	//
	// public String editUserAction(RowEditEvent event) throws Exception {
	// User u = new User();
	// u.setFname(this.fname);
	// u.setLname(this.lname);
	// u.setSchool(this.school);
	// u.setDepartment(this.department);
	// u.setEmail(this.email);
	// u.setPhone(new BigInteger(this.phone.toString()));
	// u.setNetid(this.netid);
	// u.setUsertype(DatabaseManager.getUserType(this.usertype));
	//
	// DatabaseManager.updateUser(u);
	//
	// return "user-updated";

	// }

	public void onEdit(RowEditEvent event) {
		User u = (User) event.getObject();
		
		
		DatabaseManager.updateUser(u);
		

		FacesMessage m = new FacesMessage("User Edited");
		FacesContext.getCurrentInstance().addMessage(null, m);

	}

	// public void onCancel(RowEditEvent event) {
	// FacesMessage m = new FacesMessage("User Edit Cancelled");
	// FacesContext.getCurrentInstance().addMessage(null, m);
	// }

}
