package edu.umt.jsf.managedbeans;

import com.sun.faces.context.SessionMap;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;

import javax.faces.context.FacesContext;

/**
 * Created with IntelliJ IDEA.
 * User: erikanoble
 * Date: 12/23/13
 * Time: 1:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class SCFBackingBean {
    public User currentUser;
    private boolean isCurrentUserSCFAdmin;
    private boolean isCurrentUserAdmin;
    private boolean isCurrentUserApprover;
    private boolean isCurrentUserApplicant;

    public //*working here*//
    SCFBackingBean(){
        SessionMap sessionMap = (SessionMap) FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        SecurityContextImpl securityContext = (SecurityContextImpl)sessionMap.get("SPRING_SECURITY_CONTEXT");
        User springUser = (User)securityContext.getAuthentication().getPrincipal();
        return new edu.umt.db.User(springUser);
    }

    public User getCurrentUser() {
        return currentUser;
    }

    ;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public boolean isCurrentUserSCFAdmin(){
        //1 is SCF Admin, 2 is Admin, 3 is Approver, 4 is Applicant
         return (currentUser.getUsertype().getUsertype_id() == 1);
    }

    public boolean isCurrentUserAdmin(){
        //1 is SCF Admin, 2 is Admin, 3 is Approver, 4 is Applicant

        //We want to return true
        return (currentUser.getUsertype().getUsertype_id() == 1) || (currentUser.getUsertype().getUsertype_id() == 2);

    }

    public boolean isCurrentUserApprover(){
        //1 is SCF Admin, 2 is Admin, 3 is Approver, 4 is Applicant
        return (currentUser.getUsertype().getUsertype_id() == 1) || (currentUser.getUsertype().getUsertype_id() == 2) || (currentUser.getUsertype().getUsertype_id() == 3);

    }

    public boolean isCurrentUserApplicant(){
        //1 is SCF Admin, 2 is Admin, 3 is Approver, 4 is Applicant

        return (currentUser.getUsertype().getUsertype_id() == 3) || (currentUser.getUsertype().getUsertype_id() == 4);
    }
}
