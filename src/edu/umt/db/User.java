package edu.umt.db;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SuppressWarnings("FieldCanBeLocal")
//Todo: Why the squiggle??
public class User {
    private int user_id;
    private String fname;
    private String lname;
    private String netid;
    private String department;
    private BigInteger phone;
    private String phoneAsString;

    private String email;
    private String school;
    private UserType usertype;
    private Set<Application> application;
    private User approvedUser;
    private Timestamp created;
    private List<Application> applicationList;


    private String username;
    private String role;

    public User(org.springframework.security.core.userdetails.User springUser) {
        this.username = springUser.getUsername();
        Iterator iterator = springUser.getAuthorities().iterator();
        while(iterator.hasNext()){
            this.role = new String (((SimpleGrantedAuthority)iterator.next()).getAuthority().toCharArray());
        }
    }


    //////////////////////////
    public User() {
        //To change body of created methods use File | Settings | File Templates.
    }
    //////////////////////////

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id
     *            the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname
     *            the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname
     *            the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the netid
     */
    public String getNetid() {
        return netid;
    }

    /**
     * @param netid
     *            the netid to set
     */
    public void setNetid(String netid) {
        this.netid = netid;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department
     *            the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the phone
     */
    public BigInteger getPhone() {

        return phone;
    }

    /**
     * @param phone
     *            the phone to set
     */
    public void setPhone(BigInteger phone) {

        this.phone = phone;

    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school
     *            the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return the usertype
     */
    public UserType getUsertype() {
        return usertype;
    }

    /**
     * @param usertype
     *            the usertype to set
     */
    public void setUsertype(UserType usertype) {
        this.usertype = usertype;
    }

    /**
     * @return the application
     */
    public Set<Application> getApplication() {
        return application;
    }

    /**
     * @param application
     *            the application to set
     */
    public void setApplication(Set<Application> application) {
        this.application = application;
    }

    public User getApprovedUser() {
        return approvedUser;
    }

    public void setApprovedUser(User approvedUser) {
        this.approvedUser = approvedUser;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public List<Application> getApplicationList() {
        return new ArrayList<Application>(this.application);
    }

    public void setApplicationList(List<Application> applicationList) {
        this.applicationList = applicationList;
    }

    public String getPhoneAsString() {
        return this.phone.toString();
    }

    public void setPhoneAsString(String phoneAsString) {
        BigInteger numericPhone = new BigInteger(phoneAsString.replaceAll(
                "[^\\d]", ""));
        this.phone = numericPhone;
    }

}