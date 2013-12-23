package edu.umt.test;

import edu.umt.jsf.managedbeans.ApplicationBackingBean;

/**
 * Created with IntelliJ IDEA.
 * User: erikanoble
 * Date: 12/23/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class BeanTester {
    public static void main(String[] args){
        ApplicationBackingBean a = new ApplicationBackingBean();

        a.isCurrentUserAdmin();
        System.out.println(a.isCurrentUserAdmin());
    }
}
