package edu.umt.jsf.managedbeans;

import edu.umt.db.DatabaseManager;
import edu.umt.db.User;
import edu.umt.exceptions.UserDeleteException;
import edu.umt.exceptions.UserDetailsException;
import edu.umt.exceptions.UserInsertException;
import edu.umt.exceptions.UserUpdateException;
import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.util.List;


@SuppressWarnings("FieldCanBeLocal")
public class UserBackingBean extends SCFBackingBean{
	private Logger log = LoggerFactory.getLogger(UserBackingBean.class);
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
        BigInteger numericPhone = new BigInteger(phoneAsString.replaceAll(
                "[^\\d]", ""));
        this.phone = numericPhone;
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

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public String newUserAction() throws UserInsertException {
		User u = new User();
		u.setFname(this.fname);
		u.setLname(this.lname);
		u.setSchool(this.school);
		u.setDepartment(this.department);
		u.setEmail(this.email);
		try{
			u.setPhone(this.phone);
		}catch(NumberFormatException nfe){
			log.error("Phone number entered: " + u.getPhone() + " was inalid.");
			log.error(nfe.toString());
			throw new UserInsertException("Invalid Phone.");
		}
		
		u.setNetid(this.netid);
		u.setUsertype(DatabaseManager.getUserType(this.usertype));
		try {
			log.debug("Attempting to insert new user.");
			DatabaseManager.insertUser(u);
		} catch (UserInsertException uie) {
			log.error(uie.toString());
			return "new-user";
		}catch(Exception e){
			e.printStackTrace();
		}
		return "new-user-created";
	}

	public String updateUserAction() throws UserUpdateException {
		try {
			DatabaseManager.updateUser(userView);
		} catch (Exception e) {
                    e.printStackTrace();
		}

		return "user-updated";
	}

	public String deleteUserAction() throws UserDeleteException {
		DatabaseManager.deleteUser(userView);
		return "delete-user";
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

		DatabaseManager.updateUser((User)event.getObject());

		FacesMessage m = new FacesMessage("User Edited");
		FacesContext.getCurrentInstance().addMessage(null, m);

	}

	 public void onCancel(RowEditEvent event) {
	 FacesMessage m = new FacesMessage("User Edit Cancelled");
	 FacesContext.getCurrentInstance().addMessage(null, m);
	 }

}
