package edu.umt.jsf.managedbeans;

import edu.umt.db.User;

/**
 * Created with IntelliJ IDEA.
 * User: erikanoble
 * Date: 12/30/13
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginBackingBean extends SCFBackingBean {
    private User user;
    private boolean isAdmin;

    public boolean isAdmin(){
        return user.getUsertype().getDescription().equals("SCF Admin");
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String secureAction(){
        user = super.getCurrentUser();

        return "login";
    }
}
