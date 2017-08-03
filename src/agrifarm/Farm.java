/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrifarm;

/**
 *
 * @author Dilshan
 */
public class Farm implements java.io.Serializable{
    
    private String area;
    private String fields;
    private String id;
    private String name;
    
    
    public Farm(String fName, String fArea){
       this.name=fName;
       this.area=fArea;
    }
    
    public String getName(){
      return name;
  }
  
  public String getArea(){
      return area;
  }
    
   
    
}
