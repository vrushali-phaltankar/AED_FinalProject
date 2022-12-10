/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author kunal
 */
public class UserAccountDirectory {
     private ArrayList<UserAccount> userAccountArrayList;

    public UserAccountDirectory() {
        userAccountArrayList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountArrayList() {
        return userAccountArrayList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountArrayList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Employee employee, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role);
        userAccountArrayList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountArrayList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
    
}
