/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrifarm;

import java.io.Serializable;

/**
 *
 * @author IP
 */
public class Field implements Serializable {
    
    private String location;
    private String id;
    private String name;
    private String farmId;
    
    
    public Field(String fName, String fArea, String fID, String fFarmId){
        
       this.name=fName;
       this.location=fArea;
       this.id = fID;
       this.farmId = fFarmId;
    } 
    
    public String getId(){
      return id;
  }
    
    public String getName(){
      return name;
  }
  
  public String getLocation() {
      return location;
  }

    public String getFarmId() {
          return farmId;
    }  
    
}
