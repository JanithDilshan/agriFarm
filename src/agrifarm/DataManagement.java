/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.  
 */
package agrifarm;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.UUID;
import java.util.Vector;
import javax.swing.DefaultListModel;

/**
 *
 * @author Dilshan
 */
public class DataManagement {
    
 public static String userLevel;
 public static String userName;
 public static boolean isSuccess=false;
 private static final String userDB = "userDB.ser";
 private static final String farmDB="farmDB.ser";
 
 
 Vector Users = new Vector<user>();
 
 
public void loadUsers(){
           
        try{ 
           DefaultListModel<String> model = new DefaultListModel<String>();           
           int count=0; 
           FileInputStream in = new FileInputStream(userDB);
           ObjectInputStream ois;
            try{               
                while(true){
                     ois = new ObjectInputStream(in);
                     user newMember = (user) ois.readObject();
                     model.add(count,newMember.getUsername());
                     Users.add(newMember);
                     count++;
                     }
           
            }catch(EOFException e){
                
            }
            in.close();
          
      }catch(IOException e){
   
      } catch (ClassNotFoundException ex) {
         
      }
       
      
  }


public void auth(String username, String password){
         
        for(int i=0;i<Users.size();i++){
            user books = (user) Users.get(i);
            if(books.getUsername().contains(username) && books.getPassword().contains(password)){
             
                    userName= books.getUsername();
                    userLevel= books.getUserLevel();
                    isSuccess=true;
               
            } else{
               System.out.println("No");
            }
           
        }    
    }

    public void addFarm(String farmName, String farmArea, String uniqueID){
        
        Farm newFarm = new Farm (farmName, farmArea, uniqueID);
        try{
            System.out.println("Adding farm...");
            System.out.println(newFarm);
            Serialize ser = new Serialize(newFarm, farmDB);
            
        }catch(IOException e){
              System.out.println(e);
        }

    }
 
 public DataManagement() {
     
     // Empty constructor
     
 }
    
}
