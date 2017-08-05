/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrifarm;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dilshan
 */
public class DataManagementTest {
    
    public DataManagementTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of loadUsers method, of class DataManagement.
     */
    @Test
    public void testLoadUsers() {
        System.out.println("loadUsers");
        DataManagement instance = new DataManagement();
        instance.loadUsers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of auth method, of class DataManagement.
     */
    @Test
    public void testAuth() {
        System.out.println("auth");
        //String username = "";
        //String password = "";
        //DataManagement instance = new DataManagement();

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
        
        System.out.println("login");
        String username = "Janith";
        String password = "123";
        DataManagement instance = new DataManagement();
        instance.auth(username, password);
 
        
        
        
        
        
        
    }

    /**
     * Test of addFarm method, of class DataManagement.
     */
    @Test
    public void testAddFarm() {
        try {
        System.out.println("Add Farm");
        DataManagement instance = new DataManagement();
        Farm newFarm = new Farm ("", "", "", null);
        Serialize ser = new Serialize(newFarm, null);
        fail("The test case is a prototype.");
        } catch (Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }  
        
        
        
        
        
        
    }
    
}
