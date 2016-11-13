
package project;

import treepackage.*;
import StackAndQueuePackage.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Arrays;

public class UserDB {
    private static int numberOfUsers = 0;
    private User[] userArray;
    private final int DEFAULT_CAPACITY = 10;
     
    
    public UserDB () {
        userArray = new User[DEFAULT_CAPACITY];
    }
    
    public void importUsers (String fileName) {
        Scanner input = new Scanner (System.in);
        String str;
        
        //System.out.println("Import Users ...");
        
        try {
            input = new Scanner (new File (fileName));
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found.");
            System.exit(1);
        }
        
        while (input.hasNextLine()) {
            
            str = input.nextLine();
             //System.out.println(str);
            String[] fields = str.split(",");
            User newUser = new User();
            newUser.parseFields (fields);
            //System.out.println(newUser.getLogin());
            
            
            if (numberOfUsers == userArray.length) {
                User[] newArray = Arrays.copyOf(userArray, numberOfUsers + DEFAULT_CAPACITY);
                userArray = newArray;
            }
            
            userArray[numberOfUsers] = newUser;
            numberOfUsers++;
            
        }

    }   
    
    
    
    public void print(){
        System.out.println(userArray[0]);
    }
    
    public boolean checkLogin(String username, String password){
        
        
        boolean found = false;
        
        for(int x = 0; x < numberOfUsers; x++ ){
      
            if(username.equals(userArray[x].getLogin())){
                
                    if(password.equals(userArray[x].getPassword())){
                        found = true;
                        break;

            }
            else 
                found = false;
        }
        
    }
        return found;
    }
}
