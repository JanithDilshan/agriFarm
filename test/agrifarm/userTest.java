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
public class userTest {
    
    public userTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getUsername method, of class user.
     */
   
    
    @Test
    public void testGetUsername() {
        try {
            System.out.println("GetUsername");
            user instance = new user();
            user expResult = null;
            String result = instance.getUsername();
            assertTrue(expResult.equals(result));

            fail(" The test case GetUsername fail.");
        } catch (Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }
        
    }

    /**
     * Test of getPassword method, of class user.
     */
    @Test
    public void testGetPassword() {
        
        try {
            System.out.println("GetPassword");
            user instance = new user();
            user expResult = null;
            String result = instance.getPassword();
            assertTrue(expResult.equals(result));

            fail(" The test case GetPassword fail.");
        } catch (Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }
 
    }

    /**
     * Test of getUserLevel method, of class user.
     */
    @Test
    public void testGetUserLevel() {
        
        try {
            System.out.println("GetUsername");
            user instance = new user();
            user expResult = null;
            String result = instance.getUserLevel();
            assertTrue(expResult.equals(result));

            fail(" The test case GetUsername fail.");

            fail(" The test case GetUsername fail.");
        } catch (Throwable expected) {
            assertEquals(NullPointerException.class, expected.getClass());
        }

    }
    
}
