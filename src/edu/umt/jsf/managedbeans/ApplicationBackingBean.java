package edu.umt.jsf.managedbeans;

import edu.umt.db.Application;
import edu.umt.db.DatabaseManager;
import edu.umt.db.User;
import edu.umt.exceptions.ApplicationDeleteException;
import edu.umt.exceptions.ApplicationDetailsException;
import edu.umt.exceptions.ApplicationInsertException;
import edu.umt.exceptions.ApplicationUpdateException;
import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
//new to test
//import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;

@SuppressWarnings("FieldCanBeLocal")
public class ApplicationBackingBean {
	// private Logger log =
	// LoggerFactory.getLogger(ApplicationBackingBean.class);
	private Logger log = Logger.getLogger(ApplicationBackingBean.class);

	private List<Application> applications;
	private int application_id;
	private Application application;
	private Application applicationView;
	private String createdAsString;
	private String index_charge;
	private Double balance;
	private Double request_amount;
	private String equipment_description;
	private Double outside_funds;
	private String use_description;
	private String maintenance_responsibility;
	private String new_connections;
	private String provided_by;
	private String pilot;
	private String pilot_summary;
    private User approvedUser;
	private int userID;
    private User user;
    private byte[] attachment;
    private UploadedFile file;


    public User getApprovedUser() {
        return approvedUser;
    }

    public void setApprovedUser(User approvedUser) {
        this.approvedUser = approvedUser;
    }

    public List<Application> getApplications() {
		return DatabaseManager.getApplications();
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public int getApplication_id() {
		return application_id;
	}

	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Application getApplicationView() {
		return applicationView;
	}

	public void setApplicationView(Application applicationView) {
		this.applicationView = applicationView;
	}

	public String getCreatedAsString() {
		return createdAsString;
	}

	public void setCreatedAsString(String createdAsString) {
		this.createdAsString = createdAsString;
	}

	public String getIndex_charge() {
		return index_charge;
	}

	public void setIndex_charge(String index_charge) {
		this.index_charge = index_charge;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getRequest_amount() {
		return request_amount;
	}

	public void setRequest_amount(Double request_amount) {
		this.request_amount = request_amount;
	}

	public String getEquipment_description() {
		return equipment_description;
	}

	public void setEquipment_description(String equipment_description) {
		this.equipment_description = equipment_description;
	}

	public Double getOutside_funds() {
		return outside_funds;
	}

	public void setOutside_funds(Double outside_funds) {
		this.outside_funds = outside_funds;
	}

	public String getUse_description() {
		return use_description;
	}

	public void setUse_description(String use_description) {
		this.use_description = use_description;
	}

	public String getMaintenance_responsibility() {
		return maintenance_responsibility;
	}

	public void setMaintenance_responsibility(String maintenance_responsibility) {
		this.maintenance_responsibility = maintenance_responsibility;
	}

	public String getNew_connections() {
		return new_connections;
	}

	public void setNew_connections(String new_connections) {
		this.new_connections = new_connections;
	}

	public String getProvided_by() {
		return provided_by;
	}

	public void setProvided_by(String provided_by) {
		this.provided_by = provided_by;
	}

	public String getPilot() {
		return pilot;
	}

	public void setPilot(String pilot) {
		this.pilot = pilot;
	}

	public String getPilot_summary() {
		return pilot_summary;
	}

	public void setPilot_summary(String pilot_summary) {
		this.pilot_summary = pilot_summary;
	}

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String newApplicationAction() throws ApplicationInsertException {

		Application a = new Application();
		a.setIndex_charge(this.index_charge);
		a.setBalance(this.balance);
		a.setRequest_amount(this.request_amount);
		a.setEquipment_description(this.equipment_description);
		a.setOutside_funds(this.outside_funds);
		a.setUse_description(this.use_description);
		a.setMaintenance_responsibility(this.maintenance_responsibility);
		a.setNew_connections(this.new_connections);
		a.setProvided_by(this.provided_by);
		a.setPilot(this.pilot);
		a.setPilot_summary(this.pilot_summary);
		a.setUser(DatabaseManager.getUser(this.userID));
        if(attachment != null){
            a.setAttachment(this.attachment);
        }

		try {
			DatabaseManager.insertApplication(a);
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.debug("I'm testing in the new app method");

		return "list-applications";

	}

	public String updateApplicationAction() throws ApplicationUpdateException {
		log.debug("I'm working here...");
		try {
			DatabaseManager.updateApplication(applicationView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("I returned the applications");
		return "application-updated";

	}

	public String deleteApplicationAction(Application a)
			throws ApplicationDeleteException {
		DatabaseManager.deleteApplication(a);
		return null;
	}

	public String applicationDetailAction() throws ApplicationDetailsException {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		try {
			applicationView = DatabaseManager.getApplication(new Integer(
					request.getParameter("appId")));
		} catch (Exception e) {
			if (applicationView == null)
				throw new ApplicationDetailsException(
						"Could not retrieve application.");
		}
		return "application-details";
	}




	public void handleFileUpload(FileUploadEvent event) {
        this.attachment = event.getFile().getContents();

        FacesMessage msg = new FacesMessage("Successful", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}



    public void viewFileAction(){
        try{
            ByteArrayOutputStream baosPDF = new ByteArrayOutputStream();

            if (applicationView.getAttachment()!=null){
                baosPDF.write(applicationView.getAttachment());

                HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
                response.setContentType("application/pdf");
                response.setHeader("Content-disposition", "attachment; filename=tempPDF.pdf");
                response.setHeader("Cache-Control", "no-cache");
                response.setContentLength(baosPDF.size());
                response.setHeader("Pragma", "public");

                ServletOutputStream sos;
                sos = response.getOutputStream();
                baosPDF.writeTo(sos);
                sos.flush();

                FacesContext.getCurrentInstance().responseComplete();

            } else{
                FacesContext.getCurrentInstance().responseComplete();
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void viewAttachment() throws IOException{
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ByteArrayOutputStream baosPDF = new ByteArrayOutputStream();

        if(applicationView.getAttachment()!=null) baosPDF.write(applicationView.getAttachment());
        ec.responseReset();
        ec.setResponseContentType("application/pdf");
        ec.setResponseContentLength(baosPDF.size());
        ec.addResponseHeader("Content-Disposition", "inline; filename=tempPDF.pdf");

        OutputStream output = ec.getResponseOutputStream();
        baosPDF.writeTo(output);

        FacesContext.getCurrentInstance().responseComplete();

    }

}
