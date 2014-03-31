package edu.umt.jsf.managedbeans;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class GrowlBean {

  	public void save(ActionEvent actionEvent){
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.addMessage(null, new FacesMessage("The growl works?"));
	}
}
