/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrifarm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author Dharshana
 * class to handle serialization of data
 */
public class Serialize {
   //serialize given object to the given filename
  Serialize(Object object, String filename) throws IOException
  {
    FileOutputStream out=new FileOutputStream(filename, true);
    ObjectOutputStream oos=new ObjectOutputStream(out);
    oos.writeObject(object);
    out.close();
    System.out.println(filename+" Saved");
  }
}
