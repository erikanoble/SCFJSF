package edu.umt.jsf.managedbeans;

import edu.umt.db.Application;
import edu.umt.db.DatabaseManager;
import edu.umt.exceptions.ApplicationDeleteException;
import edu.umt.exceptions.ApplicationDetailsException;
import edu.umt.exceptions.ApplicationInsertException;
import edu.umt.exceptions.ApplicationUpdateException;
import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
	private int user;

	private static final int BUFFER_SIZE = 6124;

    public String getFolderToUpload() {
        return folderToUpload;
    }

    public void setFolderToUpload(String folderToUpload) {
        this.folderToUpload = folderToUpload;
    }

    public static int getBufferSize() {
        return BUFFER_SIZE;
    }

    private String folderToUpload;

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

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}



	// TODO: find out why this is duplicating!!!
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
		a.setUser(DatabaseManager.getUser(this.user));


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


    public void applicationFileUploadAction(FileUploadEvent event){
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
        File result = new File(extContext.getRealPath("/home/erikanoble/" + event.getFile().getFileName()));
        System.out.println(extContext.getRealPath("/home/erikanoble/" + event.getFile().getFileName()));

        try{
            FileOutputStream fileOutputStream= new FileOutputStream(result);

            byte[] buffer = new byte [BUFFER_SIZE];

            int bulk;
            InputStream inputStream = event.getFile().getInputstream();
            while(true){
                bulk = inputStream.read(buffer);
                if(bulk<0){
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            inputStream.close();

            FacesMessage msg = new FacesMessage("File Description", "file name: " + event.getFile().getFileName() + "file size: " + event.getFile().getSize() /1024 + "Kb content type: " + event.getFile().getContentType() + "The File was Uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }catch (IOException e){
            e.printStackTrace();

            FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "The Files were not uploaded!", "");
            FacesContext.getCurrentInstance().addMessage(null, error);
        }

    }


//	// TODO: Make upload...
//	public void applicationFileUploadAction(FileUploadEvent event) {
//		FacesMessage msg = new FacesMessage("Successful", event.getFile()
//				.getFileName() + " is uploaded.");
//		FacesContext.getCurrentInstance().addMessage(null, msg);
//	}
//
//	// // TODO: this is to turn it into a byte to store on the database....figure it out
//	public void applicationCopyFileAction(String fileName, InputStream in) {
//		try {
//            /* write the inputStream to a FileOutputStream */
//
//			OutputStream out = new FileOutputStream(new File(destination
//					+ fileName));
//
//			int read = 0;
//			byte[] bytes = new byte[(int) getFile().getSize()];
//
//			while ((read = in.read(bytes)) != -1) {
//				out.write(bytes, 0, read);
//			}
//
//			in.close();
//			out.flush();
//			out.close();
//
//			System.out.println("New File Created!");
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
//	}

}
