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
public class Plot implements Serializable {
    public enum plotState {
        EMPTY,
        PLANTED,
        HARVESTED,
        SPROUTED,
        READY_TO_HARVEST
    }
    private String location;
    private String id;
    private String name;
    private String plotState;
    private String currentCrop;
    private String fieldId;
    private String fieldName;
    
    public Plot(String fID, String fName, String fArea, String fPlotState, String fCurrentState, 
            String fFieldId, String fFieldname){
        
       this.name=fName;
       this.location=fArea;
       this.id = fID;
       this.plotState = fPlotState;
       this.currentCrop = fCurrentState;
       this.fieldId = fFieldId;
       this.fieldName= fFieldname;
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
    
    public String getPlotState() {
        return plotState;
    }
    
    public String getCurrentCrop() {
        return currentCrop;
    }
    
    public String getFieldId() {
        return fieldId;
    }  
    
    public String getFieldName() {
          return fieldName;
    }
    
}
