/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ngv.dongg
 */
public class UserDaoTest {
    
    public UserDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inseartUser method, of class UserDao.
     */
   

    /**
     * Test of updateUser method, of class UserDao.
     */
    @Test
    public void testUpdateUser() {
        System.out.println("updateUser ");
        User u = new User("dong nguyen", "1996-04-14", "Kinh", "abc", "nam", "ha noi", "Ab123456789", "1234567891", "123456789");              
        UserDao instance = new UserDao();
        boolean expResult = true;
        boolean result = instance.updateUser(u);
        assertEquals(expResult, result);
        assertTrue(result);

    }
     
}
