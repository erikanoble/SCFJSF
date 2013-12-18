package edu.umt.utils;

/**
 * Created with IntelliJ IDEA.
 * User: erikanoble
 * Date: 10/15/13
 * Time: 1:45 PM
 * To change this template use File | Settings | File Templates.
 */
public enum ApplicationStates {
    APPLIED("APPLIED"), APPROVED_BY_SPONSOR ("APPROVED_BY_SPONSOR"), IN_QUEUE("IN_QUEUE"), SCF_APPROVED("SCF_APPROVED"), SCF_REVISION("SCF_REVISION"), SCF_REJECTED("SCF_REJECTED");

         private String applicationStatus;

        private ApplicationStates(String s) {
            applicationStatus = s;
        }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getApplicationStatus() {
        return applicationStatus;

    }

}
