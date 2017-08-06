/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrifarm;
import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;  

/**
 *
 * @author Dilshan
 */
public class user implements Serializable {
    
    private String username;
    private String password;
    private String userLevel;
    
    //user
    public user(String username, String password, String userLevel){
       this.username = username;
       this.password = password;
       this.userLevel = userLevel;
    } 
     
     public user(){
  
    } 
 
     public String getUsername(){
      return username;
  }
     public String getPassword(){
      return password;
  }
     
     public String getUserLevel(){
      return userLevel;
  }
     
    
}


