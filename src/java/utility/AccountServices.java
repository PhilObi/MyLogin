/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import model.User;

/**
 *
 * @author Phillip Obiora
 */
public class AccountServices {
    
    public User login(String username, String password){
        
        if(username.equals("adam") && password.equals("password") ||
                username.equals("betty") && password.equals("password")){
            
            User user = new User(username, null);
            return user;
        }
        else{
            return null;
        }
    }
    
}
