
package project;
import treepackage.*;
import StackAndQueuePackage.*;

public class User {
    private static int numberOfUsers = 0;
    public String login;
    private String firstName;
    private String lastName;
    private String password;
    
    public User () {
        this (null, null, null, null);
    }
    public User (String userLogin, String userFirstN, String userLastN, String userPassword) {
        login = userLogin;
        firstName = userFirstN;
        lastName = userLastN;
        password = userPassword;
        numberOfUsers++;
    }
    
    
    
    @Override
    public String toString () {
        return ("{Login=" + login +
                "\n FirstName=" + firstName +
                "\n LastName=" + lastName +
                "\n Password=" + password + "}");
    }
    
    public void parseFields (String[] fields) {
        login = fields[0];
        firstName = fields[1];
        lastName = fields[2];
        password = fields[3];
    }
    
     public String getLogin(){
        return login;
    }
     
     public String getPassword(){
         return password;
     }
}
