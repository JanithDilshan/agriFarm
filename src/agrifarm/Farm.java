/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrifarm;

import java.io.Serializable;

/**
 *
 * @author Dilshan
 */
public class Farm implements Serializable {
    
    private String area;
    private String fields;
    private String id;
    private String name;
    private String farm;
    private String username;
    
    
    public Farm(String fName, String fArea, String fID, String user){
        this.name=fName;
        this.area=fArea;
        this.id = fID;
        this.username = user;
    } 
    
    public String getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
  
    public String getArea(){
        return area;
    }
    
    public String getUser(){
        return username;
    }
}
