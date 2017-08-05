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
public class RegisterTest {
    
    public RegisterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }


    /**
     * Test of addUser method, of class Register.
     */
    
    @Test
    public void testAddUser() {
        try {
        System.out.println("addUser");
        Register instance = new Register();
        user newUser = new user ("","", "");
        Serialize ser = new Serialize(newUser, null);
        fail("The test case is a prototype.");
        } catch (Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }   
    }

}
