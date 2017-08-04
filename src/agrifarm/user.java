/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrifarm;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Dilshan
 */
public class user implements Serializable {
    
    private String username;
    private String password;
    
    
     public user(String username, String password){
        
       this.username = username;
       this.password = password;
    } 
    
    public void register(){
        
        
     
    }
    
     public String getUsername(){
      return username;
  }
     public String getPassword(){
      return password;
  }
    
    
    
}


