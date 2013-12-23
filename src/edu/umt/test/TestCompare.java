package edu.umt.test;

import edu.umt.db.DatabaseManager;
import edu.umt.db.UserType;

/**
 * Created with IntelliJ IDEA.
 * User: erikanoble
 * Date: 12/23/13
 * Time: 10:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestCompare{
    public static void main(String[] args){
        UserType admintest = null;
        UserType user_id = null;
             admintest = DatabaseManager.getUserType(3);
             user_id = DatabaseManager.getUserType(3);
//        int admintest = 2;
//        int user_id = 2;
        System.out.println(user_id);
        if (admintest != user_id){
            System.out.println("No match found");
        }else{
            System.out.println("Match Successful");
        }

}
}
