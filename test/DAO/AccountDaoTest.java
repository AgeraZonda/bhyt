/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Account;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.MD5;

/**
 *
 * @author Admin
 */
public class AccountDaoTest {
    
    public AccountDaoTest() {
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

    // checkCmnd
    @Test
    public void testCheckcmnd1() {
        System.out.println("checkcmnd trường hợp cmnd có trong csdl.");
        String cmnd = "187713038";
        AccountDao instance = new AccountDao();
        boolean expResult = true;
        boolean result = instance.checkcmnd(cmnd);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckcmnd2() {
        System.out.println("checkcmnd trường hợp CMND không có trong csdl");
        String cmnd = "187713432";
        AccountDao instance = new AccountDao();
        boolean expResult = false;
        boolean result = instance.checkcmnd(cmnd);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckcmnd3() {
        System.out.println("checkcmnd trường hợp CMND sai định dạng");
        String cmnd = "1429502475abc";
        AccountDao instance = new AccountDao();
        boolean expResult = false;
        boolean result = instance.checkcmnd(cmnd);
        assertEquals(expResult, result);

    }
    @Test
    public void testCheckcmnd4() {
        System.out.println("checkcmnd trường hợp CMND null");
        String cmnd = "";
        AccountDao instance = new AccountDao();
        boolean expResult = false;
        boolean result = instance.checkcmnd(cmnd);
        assertEquals(expResult, result);

    }

//  inseartUser
    @Test
    public void testInseartUser() {
        System.out.println("inseartUser");
        Account u = new Account("142950247",MD5.encryption("1234"));
        AccountDao instance = new AccountDao();
        boolean expResult = true;
        boolean result = instance.inseartUser(u);
        assertEquals(expResult, result);

    }

// updatePass
    @Test
    public void testUpdatePass() {
        System.out.println("updatePass");
        String cmnd = "142950247";
        String pass = MD5.encryption("1234");
        AccountDao instance = new AccountDao();
        boolean expResult = false;
        boolean result = instance.updatePass(cmnd, pass);
//        System.out.println("result"+result);
        assertEquals(expResult, result);
    }

    /**
     * Test of login method, of class AccountDao.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String cmnd = "187713038";
        String password = MD5.encryption("1234");
        AccountDao instance = new AccountDao();
        User expResult = new User("187713038");
        User result = instance.login(cmnd, password);
        assertEquals(expResult.getcmnd(), result.getcmnd());
    }
    
}
