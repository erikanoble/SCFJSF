package edu.umt.jsf.managedbeans;

import edu.umt.db.*;

import java.util.List;

public class ApplicationBackingBean {
	private List<Application> applications;
	private String index_charge;
	private String balance;
	private String request_amount;
	private String equipment_description;
	private String outside_funds;
	private String use_description;
	private String maintenance_responsibility;
	private String new_connections;
	private String provided_by;
	private String pilot;
	private String pilot_summary;
	private int user;
	
	
	public List<Application> getApplications() {
		return applications;
	}
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	public String getIndex_charge() {
		return index_charge;
	}
	public void setIndex_charge(String index_charge) {
		this.index_charge = index_charge;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getRequest_amount() {
		return request_amount;
	}
	public void setRequest_amount(String request_amount) {
		this.request_amount = request_amount;
	}
	public String getEquipment_description() {
		return equipment_description;
	}
	public void setEquipment_description(String equipment_description) {
		this.equipment_description = equipment_description;
	}
	public String getOutside_funds() {
		return outside_funds;
	}
	public void setOutside_funds(String outside_funds) {
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
	
	public String newApplicationAction() throws Exception{
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
		
		DatabaseManager.insertApplication(a);
		
		return "list-applications";
		
	}
	
	
}
