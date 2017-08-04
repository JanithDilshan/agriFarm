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
//maduritha
public class Farm implements Serializable {
    
    private String area;
    private String fields;
    private String id;
    private String name;
    private String farm;
    
    
    public Farm(String fName, String fArea, String fID){
        
       this.name=fName;
       this.area=fArea;
       this.id = fID;
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

//  public Farm findFarm(String id) {
//        Farm foundFarm;
//        if (this.getId()== id) {
//            //farm = farm;
//            foundFarm = new Farm(this.getName(),this.getArea(),this.getId());
//        }
//        System.out.println(id);
//        return foundFarm;
//    } 


//Book foundBook= new Book();
//
//        for (Book book : this) {
//            if (book.getAssNo()== accession) {
//                foundBook= book;
//            }
//        }
//        System.out.println(accession);
//        return foundBook;
    
}
